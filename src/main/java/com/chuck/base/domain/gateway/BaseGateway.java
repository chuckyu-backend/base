package com.chuck.base.domain.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BaseGateway<T,P> {
    void create();

    //  Query
    T find(String name);

    T find(int id);

    Page<T> page(P cond, PageRequest pageCond);

    //    Update
    void update();


    //    Delete
    void delete(String name);

    void delete(int id);


}
