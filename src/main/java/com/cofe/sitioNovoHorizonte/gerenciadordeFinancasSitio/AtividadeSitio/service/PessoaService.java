package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.CafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.PessoaForm;

import java.util.List;

public interface PessoaService {

    List<PessoaDTO> buscarTodaPessoa();

    void criarPessoa(PessoaForm pessoaForm);

    void atualizarPessoa(PessoaForm pessoaForm, Long id);

    void deletarPessoa(Long id);

}
