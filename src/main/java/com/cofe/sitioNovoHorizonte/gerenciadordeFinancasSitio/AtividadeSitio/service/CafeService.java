package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO.CafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.CafeForm;

import java.util.List;

public interface CafeService {
    List<CafeDTO> buscarTodoCafe();

    void criarCafe(CafeForm cafeForm);

    void atualizarCafe(CafeForm cafeForm, Long id);
}
