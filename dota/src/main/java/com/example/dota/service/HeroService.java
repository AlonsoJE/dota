package com.example.dota.service;

import com.example.dota.converter.HeroConverter;
import com.example.dota.entity.HeroEntity;
import com.example.dota.filter.HeroFilter;
import com.example.dota.repository.HeroRepository;
import com.example.dota.resource.HeroResource;
import com.example.dota.resource.ItemHeroResource;
import com.example.dota.specification.HeroSpecification;
import com.example.dota.valueobjects.StatsItemResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    private HeroConverter heroConverter = new HeroConverter();

    // ↓ BUSINESS RULES ↓

    BinaryOperator<Integer> soma = (v1, v2) -> {return v1 + v2;};

    public StatsItemResource verifyAllStats(Long id, HeroResource hero){

        StatsItemResource statsItem = new StatsItemResource();

        statsItem.setTotalAgility(verifyStatsAgility(id, hero));
        statsItem.setTotalDamage(verifyStatsDamage(id, hero));
        statsItem.setTotalInteligence(verifyStatsInteligence(id, hero));
        statsItem.setTotalMoveSpeed(verifyStatsMoveSpeed(id, hero));
        statsItem.setTotalStrenght(verifyStatsStrenght(id, hero));
        statsItem.setTotalAmount(verifyAmount(id, hero));

        return statsItem;

    }

    public Integer ruleStatsSum(List<ItemHeroResource> hero, Function<ItemHeroResource, Integer> function){
        return hero.stream().map(function).reduce(this.soma).get();
    }

    public BigDecimal ruleStatsSumMoney(List<ItemHeroResource> hero, Function<ItemHeroResource, BigDecimal> function){
        return hero.stream().map(function).reduce((e, n) -> {return e.add(n);}).get();
    }

    public Integer verifyStatsAgility(Long id, HeroResource hero){
        Function<ItemHeroResource, Integer> justValue = (e) -> {return e.getItem().getAgility();};
        return ruleStatsSum(hero.getItemHero(), justValue);
    }

    public Integer verifyStatsStrenght(Long id, HeroResource hero){
        Function<ItemHeroResource, Integer> justValue = (e) -> {return e.getItem().getStrenght();};
        return ruleStatsSum(hero.getItemHero(), justValue);
    }

    public Integer verifyStatsInteligence(Long id, HeroResource hero){
        Function<ItemHeroResource, Integer> justValue = (e) -> {return e.getItem().getInteligence();};
        return ruleStatsSum(hero.getItemHero(), justValue);
    }

    public Integer verifyStatsDamage(Long id, HeroResource hero){
        Function<ItemHeroResource, Integer> justValue = (e) -> {return e.getItem().getDamage();};
        return ruleStatsSum(hero.getItemHero(), justValue);
    }

    public Integer verifyStatsMoveSpeed(Long id, HeroResource hero){
        Function<ItemHeroResource, Integer> justValue = (e) -> {return e.getItem().getMoveSpeed();};
        return ruleStatsSum(hero.getItemHero(), justValue);
    }

    public BigDecimal verifyAmount(Long id, HeroResource hero){
        Function<ItemHeroResource, BigDecimal> justValue = (e) -> {return e.getItem().getPrice();};
        return ruleStatsSumMoney(hero.getItemHero(), justValue);
    }


//    public List<?> mapForNick(List<HeroResource> list){
//
//        List<String> listB = new ArrayList<>();

    //FOREACH
//        list.stream().forEach((e) -> {
//            System.out.println(e.getNickNameHero());
//        });

    //MAP
//        list.stream().map((e) -> {
//            return e.getRealName().toUpperCase();
//        } ).forEach((e) -> {
//            listB.add(e);
//        });

    //FILTER
//        list.stream().filter((e) -> {
//           return e.getRealName().toLowerCase().contains("xin");
//        }).map((e) ->{
//          return "Resquicio flamejante!" + e.getNickNameHero();
//        }).forEach((e) ->{
//            listB.add(e);
//        });
//
//        return listB;
//    }

    //↓ BASIC METHODS ↓

    public List<?> findAll(){

        List<HeroResource> list = heroConverter.listToDto(heroRepository.findAll());

        return list;
    }

    public Object post(HeroResource resource) {

        return heroConverter.toDto(heroRepository.save(heroConverter.toEntity(resource)));

    }

    public Object update(Long id, HeroResource resource) {

        heroRepository.findById(id);

        resource.setId(id);

        return  heroConverter.toDto(heroRepository.save(heroConverter.toEntity(resource)));

    }

    public HeroResource findById(Long id) {

        HeroResource hero = new HeroResource();

        hero = heroConverter.toDto(heroRepository.findById(id));

        if(id != null && id != 0){
            verifyAllStats(id, hero);
        }
        return hero;

    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    public void deleteByObject(HeroResource resource) {
        heroRepository.delete(heroConverter.toEntity(resource));
    }

    public List<?> findByFilter(HeroFilter heroFilter) {
        return heroConverter.listToDto(heroRepository.findAll(getSpecification(heroFilter)));
    }

    private Specification<HeroEntity> getSpecification(HeroFilter filter){
        if(filter != null){
            Specification<HeroEntity> specification = Specification.where((filter.getId() == null) ? null : HeroSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(HeroSpecification.equalId(filter.getId()));
            specification = (filter.getNameHero() == null) ? specification : specification.and(HeroSpecification.likeNameHero(filter.getNameHero()));
            specification = (filter.getNickNameHero() == null) ? specification : specification.and(HeroSpecification.likelNickNameHero(filter.getNickNameHero()));
            specification = (filter.getRealName() == null) ? specification : specification.and(HeroSpecification.likeRealNameHero(filter.getRealName()));
            specification = (filter.getCreateUser() == null) ? specification : specification.and(HeroSpecification.likeCreateUser(filter.getCreateUser()));
            specification = (filter.getUpdateUser() == null) ? specification : specification.and(HeroSpecification.likeUpdateUser(filter.getUpdateUser()));
            specification = (filter.getClassTypeEnum() == null) ? specification : specification.and(HeroSpecification.equalClassType(filter.getClassTypeEnum()));
            specification = (filter.getFigthTypeEnum() == null) ? specification : specification.and(HeroSpecification.equalFigthType(filter.getFigthTypeEnum()));


            if(filter.getCreateDateI() != null && filter.getCreateDateF() != null){
                specification = specification.and(HeroSpecification.betweenCreateDate(filter.getCreateDateI(), filter.getCreateDateF()));
            }else{
                specification = (filter.getCreateDate() == null) ? specification : specification.and(HeroSpecification.equalCreateDateLess(filter.getCreateDate()));
                specification = (filter.getCreateDate() == null) ? specification : specification.and(HeroSpecification.equalCreateDateGreater(filter.getCreateDate()));
            }

            if(filter.getUpdateDateI() != null && filter.getUpdateDateF() != null){
                specification = specification.and(HeroSpecification.betweenUpdateDate(filter.getUpdateDateI(), filter.getUpdateDateF()));
            }else{
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(HeroSpecification.equalUpdateDateLess(filter.getUpdateDate()));
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(HeroSpecification.equalUpdateDateGreater(filter.getUpdateDate()));
            }
            return specification;
        }else{
            return null;
        }
    }

}
