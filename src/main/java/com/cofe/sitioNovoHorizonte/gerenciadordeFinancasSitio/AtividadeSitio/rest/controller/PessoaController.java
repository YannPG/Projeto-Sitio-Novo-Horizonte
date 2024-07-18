package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.PessoaForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/buscarPessoa")
    public List<PessoaDTO> buscarTodaPessoa(){
        return this.pessoaService.buscarTodaPessoa();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/criarPessoa")
    public void criarPessoa (@RequestBody @Valid PessoaForm pessoaForm){
        this.pessoaService.criarPessoa(pessoaForm);
    }

    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarPessoa/{id}")
    public void atualizarPessoa(@RequestBody PessoaForm pessoaForm,
                                @PathVariable Long id){
        this.pessoaService.atualizarPessoa(pessoaForm, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarPessoa/{id}")
    public void deletarPessoa(@PathVariable Long id){
        this.pessoaService.deletarPessoa(id);
    }
}
