package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.EmailPessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.EmailForm;

import java.util.List;

public interface EmailService {
    List<EmailPessoaDTO> buscarTodoEmail();

    void criarUmEmailPessoa(EmailForm emailForm);

    void atualizarEmailPessoa(EmailForm emailForm, Long id);

    void deletarEmailPorId(Long id);

    List<EmailPessoaDTO> buscarEmailVerificado();
}
