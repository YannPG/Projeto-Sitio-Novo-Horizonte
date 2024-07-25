package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.PessoaForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    //FindByOrderAsc9
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/encontrarPessoaPorOrdemAlfabtica")
    public List<PessoaDTO> encontrarPessoaPorOrdemAlfabetica(){
        return this.pessoaService.encontrarPessoaPorOrdemAlfabetica();
    }
    //FindByOrderDec6
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/encontrarPessoaPorOrdemDecrescente")
    public List<PessoaDTO> encontrarPessoaPorOrdemDecrescente(){
        return this.pessoaService.encontrarPessoaPorOrdemDecrescente();
    }

    //FindByCpf1
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/encontrarPessoaPorCpf/{cpf}")
    public List<PessoaDTO> encontrarPessoaPorCpf(@PathVariable Long cpf){
        return this.pessoaService.econtrarPessoaPorCpf(cpf);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/encontrarPessoaPorDataNascimento")
    public List<PessoaDTO> encontrarPessoaPorDataNascimento(@RequestParam List<LocalDate> dataNascimento){
        return this.pessoaService.encontrarPessoaPorDataDeNascimento(dataNascimento);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/encontrarPessoaEntreDatas")
    public List<PessoaDTO> encontrarPessoaEntreDatas(@RequestParam LocalDate dataInicial,
                                                     @RequestParam LocalDate dataFinal){
       return this.pessoaService.encontrarPessoaEntreDatas(dataInicial, dataFinal);
    }

}
