package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoCafeEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO.CafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.CafeForm;

import java.util.List;

public interface CafeService {
    List<CafeDTO> buscarTodoCafe();

    void criarCafe(CafeForm cafeForm);

    void atualizarCafe(CafeForm cafeForm, Long id);

    void deletarCafe(Long id);

    List<CafeDTO> encontrarPorIdSitioEtipoCafe(Long idSitio, TipoCafeEnum idTipoCafe);
}
