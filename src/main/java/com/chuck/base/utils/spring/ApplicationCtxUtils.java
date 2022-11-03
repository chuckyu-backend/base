package com.chuck.base.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// @Component
@Deprecated
public class ApplicationCtxUtils implements ApplicationContextAware {

  private static ApplicationContext ctx;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    ApplicationCtxUtils.ctx = applicationContext;
  }

  public static Object getBean(String name) {
    return ctx.getBean(name);
  }

  public static <T> T getBean(Class<T> clazz) {
    return ctx.getBean(clazz);
  }
}
