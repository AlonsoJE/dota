package com.example.dota.service;

import com.example.dota.converter.ItemHeroConverter;
import com.example.dota.entity.ItemHero;
import com.example.dota.filter.ItemHeroFilter;
import com.example.dota.repository.ItemHeroRepository;
import com.example.dota.resource.ItemHeroResource;
import com.example.dota.specification.ItemHeroSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemHeroService {

    @Autowired
    private ItemHeroRepository repository;

    ItemHeroConverter converter = new ItemHeroConverter();

    public List<?> findAll(){
        return converter.listToDto(repository.findAll());
    }

    public Object post(ItemHeroResource resource) {

        return converter.toDto(repository.save(converter.toEntity(resource)));

    }

    public Object update(Long id, ItemHeroResource entity) {

        repository.findById(id);

        entity.setId(id);

        return  converter.toDto(repository.save(converter.toEntity(entity)));

    }


    public Object findById(Long id) {

        return converter.toOptionalDto(repository.findById(id));

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void deleteByObject(ItemHeroResource resource) {
        repository.delete(converter.toEntity(resource));
    }


    public List<?> findByFilter(ItemHeroFilter filter) {
//        return Collections.singletonList(repository.findAll(getSpecification(filter)));
        return converter.listToDto(repository.findAll(getSpecification(filter)));
    }

    private Specification<ItemHero> getSpecification(ItemHeroFilter filter){
        if(filter != null){
            Specification<ItemHero> specification = Specification.where((filter.getId() == null) ? null : ItemHeroSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(ItemHeroSpecification.equalId(filter.getId()));
            specification = (filter.getCreateUser() == null) ? specification : specification.and(ItemHeroSpecification.likeCreateUser(filter.getCreateUser()));
            specification = (filter.getUpdateUser() == null) ? specification : specification.and(ItemHeroSpecification.likeUpdateUser(filter.getUpdateUser()));
            specification = (filter.getHero() == null) ? specification : specification.and(ItemHeroSpecification.likeHero(filter.getHero()));


            if(filter.getCreateDateI() != null && filter.getCreateDateF() != null){
                specification = specification.and(ItemHeroSpecification.betweenCreateDate(filter.getCreateDateI(), filter.getCreateDateF()));
            }else{
                specification = (filter.getCreateDate() == null) ? specification : specification.and(ItemHeroSpecification.equalCreateDateLess(filter.getCreateDate()));
                specification = (filter.getCreateDate() == null) ? specification : specification.and(ItemHeroSpecification.equalCreateDateGreater(filter.getCreateDate()));
            }

            if(filter.getUpdateDateI() != null && filter.getUpdateDateF() != null){
                specification = specification.and(ItemHeroSpecification.betweenUpdateDate(filter.getUpdateDateI(), filter.getUpdateDateF()));
            }else{
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(ItemHeroSpecification.equalUpdateDateLess(filter.getUpdateDate()));
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(ItemHeroSpecification.equalUpdateDateGreater(filter.getUpdateDate()));
            }
            return specification;
        }else{
            return null;
        }
    }

}
