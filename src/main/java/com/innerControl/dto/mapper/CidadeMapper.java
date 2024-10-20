package com.innerControl.dto.mapper;

import com.innerControl.dto.cidade.CidadeDto;
import com.innerControl.models.Cidade;
import org.mapstruct.Mapper;

@Mapper
public interface CidadeMapper extends BaseMapper<Cidade, CidadeDto> {
}
