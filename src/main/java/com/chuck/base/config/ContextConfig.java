package com.chuck.base.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chuck
 * @since 7/5/2021
 * @version 0.0.1
 * @apiNote
 */
// @Configuration
// @EnableWebMvc
// @EnableTransactionManagement(
//    mode = AdviceMode.PROXY,
//    proxyTargetClass = false,
//    order = Ordered.LOWEST_PRECEDENCE)
@Deprecated
public class ContextConfig implements WebMvcConfigurer {

  //  @Value("${com.chuck.fileLocation}")
  //  private String fileLocation;

  //  @Autowired private StorageProperties storageProperties;

  //    @Bean
  //    public LocaleResolver localeResolver() {
  //        return new AcceptHeaderLocaleResolver();
  //    }

  //    @Override
  //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //
  // registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources/"
  // );
  //        registry.addResourceHandler("/files/**").addResourceLocations("classpath:/static/" );
  //    缓存静态内容
  //
  // registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources/"
  // ).setCachePeriod(365*24*60*60);
  //    启用Gzip压缩
  //
  // registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources/"
  // ).resourceChain(true).addResolver(new GzipResourceResolver()).addResolver(new
  // PathResourceResolver());

  // registry.addResourceHandler(ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
  //            .toUriString()).addResourceLocations("file:"+storageProperties.getFileLocation());
  //    }
}
