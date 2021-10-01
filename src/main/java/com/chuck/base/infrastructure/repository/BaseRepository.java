package com.chuck.base.infrastructure.repository;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * 自定义基础Repository，用于定制打算暴露的方法
 * 
 * // @NoRepositoryBean表示不要自动创建实现类
 * 
 * @author Chuck
 * @since 8/8/2021
 * @version 0.0.1
 * @apiNote Value Object
 **/

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID>, QuerydslPredicateExecutor<T> {

    // 打算暴露的方法

    Iterable<T> findAll(Pageable sort);

    <S extends T> S save(S entity);

    <S extends T> S save(Iterable<S> entities);

    // 1、使用QueryDSL的简单例子
    // goe='greater than or equals'
    // BooleanExpression booleanExpression = QEmployee.employee.salary.goe(3000);
    // OrderSpecifier<Integer> orderSpecifier = QEmployee.employee.salary.asc();
    // Iterable<Employee> employees2 = repo.findAll(booleanExpression,
    // orderSpecifier);

    // BooleanExpression booleanExpression2 = QEmployee.employee.dept.in("IT",
    // "Admin").and(
    // QEmployee.employee.salary.between(3000, 5000));
    // Iterable<Employee> employee3 = repo.findAll(booleanExpression2);

    // BooleanExpression booleanExpression3 = QEmployee.employee.name.eq("Mike");
    // Optional<Employee> opt = repo.findOne(booleanExpression3);

    // BooleanBuilder booleanBuilder = new BooleanBuilder();
    // if(firstname!=null&&!firstname.isEmpty())
    // {
    // booleanBuilder.and(QPerson.person.firstname.eq(firstname));
    // }
    // if(lastname!=null&&!lastname.isEmpty())
    // {
    // booleanBuilder.and(QPerson.person.lastname.eq(lastname));
    // }
    // if(budget!=null&&budget!=0)
    // {
    // booleanBuilder.and(QPerson.person.budget.goe(budget));
    // }
    // if(dobLimit!=null&&dobLimit!=0)
    // {
    // booleanBuilder.and(QPerson.person.dob.before(Instant.ofEpochSecond(dobLimit)));
    // }
    // return
    // personRepository.findAll(booleanBuilder.getValue(),PageRequest.of(page,size,Sort.by(Sort.Direction.ASC,"id")));
    // }

    // 2、特殊用法
    // @GetMapping("/simplified")
    // public Page<Person> getPersonsSimplified(
    // @QuerydslPredicate(root = Person.class) Predicate predicate,
    // @RequestParam(name = "page", defaultValue = "0") int page,
    // @RequestParam(name = "size", defaultValue = "500") int size) {

    // return personRepository.findAll(predicate,
    // PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
    // }

    // 3、参考用法
    // QUserRolePo userRolePo = QUserRolePo.userRolePo;

    // QUserPo userPo = QUserPo.userPo;

    // JPAQuery finalQuery = jpaQueryFactory.select(userRolePo.id,
    // userRolePo.roleId, userPo.id, userPo.code, userPo.name)

    // .from(userRolePo, userPo)

    // .where(userRolePo.userId.eq(userPo.id).and(userRolePo.roleId.eq(qo.getRoleId())))

    // .offset((qo.getPageNo() - 1) * qo.getPageSize())

    // .limit(qo.getPageSize());
    // long total = finalQuery.fetchCount();

    // List fetch = finalQuery.fetch();

    // 4、参考用法
    // JPAQuery finalQuery =selectFromService

    // .leftJoin(userRolePo).on(userRolePo.userId.eq(userPo.id))

    // .leftJoin(departmentPo).on(userPo.dptId.eq(departmentPo.id))

    // .where(predicates.toArray(newPredicate[]{}));

}
