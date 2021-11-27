package com.chuck.base.domain.core;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


/**
 * Chuck 26/9/21 10:20
 */
@MappedSuperclass
@Getter
@Setter
@Access(AccessType.FIELD)
public abstract class IdentifiedDomainObject implements Serializable {

    /**
     * 未持久化的实体id为null
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // protected int getId() {
    // return this.id;
    // }

    // protected void setId(int anId) {
    // this.id = anId;
    // }
    protected abstract String getName();

    public IdNamePair identify(){
        return new IdNamePair(this.getId(),this.getName());
    }
}