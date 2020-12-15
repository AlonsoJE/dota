package com.example.dota.service;

import com.example.dota.entity.HeroEntity;
import com.example.dota.entity.ItemEntity;
import com.example.dota.exceptions.NotFoundException;
import com.example.dota.filter.ItemFilter;
import com.example.dota.repository.ItemRepository;
import com.example.dota.specification.HeroSpecification;
import com.example.dota.specification.ItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.event.ObjectChangeListener;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemEntity> findAll(){
        return itemRepository.findAll();
    }

    public Object post(ItemEntity itemEntity) {

        return itemRepository.save(itemEntity);

    }

    public Object update(Long id, ItemEntity itemEntity) {

        itemRepository.findById(id);

        itemEntity.setId(id);

        return  itemRepository.save(itemEntity);

    }


    public Object findById(Long id) {

        Object object = itemRepository.findById(id);

        if(object != Optional.empty()){
            return object;
        }else{
            throw  new NotFoundException("Registro não encontrado");
        }

    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public void deleteByObject(ItemEntity itemEntity) {
        itemRepository.delete(itemEntity);
    }

    public List<Object> findByFilter(ItemFilter filter) {
        return Collections.singletonList(itemRepository.findAll(getSpecification(filter)));
    }

    private Specification<ItemEntity> getSpecification(ItemFilter filter){
        if(filter != null){
            Specification<ItemEntity> specification = Specification.where((filter.getId() == null) ? null : ItemSpecification.isNotNullId());

            specification = (filter.getId() == null) ? specification : specification.and(ItemSpecification.equalId(filter.getId()));
            specification = (filter.getNameItem() == null) ? specification : specification.and(ItemSpecification.likeNameItem(filter.getNameItem()));


            return specification;
        }else{
            return null;
        }
    }

}
