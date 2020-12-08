package com.example.dota.service;

import com.example.dota.entity.HeroEntity;
import com.example.dota.filter.HeroFilter;
import com.example.dota.repository.HeroRepository;
import com.example.dota.specification.HeroSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<HeroEntity> findAll(){
        return heroRepository.findAll();
    }

    public Object post(HeroEntity heroEntity) {

        return heroRepository.save(heroEntity);

    }

    public Object update(Long id, HeroEntity heroEntity) {

        heroRepository.findById(id);

        heroEntity.setId(id);

        return  heroRepository.save(heroEntity);

    }


    public Object findById(Long id) {

        return heroRepository.findById(id);

    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    public void deleteByObject(HeroEntity heroEntity) {
        heroRepository.delete(heroEntity);
    }

    public List<Object> findByFilter(HeroFilter heroFilter) {
        return Collections.singletonList(heroRepository.findAll(getSpecification(heroFilter)));
    }

    private Specification<HeroEntity> getSpecification(HeroFilter filter){
        if(filter != null){
            Specification<HeroEntity> specification = Specification.where((filter.getId() == null) ? null : HeroSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(HeroSpecification.equalId(filter.getId()));
            specification = (filter.getNameHero() == null) ? specification : specification.and(HeroSpecification.likeNameHero(filter.getNameHero()));
            specification = (filter.getNickNameHero() == null) ? specification : specification.and(HeroSpecification.likelNickNameHero(filter.getNickNameHero()));
            specification = (filter.getRealName() == null) ? specification : specification.and(HeroSpecification.likeRealNameHero(filter.getRealName()));
            specification = (filter.getCreateUser() == null) ? specification : specification.and(HeroSpecification.likeCreateUser(filter.getCreateUser()));
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
