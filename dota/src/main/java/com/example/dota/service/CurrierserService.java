package com.example.dota.service;

import com.example.dota.converter.CurrierConverter;
import com.example.dota.entity.CurrierEntity;
import com.example.dota.filter.CurrierFilter;
import com.example.dota.repository.CurrierRepository;
import com.example.dota.resource.CurrierResource;
import com.example.dota.specification.CurrierSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CurrierserService {

    @Autowired
    private CurrierRepository currierRepository;

    CurrierConverter converter = new CurrierConverter();

    public List<?> findAll(){
        return converter.listToDto(currierRepository.findAll());
    }

    public Object post(CurrierResource resource) {

        return converter.toDto(currierRepository.save(converter.toEntity(resource)));

    }

    public Object update(Long id, CurrierResource resource) {

        currierRepository.findById(id);

        resource.setId(id);

        return  converter.toDto(currierRepository.save(converter.toEntity(resource)));

    }


    public Object findById(Long id) {

        return converter.toOptionalDto(currierRepository.findById(id));

    }

    public void delete(Long id) {
        currierRepository.deleteById(id);
    }

    public void deleteByObject(CurrierResource resource) {
        currierRepository.delete(converter.toEntity(resource));
    }

    public List<?> findByFilter(CurrierFilter currierFilter) {
        return Collections.singletonList(currierRepository.findAll(getSpecification(currierFilter)));
    }

    private Specification<CurrierEntity> getSpecification(CurrierFilter filter){
        if(filter != null){
            Specification<CurrierEntity> specification = Specification.where((filter.getId() == null) ? null : CurrierSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(CurrierSpecification.equalId(filter.getId()));
            specification = (filter.getName() == null) ? specification : specification.and(CurrierSpecification.likeCurrier(filter.getName()));
            specification = (filter.getCreateUser() == null) ? specification : specification.and(CurrierSpecification.likeCreateUser(filter.getCreateUser()));
            specification = (filter.getUpdateUser() == null) ? specification : specification.and(CurrierSpecification.likeUpdateUser(filter.getUpdateUser()));

            if(filter.getCreateDateI() != null && filter.getCreateDateF() != null){
                specification = specification.and(CurrierSpecification.betweenCreateDate(filter.getCreateDateI(), filter.getCreateDateF()));
            }else{
                specification = (filter.getCreateDate() == null) ? specification : specification.and(CurrierSpecification.equalCreateDateLess(filter.getCreateDate()));
                specification = (filter.getCreateDate() == null) ? specification : specification.and(CurrierSpecification.equalCreateDateGreater(filter.getCreateDate()));
            }

            if(filter.getUpdateDateI() != null && filter.getUpdateDateF() != null){
                specification = specification.and(CurrierSpecification.betweenUpdateDate(filter.getUpdateDateI(), filter.getUpdateDateF()));
            }else{
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(CurrierSpecification.equalUpdateDateLess(filter.getUpdateDate()));
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(CurrierSpecification.equalUpdateDateGreater(filter.getUpdateDate()));
            }
            return specification;
        }else{
            return null;
        }
    }


}
