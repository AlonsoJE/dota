package com.example.dota.specification;

import com.example.dota.entity.ItemHero;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class ItemHeroSpecification {

    private static final String ID = "id";
    private static final String CREATEUSER = "createUser";
    private static final String UPDATEUSER = "updateUser";
    private static final String CREATEDATE = "createDate";
    private static final String UPDATEDATE = "updateDate";

    public static Specification<ItemHero> equalId(Long id){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ID), id);
            }
        };
    }

    public static Specification<ItemHero> isNotNullId(){
        return  new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNotNull(root.get(ID));
            }
        };
    }

    public static Specification<ItemHero> likeCreateUser(String filter){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(CREATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<ItemHero> likeUpdateUser(String filter){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(UPDATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<ItemHero> equalCreateDateLess(LocalDate date){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<ItemHero> equalCreateDateGreater(LocalDate date){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<ItemHero> betweenCreateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(CREATEDATE), dateI, dateF);
            }
        };
    }

    public static Specification<ItemHero> equalUpdateDateLess(LocalDate date){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<ItemHero> equalUpdateDateGreater(LocalDate date){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<ItemHero> betweenUpdateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<ItemHero>() {
            @Override
            public Predicate toPredicate(Root<ItemHero> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(UPDATEDATE), dateI, dateF);
            }
        };
    }


}
