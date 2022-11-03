package com.chuck.base.utils.file;

import com.chuck.base.utils.file.value.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @since 2021/8/25
 * @version 0.0.1
 * @apiNote Value Object
 */
@Service
@Slf4j
@ConditionalOnProperty(prefix = "com.chuck", name = "uploadDir")
public class SimpleStorageServiceImpl implements StorageService {

  private final Path rootLocation;

  @Autowired
  public SimpleStorageServiceImpl(StorageProperties properties) {
    this.rootLocation = Paths.get(properties.getFileLocation());
  }

  @Override
  @PostConstruct
  public void init() {
    try {
      Files.createDirectories(rootLocation);
    } catch (IOException e) {
      throw new RuntimeException("Cound not initialize storage location", e);
    }
  }

  @Override
  public String store(MultipartFile file) {
    String filename = StringUtils.cleanPath(file.getOriginalFilename());
    this.storeAndRename(file, filename);
    return filename;
  }

  @Override
  public String storeAndRename(MultipartFile file, String newName) {
    return this.storeElseAndRename(file, this.rootLocation, newName);
  }

  @Override
  public String storeElseAndRename(MultipartFile file, Path dir, String newName) {
    try {
      if (file.isEmpty()) {
        throw new RuntimeException("Failed to store empty file " + newName);
      }
      if (newName.contains("..")) {
        throw new RuntimeException(
            "Cannot store file with relatvie path outside current directory " + newName);
      }
      try (InputStream input = file.getInputStream()) {
        Files.copy(input, dir.resolve(newName), StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException e) {
      log.error(e.getMessage());
      throw new RuntimeException(
          "Failed to store file " + newName + ",cause: " + e.getMessage(), e);
    }
    return newName;
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.rootLocation, 1)
          .filter(path -> !path.equals(this.rootLocation))
          .map(this.rootLocation::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read stored files", e);
    }
  }

  @Override
  public Path load(String filename) {
    return rootLocation.resolve(filename);
  }

  @Override
  public Path loadFromElse(Path dir, String filename) {
    return dir.resolve(filename);
  }

  @Override
  public Resource loadAsResource(String filename) {
    try {
      Path file = load(filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read file " + filename);
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Could not read file " + filename, e);
    }
  }

  @Override
  public Resource loadFromElseAsResource(Path dir, String filename) {
    try {
      Path file = loadFromElse(dir, filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read file " + filename);
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Could not read file " + filename, e);
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(rootLocation.toFile());
  }

  @Override
  public void delete(Path path) {
    try {
      Files.deleteIfExists(path);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
