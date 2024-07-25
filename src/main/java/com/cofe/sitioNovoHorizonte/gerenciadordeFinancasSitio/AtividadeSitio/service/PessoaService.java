package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.PessoaForm;

import java.time.LocalDate;
import java.util.List;

public interface PessoaService {

    List<PessoaDTO> buscarTodaPessoa();

    void criarPessoa(PessoaForm pessoaForm);

    void atualizarPessoa(PessoaForm pessoaForm, Long id);

    void deletarPessoa(Long id);

    List<PessoaDTO> encontrarPessoaPorOrdemAlfabetica();

    List<PessoaDTO> encontrarPessoaPorOrdemDecrescente();

    List<PessoaDTO> econtrarPessoaPorCpf(Long cpf);

    List<PessoaDTO> encontrarPessoaPorDataDeNascimento(List<LocalDate> dataNascimento);

    List<PessoaDTO> encontrarPessoaEntreDatas(LocalDate dataInicial, LocalDate dataFinal);

}