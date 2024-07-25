package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.SitioDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.SitioForm;

import java.util.List;

public interface SitioService {

    List<SitioDTO> buscarTodoSitio();

    void criarSitio(SitioForm sitioForm);

    void atualizarSitio(SitioForm sitioForm, Long idSitio);

    void deletarSitioPeloId(Long idSitio);

    List<SitioDTO> encontrarPorNomeSitioOuIdSitio(String nomeSitio, Long idSitio);
}
