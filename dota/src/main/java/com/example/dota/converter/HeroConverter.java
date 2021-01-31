package com.example.dota.converter;

import com.example.dota.entity.HeroEntity;
import com.example.dota.resource.HeroResource;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe conversora entre HeroEntity e HeroResource.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

public class HeroConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public HeroResource toDto(HeroEntity entity){
        HeroResource resource = new HeroResource();
        modelMapper.map(entity, resource);

        if(entity != null){
            return resource;
        }else{
            return null;
        }
    }

    public HeroEntity toEntity(HeroResource resource){
        HeroEntity entity = new HeroEntity();
        modelMapper.map(resource, entity);

        if(resource != null){
            return entity;
        }else{
            return null;
        }
    }

    public List<HeroResource> listToDto(final List<HeroEntity> listParam){
        List<HeroResource> list = new ArrayList<>();

        listParam.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

    public HeroResource toDto(final Optional<HeroEntity> optional){
        return optional.isPresent() ? toDto(optional.get()) : null;
    }

    public Optional<?> toOptionalDto(final Optional<HeroEntity> optional){
        return Optional.ofNullable(toDto(optional));
    }
}
