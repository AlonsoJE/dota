package com.example.dota.service;

import com.example.dota.entity.SkinEntity;
import com.example.dota.repository.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinService {

    @Autowired
    private SkinRepository skinRepository;

    public List<?> findAll(){
        return skinRepository.findAll();
    }

    public Object post(SkinEntity skinEntity) {

        return skinRepository.save(skinEntity);

    }

    public Object update(Long id, SkinEntity skinEntity) {

        skinRepository.findById(id);

        skinEntity.setId(id);

        return  skinRepository.save(skinEntity);

    }


    public Object findById(Long id) {

        return skinRepository.findById(id);

    }

    public void delete(Long id) {
        skinRepository.deleteById(id);
    }

    public void deleteByObject(SkinEntity s) {
        skinRepository.delete(s);
    }

//    public List<Object> findByFilter(SkinEntity skinEntity) {
//        return Collections.singletonList(skinRepository.findAll(getSpecification(skinEntity)));
//    }
//
//    private Specification<HeroEntity> getSpecification(HeroFilter filter){
//        if(filter != null){
//            Specification<HeroEntity> specification = Specification.where((filter.getId() == null) ? null : HeroSpecification.isNotNullId());
//
//            specification = (filter.getId() == null) ? specification : specification.and(HeroSpecification.equalId(filter.getId()));
//            specification = (filter.getNameHero() == null) ? specification : specification.and(HeroSpecification.likeNameHero(filter.getNameHero()));
//            specification = (filter.getNickNameHero() == null) ? specification : specification.and(HeroSpecification.likelNickNameHero(filter.getNickNameHero()));
//            specification = (filter.getRealName() == null) ? specification : specification.and(HeroSpecification.likeRealNameHero(filter.getRealName()));
//            specification = (filter.getCreateUser() == null) ? specification : specification.and(HeroSpecification.likeCreateUser(filter.getCreateUser()));
//            specification = (filter.getClassTypeEnum() == null) ? specification : specification.and(HeroSpecification.equalClassType(filter.getClassTypeEnum()));
//            specification = (filter.getFigthTypeEnum() == null) ? specification : specification.and(HeroSpecification.equalFigthType(filter.getFigthTypeEnum()));
//
//
//            if(filter.getCreateDateI() != null && filter.getCreateDateF() != null){
//                specification = specification.and(HeroSpecification.betweenCreateDate(filter.getCreateDateI(), filter.getCreateDateF()));
//            }else{
//                specification = (filter.getCreateDate() == null) ? specification : specification.and(HeroSpecification.equalCreateDateLess(filter.getCreateDate()));
//                specification = (filter.getCreateDate() == null) ? specification : specification.and(HeroSpecification.equalCreateDateGreater(filter.getCreateDate()));
//            }
//
//            if(filter.getUpdateDateI() != null && filter.getUpdateDateF() != null){
//                specification = specification.and(HeroSpecification.betweenUpdateDate(filter.getUpdateDateI(), filter.getUpdateDateF()));
//            }else{
//                specification = (filter.getUpdateDate() == null) ? specification : specification.and(HeroSpecification.equalUpdateDateLess(filter.getUpdateDate()));
//                specification = (filter.getUpdateDate() == null) ? specification : specification.and(HeroSpecification.equalUpdateDateGreater(filter.getUpdateDate()));
//            }
//            return specification;
//        }else{
//            return null;
//        }
//    }
//
//
}
