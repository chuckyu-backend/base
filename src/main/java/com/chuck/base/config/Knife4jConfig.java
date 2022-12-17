package com.chuck.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @author: Chuck
 * @date: 4/28/2022 11:36 AM
 */
@Configuration
@EnableWebMvc
public class Knife4jConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry
        .addResourceHandler("webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
  }
}
