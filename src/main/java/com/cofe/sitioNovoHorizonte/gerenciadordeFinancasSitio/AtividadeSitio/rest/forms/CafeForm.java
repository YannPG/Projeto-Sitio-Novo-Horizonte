package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoCafeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CafeForm {

    @NotNull(message = "Este campo não pode ser Nulo")
    private Long quantidade;

    private TipoCafeEnum tipoCafeEnum;

    private Long idSitioCafe;

}
