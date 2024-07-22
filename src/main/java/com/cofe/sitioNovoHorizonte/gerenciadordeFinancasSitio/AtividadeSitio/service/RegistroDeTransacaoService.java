package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.RegistroDeTransacaoDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.RegistroDeTransacaoForm;

import java.util.List;

public interface RegistroDeTransacaoService {

    List<RegistroDeTransacaoDTO> buscarTodoRegistroDeTransacao();

    void criarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm);

    void deletarRegistroDeTransacao(Long id);

    void atualizarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm, Long id);

    void encontrarPeloId(Long id);
}
