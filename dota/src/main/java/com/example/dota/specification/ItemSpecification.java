package com.example.dota.specification;

import com.example.dota.entity.ItemEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class ItemSpecification {

    private static final String ID = "id";
    private static final String NAMEITEM =  "nameItem";
    private static final String PRICE =  "price";
    private static final String MOVESPEED = "moveSpeed";
    private static final String DAMAGE = "damage";
    private static final String COOLDOWN = "cooldown";
    private static final String INTELIGENCE = "inteligence";
    private static final String STRENGHT = "strenght";
    private static final String AGILITY = "agility";
    private static final String CREATEUSER = "createUser";
    private static final String UPDATEUSER = "updateUser";
    private static final String CREATEDATE = "createDate";
    private static final String UPDATEDATE = "updateDate";

    public static Specification<ItemEntity> isNotNullId(){
        return  new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNotNull(root.get(ID));
            }
        };
    }

    public static  Specification<ItemEntity> equalId(Long id){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ID), id);
            }
        };
    }


    public static Specification<ItemEntity> likeNameItem(String filter){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(NAMEITEM), "%"+filter+"%");
            }
        };
    }

    public static Specification<ItemEntity> likeCreateUser(String filter){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(CREATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<ItemEntity> likeUpdateUser(String filter){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(UPDATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<ItemEntity> equalCreateDateLess(LocalDate date){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<ItemEntity> equalCreateDateGreater(LocalDate date){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<ItemEntity> betweenCreateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(CREATEDATE), dateI, dateF);
            }
        };
    }

    public static Specification<ItemEntity> equalUpdateDateLess(LocalDate date){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<ItemEntity> equalUpdateDateGreater(LocalDate date){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<ItemEntity> betweenUpdateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<ItemEntity>() {
            @Override
            public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(UPDATEDATE), dateI, dateF);
            }
        };
    }



}
