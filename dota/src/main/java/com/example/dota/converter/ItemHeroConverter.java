package com.example.dota.converter;

import com.example.dota.entity.ItemHero;
import com.example.dota.resource.ItemHeroResource;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe conversora entre ItemHeroEntity e ItemHeroResource.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

public class ItemHeroConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public ItemHeroResource toDto(ItemHero entity){
        ItemHeroResource resource = new ItemHeroResource();
        modelMapper.map(entity, resource);

        if(entity != null){
            return resource;
        }else{
            return null;
        }
    }

    public ItemHero toEntity(ItemHeroResource resource){
        ItemHero entity = new ItemHero();
        modelMapper.map(resource, entity);

        if(resource != null){
            return entity;
        }else{
            return null;
        }
    }

    public List<?> listToDto(final List<ItemHero> listParam){
        List<ItemHeroResource> list = new ArrayList<>();

        listParam.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

    public Object toDto(final Optional<ItemHero> optional){
        return optional.isPresent() ? toDto(optional.get()) : null;
    }

    public Optional<?> toOptionalDto(final Optional<ItemHero> optional){
        return Optional.ofNullable(toDto(optional));
    }

}
