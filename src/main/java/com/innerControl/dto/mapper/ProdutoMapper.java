package com.innerControl.dto.mapper;

import com.innerControl.dto.produto.ProdutoDto;
import com.innerControl.models.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface ProdutoMapper extends BaseMapper<Produto, ProdutoDto> {
}
