package com.example.dota.service;

import com.example.dota.converter.HeroConverter;
import com.example.dota.converter.SkinConverter;
import com.example.dota.entity.SkinEntity;
import com.example.dota.filter.SkinFilter;
import com.example.dota.repository.SkinRepository;
import com.example.dota.resource.SkinResource;
import com.example.dota.specification.SkinSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SkinService {

    @Autowired
    private SkinRepository skinRepository;

    private SkinConverter converter = new SkinConverter();
    private HeroConverter converterHero = new HeroConverter();

    public List<?> findAll(){
        return converter.listToDto(skinRepository.findAll());
    }

    public List<?> findByFilter(SkinFilter filter) {
        return Collections.singletonList(skinRepository.findAll(getSpecification(filter)));
    }

    public Object findById(Long id) {

        return converter.toOptionalDto(skinRepository.findById(id));

    }

    public Object post(SkinResource resource) {

        return converter.toDto(skinRepository.save(converter.toEntity(resource)));

    }

    public Object update(Long id, SkinResource resource) {

        skinRepository.findById(id);

        resource.setId(id);

        return  converter.toDto(skinRepository.save(converter.toEntity(resource)));

    }

    public void delete(Long id) {
        skinRepository.deleteById(id);
    }

    public void deleteByObject(SkinResource resource) {
        skinRepository.delete(converter.toEntity(resource));
    }

    private Specification<SkinEntity> getSpecification(SkinFilter filter){
        if(filter != null){
            Specification<SkinEntity> specification = Specification.where((filter.getId() == null) ? null : SkinSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(SkinSpecification.equalId(filter.getId()));

            specification = (filter.getName() == null) ? specification : specification.and(SkinSpecification.likeName(filter.getName()));
            specification = (filter.getStyle() == null) ? specification : specification.and(SkinSpecification.likeStyle(filter.getStyle()));
            specification = (filter.getCreateUser() == null) ? specification : specification.and(SkinSpecification.likeCreateUser(filter.getCreateUser()));
            specification = (filter.getUpdateUser() == null) ? specification : specification.and(SkinSpecification.likeUpdateUser(filter.getUpdateUser()));

            specification = (filter.getPrice() == null) ? specification : specification.and(SkinSpecification.equalPrice(filter.getPrice()));


            if(filter.getCreateDateI() != null && filter.getCreateDateF() != null){
                specification = specification.and(SkinSpecification.betweenCreateDate(filter.getCreateDateI(), filter.getCreateDateF()));
            }else{
                specification = (filter.getCreateDate() == null) ? specification : specification.and(SkinSpecification.equalCreateDateLess(filter.getCreateDate()));
                specification = (filter.getCreateDate() == null) ? specification : specification.and(SkinSpecification.equalCreateDateGreater(filter.getCreateDate()));
            }

            if(filter.getUpdateDateI() != null && filter.getUpdateDateF() != null){
                specification = specification.and(SkinSpecification.betweenUpdateDate(filter.getUpdateDateI(), filter.getUpdateDateF()));
            }else{
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(SkinSpecification.equalUpdateDateLess(filter.getUpdateDate()));
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(SkinSpecification.equalUpdateDateGreater(filter.getUpdateDate()));
            }
            return specification;
        }else{
            return null;
        }
    }


}
