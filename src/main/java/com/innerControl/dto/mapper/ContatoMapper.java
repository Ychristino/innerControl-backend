package com.innerControl.dto.mapper;

import com.innerControl.dto.contato.ContatoDto;
import com.innerControl.models.Contato;
import org.mapstruct.Mapper;

@Mapper
public interface ContatoMapper extends BaseMapper<Contato, ContatoDto> {
}
