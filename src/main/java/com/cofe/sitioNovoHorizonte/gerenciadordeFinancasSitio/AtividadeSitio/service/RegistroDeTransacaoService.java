package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.RegistroDeTransacaoEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.RegistroDeTransacaoDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.RegistroDeTransacaoForm;

import java.util.List;
import java.util.Optional;

public interface RegistroDeTransacaoService {

    List<RegistroDeTransacaoDTO> buscarTodoRegistroDeTransacao();

    void criarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm);

    void deletarRegistroDeTransacao(Long id);

    void atualizarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm, Long id);

    RegistroDeTransacaoDTO buscarTodoRegistroDeTransacao(Long id);

    void deletarRegistroDeTransacaoPeloId(Long idRegistroDeTransacao);

    List<RegistroDeTransacaoDTO> encontrarPrimeiroRegistroDeTransacaoDoMes(String mesSelecionado);
}
