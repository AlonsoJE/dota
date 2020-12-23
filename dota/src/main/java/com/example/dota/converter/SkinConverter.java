package com.example.dota.converter;

import com.example.dota.entity.SkinEntity;
import com.example.dota.resource.SkinResource;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class SkinConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public SkinResource toDto(SkinEntity entity){
        SkinResource resource = new SkinResource();
        modelMapper.map(entity, resource);

        if(entity != null){
            return resource;
        }else{
            return null;
        }
    }

    public SkinEntity toEntity(SkinResource resource){
        SkinEntity entity = new SkinEntity();
        modelMapper.map(resource, entity);

        if(resource != null){
            return entity;
        }else{
            return null;
        }
    }

    public List<?> listToDto(final List<SkinEntity> listParam){
        List<SkinResource> list = new ArrayList<>();

        listParam.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

}
