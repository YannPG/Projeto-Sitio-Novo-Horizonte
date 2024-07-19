package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.TransacaoCafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.TransacaoCafeForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.TransacaoCafeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/transacaoCafe")
public class TransacaoCafeController {

    private final TransacaoCafeService transacaoCafeService;

    @GetMapping(path = "/buscarTodaTransacaoCafe")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TransacaoCafeDTO> buscarTodaTransacaoCafe() {
        return this.transacaoCafeService.buscarTodaTransacaoCafe();
    }

    @PostMapping(path = "/criarTransacaoCafe")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTransacaoCafe(@RequestBody @Valid TransacaoCafeForm transacaoCafeForm){
        this.transacaoCafeService.criarTransacaoCafe(transacaoCafeForm);
    }

    @PutMapping(path = "/atualizarTransacaoCafe/{id}")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public void atualizarTransacaoCafe(@RequestBody @Valid TransacaoCafeForm transacaoCafeForm,
                                       @PathVariable Long id){
        this.transacaoCafeService.atualizarTransicaoCafe(transacaoCafeForm, id);
    }

    @DeleteMapping(path = "/deletarTransacaoCafe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTransacaoCafe(@PathVariable Long id){
        this.transacaoCafeService.deletarTransacaoCafe(id);
    }
}
