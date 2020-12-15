package com.example.dota.specification;

import com.example.dota.entity.HeroEntity;
import com.example.dota.entity.ItemEntity;
import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
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
    private static final String COOLDOWN = "cooldown";
    private static final String MOVESPEED = "moveSpeed";
    private static final String DAMAGE = "damage";
    private static final String INTELIGENCE = "inteligence";
    private static final String STRENGHT = "strenght";
    private static final String AGILITY = "agility";


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


}
