package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.EstadoDTO;
import com.innerControl.innerControl.service.EstadoService;
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
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public Page<EstadoDTO> listarTodos(@PageableDefault(sort = "nome", size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        return estadoService.listarTodos(paginacao)
                .map(EstadoDTO::toDTO);
    }

    @GetMapping("/{id}")
    public EstadoDTO detalhes(@PathVariable Long id) {
        return EstadoDTO.toDTO(estadoService.buscarPorId(id));
    }

    @GetMapping("/from/{paisId}")
    public Page<EstadoDTO> estadosDoPais(@PathVariable Long paisId, @PageableDefault(sort = "nome", size = 10, direction = Sort.Direction.ASC) Pageable paginacao) {
        return estadoService.listarTodosPorPais(paisId, paginacao)
                .map(EstadoDTO::toDTO);
    }

    @GetMapping("/from/{paisId}/nopaginated")
    public List<EstadoDTO> estadosDoPais(@PathVariable Long paisId) {
        return estadoService.listarTodosPorPais(paisId)
                .stream().map(EstadoDTO::toDTO).collect(Collectors.toList());
    }
}
