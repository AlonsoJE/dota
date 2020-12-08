package com.example.dota.specification;

import com.example.dota.entity.HeroEntity;
import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class HeroSpecification {

    private static final String ID = "id";
    private static final String NAMEHERO = "nameHero";
    private static final String NICKNAMEHERO = "nickNameHero";
    private static final String REALNAMEHERO = "realName";
    private static final String FIGTHTYPE = "figthTypeEnum";
    private static final String CLASSTYPE = "classTypeEnum";
    private static final String CREATEUSER = "createUser";
    private static final String UPDATEUSER = "updateUser";
    private static final String CREATEDATE = "createDate";
    private static final String UPDATEDATE = "updateDate";


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

    public static  Specification<HeroEntity> equalClassType(ClassTypeEnum filter){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(String.valueOf(CLASSTYPE)), filter);
            }
        };
    }

    public static  Specification<HeroEntity> equalFigthType(FigthTypeEnum filter){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(String.valueOf(FIGTHTYPE)), filter);
            }
        };
    }



    public static Specification<HeroEntity> likeNameHero(String nameHero){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(NAMEHERO), "%"+nameHero+"%");
            }
        };
    }

    public static Specification<HeroEntity> likelNickNameHero(String filter){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(NICKNAMEHERO), "%"+filter+"%");
            }
        };
    }

    public static Specification<HeroEntity> likeRealNameHero(String filter){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(REALNAMEHERO), "%"+filter+"%");
            }
        };
    }

    public static Specification<HeroEntity> likeCreateUser(String filter){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(CREATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<HeroEntity> likeUpdateUser(String filter){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(UPDATEUSER), "%"+filter+"%");
            }
        };
    }

    public static Specification<HeroEntity> equalCreateDateLess(LocalDate date){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<HeroEntity> equalCreateDateGreater(LocalDate date){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(CREATEDATE), date);
            }
        };
    }

    public static Specification<HeroEntity> betweenCreateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(CREATEDATE), dateI, dateF);
            }
        };
    }

    public static Specification<HeroEntity> equalUpdateDateLess(LocalDate date){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<HeroEntity> equalUpdateDateGreater(LocalDate date){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(UPDATEDATE), date);
            }
        };
    }

    public static Specification<HeroEntity> betweenUpdateDate(LocalDate dateI, LocalDate dateF){
        return new Specification<HeroEntity>() {
            @Override
            public Predicate toPredicate(Root<HeroEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(UPDATEDATE), dateI, dateF);
            }
        };
    }


}
