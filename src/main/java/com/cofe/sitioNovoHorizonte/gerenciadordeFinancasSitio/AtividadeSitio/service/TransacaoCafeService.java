package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.TransacaoCafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.TransacaoCafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.TransacaoCafeForm;

import java.util.List;

public interface TransacaoCafeService {
    List<TransacaoCafeDTO> buscarTodaTransacaoCafe();

    void criarTransacaoCafe(TransacaoCafeForm transacaoCafeForm);

    void atualizarTransicaoCafe(TransacaoCafeForm transacaoCafeForm, Long id);

    void deletarTransacaoCafe(Long id);
}
