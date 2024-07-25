package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RegistroDeTransacaoForm {

    @NotNull(message = "A data não pode estar vazia.")
    private LocalDateTime dataTransacao;

    @NotNull(message = "O id da transacao de cafe não pode ser nulo")
    private Long idTransacaoCafe;

}