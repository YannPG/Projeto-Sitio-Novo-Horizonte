package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.embedable.EnderecoSitioEmbedable;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoProdutorEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SitioForm {

    @NotNull(message = "Campo não pode ser nulo")
    private Long idPessoa;

    private String nomeSitio;

    private EnderecoSitioEmbedable enderecoProdutorEmbedable;

    private TipoProdutorEnum tipoProdutorEnum;
}
