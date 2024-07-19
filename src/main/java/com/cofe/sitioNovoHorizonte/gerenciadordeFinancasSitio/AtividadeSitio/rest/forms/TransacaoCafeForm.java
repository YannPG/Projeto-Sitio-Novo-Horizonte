package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoTransacaoCafeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransacaoCafeForm {

    @NotNull(message = "Não pode ser nulo")
    private Long quantidadeTransitadaCafe;

    private TipoTransacaoCafeEnum tipoTransacaCafe;

    private BigDecimal valorDaTransacaoCafe;

    @NotNull(message = "O ID do café não pode ser nulo")
    private Long idCafe;
}
