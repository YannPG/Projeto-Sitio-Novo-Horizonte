package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO.CafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.CafeForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cafe")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping(path ="/buscarCafe")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CafeDTO> buscarTodoCafe(){
        return this.cafeService.buscarTodoCafe();
    }

    @PostMapping(path = "/criarCafe")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarcafe(@RequestBody CafeForm cafeForm){
        this.cafeService.criarCafe(cafeForm);
    }

    @PutMapping(path = "/atualizarCafe/{id}")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public void atualizarCafe(@RequestBody CafeForm cafeForm,
                              @PathVariable Long id){
        this.cafeService.atualizarCafe(cafeForm, id);
    }


}
