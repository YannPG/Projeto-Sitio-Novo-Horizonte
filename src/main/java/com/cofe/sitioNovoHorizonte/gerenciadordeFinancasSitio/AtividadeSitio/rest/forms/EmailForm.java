package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class EmailForm {

    @NotNull(message = "Este campo não pode ser nulo")
    private String email;

}
