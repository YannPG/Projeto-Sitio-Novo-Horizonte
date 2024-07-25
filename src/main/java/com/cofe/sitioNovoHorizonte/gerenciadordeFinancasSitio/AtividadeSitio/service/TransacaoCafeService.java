package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.TransacaoCafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.TransacaoCafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.TransacaoCafeForm;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransacaoCafeService {
    List<TransacaoCafeDTO> buscarTodaTransacaoCafe();

    void criarTransacaoCafe(TransacaoCafeForm transacaoCafeForm);

    void atualizarTransicaoCafe(TransacaoCafeForm transacaoCafeForm, Long id);

    void deletarTransacaoCafe(Long id);

    List<TransacaoCafeDTO> encontrarTransacaoComValorMenor(BigDecimal valor);

    List<TransacaoCafeDTO> encontrarTransacaoComValorMenorIgual(BigDecimal valor);

    List<TransacaoCafeDTO> encontrarTransacaoComValorMaior(BigDecimal valor);

    List<TransacaoCafeDTO> encontrarTransacaoComValorMaiorIgual(BigDecimal valor);
}
