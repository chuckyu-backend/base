package com.chuck.base.domain.audit;

import com.chuck.base.domain.IdNamePair;
import java.time.ZonedDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import lombok.Value;

/**
 * @description
 * @author: Chuck
 * @date: 1/15/2022 4:49 PM
 */
@Value
public class Auditable {
  /** 是否有必要调整为ZonedDateTime THINKING */
  private ZonedDateTime createWhen = ZonedDateTime.now();
  /** 创建人，在修改时需要保持不变 */
  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "createById"))
  @AttributeOverride(name = "name", column = @Column(name = "createByName"))
  private IdNamePair createBy;

  private ZonedDateTime modifyWhen = ZonedDateTime.now();

  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "modifyById"))
  @AttributeOverride(name = "name", column = @Column(name = "modifyByName"))
  private IdNamePair modifyBy;
}
