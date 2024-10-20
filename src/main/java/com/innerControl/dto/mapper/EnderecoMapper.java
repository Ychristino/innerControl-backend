package com.innerControl.dto.mapper;

import com.innerControl.dto.endereco.EnderecoDto;
import com.innerControl.models.Endereco;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDto> {
}
