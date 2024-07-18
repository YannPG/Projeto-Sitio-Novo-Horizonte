package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums;


import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.DesserializadorEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ValorEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(using = DesserializadorEnum.class)
public enum TipoTransacaoCafeEnum implements ValorEnum<String> {

    COMPRA("C", "Compra"),
    VENDA("V", "Venda"),;

    private String valor;
    private String descricao;
}
