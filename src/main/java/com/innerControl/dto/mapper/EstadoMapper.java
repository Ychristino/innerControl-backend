package com.innerControl.dto.mapper;

import com.innerControl.dto.estado.EstadoDto;
import com.innerControl.models.Estado;
import org.mapstruct.Mapper;

@Mapper
public interface EstadoMapper extends BaseMapper<Estado, EstadoDto> {
}
