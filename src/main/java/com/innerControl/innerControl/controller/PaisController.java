package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.PaisDTO;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping
    public Page<PaisDTO> listarTodos(@PageableDefault(sort = "nome", size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        return paisService.listarTodos(paginacao)
                .map(PaisDTO::toDTO);
    }

    @GetMapping("/nopaginated")
    public List<PaisDTO> listarTodos() {
        return paisService.listarTodos()
                .stream().map(PaisDTO::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PaisDTO detalhes(@PathVariable Long id) {
        return PaisDTO.toDTO(paisService.buscarPorId(id));
    }

}
