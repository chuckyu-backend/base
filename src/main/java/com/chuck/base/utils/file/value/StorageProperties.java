package com.chuck.base.utils.file.value;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @since 2021/8/25
 * @version 0.0.1
 * @apiNote Value Object
 */
@ConfigurationProperties(prefix = "com.chuck")
@Configuration
@Data
public class StorageProperties {

  private String fileLocation;
}
