package com.example.dota.specification;

import com.example.dota.entity.HeroEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class HeroSpecification {

    private static final String ID = "id";
    private static final String NAMEHERO = "nameHero";

    public static Specification<HeroEntity> isNotNullId(){
        return  new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNotNull(root.get(ID));
            }
        };
    }

    public static  Specification<HeroEntity> equalId(Long id){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ID), id);
            }
        };
    }

    public static Specification<HeroEntity> equalNameHero(String nameHero){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(NAMEHERO), nameHero);
            }
        };
    }
}
