package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.SitioDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.SitioForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.SitioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sitio")
public class SitioController {

    private final SitioService sitioService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarSitio")
    public List<SitioDTO> buscarTodoSitio (){
       return this.sitioService.buscarTodoSitio();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/criarSitio")
    public void criarSitio(@RequestBody @Valid SitioForm sitioForm){
        this.sitioService.criarSitio(sitioForm);
    }

    @Transactional
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarSitio/{idSitio}")
    public void atualizarSitio(@RequestBody SitioForm sitioForm,
                               @PathVariable Long idSitio){
        this.sitioService.atualizarSitio(sitioForm, idSitio);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarSitio/{idSitio}")
    public void deletarSitio(@PathVariable Long idSitio){
        this.sitioService.deletarSitioPeloId(idSitio);
    }

    //FindByOr
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/encontrarPorNomeOuId")
    public List<SitioDTO> encontrarPorNomeSitioOuIdSitio(@RequestParam(required = false) String nome,
                                                         @RequestParam(required = false) Long idSitio){
        return this.sitioService.encontrarPorNomeSitioOuIdSitio(nome, idSitio);
    }
}
