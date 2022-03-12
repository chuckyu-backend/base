package com.chuck.base.domain.audit;

import com.chuck.base.domain.IdNamePair;
import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Audit {
  /** 是否有必要调整为ZonedDateTime THINKING */
  private LocalDateTime createWhen = LocalDateTime.now();
  /** 创建人，在修改时需要保持不变 */
  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "createById"))
  @AttributeOverride(name = "name", column = @Column(name = "createByName"))
  private IdNamePair createBy;

  private LocalDateTime modifyWhen = LocalDateTime.now();

  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "modifyById"))
  @AttributeOverride(name = "name", column = @Column(name = "modifyByName"))
  private IdNamePair modifyBy;
}
