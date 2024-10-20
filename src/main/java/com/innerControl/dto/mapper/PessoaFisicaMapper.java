package com.innerControl.dto.mapper;

import com.innerControl.dto.pessoaFisica.PessoaFisicaDto;
import com.innerControl.models.PessoaFisica;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaFisicaMapper extends BaseMapper<PessoaFisica, PessoaFisicaDto> {
}
