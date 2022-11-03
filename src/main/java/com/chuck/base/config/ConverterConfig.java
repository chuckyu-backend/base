package com.chuck.base.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {

  @Resource @Setter private ObjectMapper objectMapper;
  /** 仅支持Json的MessageConverters */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new SourceHttpMessageConverter<>());
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    jsonConverter.setSupportedMediaTypes(
        Arrays.asList(new MediaType("application", "json"), new MediaType("text", "json")));
    jsonConverter.setObjectMapper(this.objectMapper);
    converters.add(jsonConverter);
    converters.add(new ResourceHttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_JSON);
  }
}
