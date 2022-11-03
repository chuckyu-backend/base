package com.chuck.base.utils.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @version 0.0.1
 * @apiNote Value Object
 * @since 2021/8/25
 */
public interface StorageService {

  void init();

  String store(MultipartFile file);

  String storeAndRename(MultipartFile file, String newName);

  String storeElseAndRename(MultipartFile file, Path dir, String newName);

  Stream<Path> loadAll();

  Path load(String filename);

  Path loadFromElse(Path dir, String filename);

  Resource loadAsResource(String filename);

  Resource loadFromElseAsResource(Path dir, String filename);

  void deleteAll();

  void delete(Path path);
}
