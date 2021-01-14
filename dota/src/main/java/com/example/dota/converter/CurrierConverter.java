package com.example.dota.converter;

import com.example.dota.entity.CurrierEntity;
import com.example.dota.resource.CurrierResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrierConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public CurrierResource toDto(CurrierEntity entity){
        CurrierResource resource = new CurrierResource();
        modelMapper.map(entity, resource);

        if(entity != null){
            return resource;
        }else{
            return null;
        }
    }

    public CurrierEntity toEntity(CurrierResource resource){
        CurrierEntity entity = new CurrierEntity();
        modelMapper.map(resource, entity);

        if(resource != null){
            return entity;
        }else{
            return null;
        }
    }

    public List<?> listToDto(final List<CurrierEntity> listParam){
        List<CurrierResource> list = new ArrayList<>();

        listParam.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

    public Object toDto(final Optional<CurrierEntity> optional){
        return optional.isPresent() ? toDto(optional.get()) : null;
    }

    public Optional<?> toOptionalDto(final Optional<CurrierEntity> optional){
        return Optional.ofNullable(toDto(optional));
    }

    public Page<?> toPageable(Page<CurrierEntity> list){
        return list.map(CurrierEntity -> toDto(CurrierEntity));
    }
}
