package com.innerControl.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface  BaseMapper <E, D>{

    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);

    D toDto(E entity);

    E toEntity(D dto);

    Set<D> toDtoList(Set<E> entity);

    Set<E> toEntityList(Set<D> directory);

    List<E> toPaginatedEntitiesList(List<D> dtos);

    List<D> toPaginatedDtoList(List<E> entities);

}
