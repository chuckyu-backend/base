package com.chuck.base.domain.core;

/** Chuck 26/9/21 10:19 */
public interface IdentifiedEntity<T> {

  /**
   * 实体整体级别上的校验
   *
   * @param aHandler
   */
  //  public void validate(ValidationNotificationHandler aHandler);

  //  public void complete();

  T identity();

  default boolean equal(T another) {
    return identity().equals(another);
  }
}
