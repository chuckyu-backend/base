package com.chuck.base.domain.core;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Chuck 26/9/21 10:20
 */
@MappedSuperclass
@Getter
@Setter
public abstract class IdentifiedDomainObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // protected int getId() {
    // return this.id;
    // }

    // protected void setId(int anId) {
    // this.id = anId;
    // }
}