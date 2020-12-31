package com.example.dota.service;

import com.example.dota.converter.ItemConverter;
import com.example.dota.entity.ItemEntity;
import com.example.dota.filter.ItemFilter;
import com.example.dota.repository.ItemRepository;
import com.example.dota.resource.ItemResource;
import com.example.dota.specification.ItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private ItemConverter converter = new ItemConverter();;

    public List<?> findAll(){
        return converter.listToDto(itemRepository.findAll());
    }

    public Object post(ItemResource resource) {

        return converter.toDto(itemRepository.save(converter.toEntity(resource)));

    }

    public Object update(Long id, ItemResource resource) {

        itemRepository.findById(id);

        resource.setId(id);

        return  converter.toDto(itemRepository.save(converter.toEntity(resource)));

    }


    public Object findById(Long id) {

        Object object = converter.toOptionalDto(itemRepository.findById(id));

        if(object == null || object == Optional.empty()){
            return null;
        }else{
            return object;
        }

    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public void deleteByObject(ItemResource resource) {
        itemRepository.delete(converter.toEntity(resource));
    }

    public List<Object> findByFilter(ItemFilter filter) {
        return Collections.singletonList(itemRepository.findAll(getSpecification(filter)));
    }

    private Specification<ItemEntity> getSpecification(ItemFilter filter){
        if(filter != null){
            Specification<ItemEntity> specification = Specification.where((filter.getId() == null) ? null : ItemSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(ItemSpecification.equalId(filter.getId()));
            specification = (filter.getNameItem() == null) ? specification : specification.and(ItemSpecification.likeNameItem(filter.getNameItem()));

            specification = (filter.getCreateUser() == null) ? specification : specification.and(ItemSpecification.likeCreateUser(filter.getCreateUser()));
            specification = (filter.getUpdateUser() == null) ? specification : specification.and(ItemSpecification.likeUpdateUser(filter.getUpdateUser()));

            if(filter.getCreateDateI() != null && filter.getCreateDateF() != null){
                specification = specification.and(ItemSpecification.betweenCreateDate(filter.getCreateDateI(), filter.getCreateDateF()));
            }else{
                specification = (filter.getCreateDate() == null) ? specification : specification.and(ItemSpecification.equalCreateDateLess(filter.getCreateDate()));
                specification = (filter.getCreateDate() == null) ? specification : specification.and(ItemSpecification.equalCreateDateGreater(filter.getCreateDate()));
            }

            if(filter.getUpdateDateI() != null && filter.getUpdateDateF() != null){
                specification = specification.and(ItemSpecification.betweenUpdateDate(filter.getUpdateDateI(), filter.getUpdateDateF()));
            }else{
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(ItemSpecification.equalUpdateDateLess(filter.getUpdateDate()));
                specification = (filter.getUpdateDate() == null) ? specification : specification.and(ItemSpecification.equalUpdateDateGreater(filter.getUpdateDate()));
            }

            return specification;
        }else{
            return null;
        }
    }

}
