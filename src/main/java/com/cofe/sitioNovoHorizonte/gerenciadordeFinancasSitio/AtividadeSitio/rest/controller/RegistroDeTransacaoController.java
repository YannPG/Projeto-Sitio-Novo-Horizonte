package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.RegistroDeTransacaoDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.RegistroDeTransacaoForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.RegistroDeTransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/registroDeTransacao")
public class RegistroDeTransacaoController {

    private final RegistroDeTransacaoService registroDeTransacaoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarTodoRegistroDeTransacao")
    public List<RegistroDeTransacaoDTO> listaRegistroDeTransacao() {
        return this.registroDeTransacaoService.buscarTodoRegistroDeTransacao();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/criarRegistroDeTransacao")
    public void criarRegistroDeTransacao(@RequestBody @Valid RegistroDeTransacaoForm registroDeTransacaoForm) {
        this.registroDeTransacaoService.criarRegistroDeTransacao(registroDeTransacaoForm);
    }

    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarRegistroDeTransacao/{id}")
    public void atualizarRegistroDeTransacao(@RequestBody RegistroDeTransacaoForm registroDeTransacaoForm,
                                             @PathVariable Long id){
        this.registroDeTransacaoService.atualizarRegistroDeTransacao(registroDeTransacaoForm, id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarRegistroDeTransacao/{id}")
    public void deletarRegistroDeTransacao(@PathVariable Long id) {
        this.registroDeTransacaoService.deletarRegistroDeTransacao(id);
    }


    //findById
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path ="/econtrarPeloId/{id}")
    public void encontrarPeloId(@PathVariable Long id) {
        this.registroDeTransacaoService.encontrarPeloId(id);
    }
}
