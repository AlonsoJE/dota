package com.example.dota.specification;

import com.example.dota.entity.SkinEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SkinSpecification {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String STYLE = "style";
    private static final String CREATEUSER = "createUser";
    private static final String UPDATEUSER = "updateUser";
    private static final String CREATEDATE = "createDate";
    private static final String UPDATEDATE = "updateDate";

    public static Specification<SkinEntity> equalId(Long id){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ID), id);
            }
        };
    }

    public static Specification<SkinEntity> isNotNullId(){
        return  new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNotNull(root.get(ID));
            }
        };
    }

    public static Specification<SkinEntity> likeName(String name){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(NAME), "%"+name+"%");
            }
        };
    }

    public static Specification<SkinEntity> likeStyle(String string){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(STYLE), "%"+string+"%");
            }
        };
    }

    public static Specification<SkinEntity> equalPrice(BigDecimal bigDecimal){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(PRICE), bigDecimal);
            }
        };
    }


    public static Specification<SkinEntity> likeCreateUser(String filter){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(CREATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<SkinEntity> likeUpdateUser(String filter){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(UPDATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<SkinEntity> equalCreateDateLess(LocalDate date){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<SkinEntity> equalCreateDateGreater(LocalDate date){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<SkinEntity> betweenCreateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(CREATEDATE), dateI, dateF);
            }
        };
    }

    public static Specification<SkinEntity> equalUpdateDateLess(LocalDate date){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<SkinEntity> equalUpdateDateGreater(LocalDate date){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<SkinEntity> betweenUpdateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<SkinEntity>() {
            @Override
            public Predicate toPredicate(Root<SkinEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(UPDATEDATE), dateI, dateF);
            }
        };
    }



}
