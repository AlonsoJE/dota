package com.example.dota.converter;

import com.example.dota.entity.ItemEntity;
import com.example.dota.resource.ItemResource;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public ItemResource toDto(ItemEntity entity){
        ItemResource resource = new ItemResource();
        modelMapper.map(entity, resource);

        if(entity != null){
            return resource;
        }else{
            return null;
        }
    }

    public ItemEntity toEntity(ItemResource resource){
        ItemEntity entity = new ItemEntity();
        modelMapper.map(resource, entity);

        if(resource != null){
            return entity;
        }else{
            return null;
        }
    }

    public List<?> listToDto(final List<ItemEntity> listParam){
        List<ItemResource> list = new ArrayList<>();

        listParam.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

    public Object toDto(final Optional<ItemEntity> optional){
        return optional.isPresent() ? toDto(optional.get()) : null;
    }

    public Optional<?> toOptionalDto(final Optional<ItemEntity> optional){
        return Optional.ofNullable(toDto(optional));
    }

}
