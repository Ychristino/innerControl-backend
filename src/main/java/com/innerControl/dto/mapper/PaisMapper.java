package com.innerControl.dto.mapper;

import com.innerControl.dto.pais.PaisDto;
import com.innerControl.models.Pais;
import org.mapstruct.Mapper;

@Mapper
public interface PaisMapper extends BaseMapper<Pais, PaisDto> {
}
