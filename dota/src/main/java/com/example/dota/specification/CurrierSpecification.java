package com.example.dota.specification;

import com.example.dota.entity.CurrierEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class CurrierSpecification {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CREATEUSER = "createUser";
    private static final String UPDATEUSER = "updateUser";
    private static final String CREATEDATE = "createDate";
    private static final String UPDATEDATE = "updateDate";

    public static Specification<CurrierEntity> isNotNullId(){
        return  new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNotNull(root.get(ID));
            }
        };
    }

    public static  Specification<CurrierEntity> equalId(Long id){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ID), id);
            }
        };
    }

    public static Specification<CurrierEntity> likeCurrier(String name){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(NAME), "%"+name+"%");
            }
        };
    }

    public static Specification<CurrierEntity> likeCreateUser(String filter){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(CREATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<CurrierEntity> likeUpdateUser(String filter){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(UPDATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<CurrierEntity> equalCreateDateLess(LocalDate date){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<CurrierEntity> equalCreateDateGreater(LocalDate date){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<CurrierEntity> betweenCreateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(CREATEDATE), dateI, dateF);
            }
        };
    }

    public static Specification<CurrierEntity> equalUpdateDateLess(LocalDate date){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<CurrierEntity> equalUpdateDateGreater(LocalDate date){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<CurrierEntity> betweenUpdateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<CurrierEntity>() {
            @Override
            public Predicate toPredicate(Root<CurrierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(UPDATEDATE), dateI, dateF);
            }
        };
    }

}
