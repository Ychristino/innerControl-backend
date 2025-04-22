package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.CidadeDTO;
import com.innerControl.innerControl.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public Page<CidadeDTO> listarTodos(@PageableDefault(sort = "nome", size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        return cidadeService.listarTodos(paginacao)
                .map(CidadeDTO::toDTO);
    }

    @GetMapping("/{id}")
    public CidadeDTO detalhes(@PathVariable Long id) {
        return CidadeDTO.toDTO(cidadeService.buscarPorId(id));
    }
}
