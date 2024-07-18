package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PessoaForm {

    @NotNull(message = "Este campo não pode ser nulo")
    private Long cpf;

    private String nome;

    private String email;

}
