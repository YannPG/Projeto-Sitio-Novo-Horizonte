package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoTransacaoCafeEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.TransacaoCafeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TransacaoCafeDTO {

    private Long idTransacaoCafe;

    private Long quantidadeTransitadaCafe;

    private Long idCafe;

    private TipoTransacaoCafeEnum tipoTransacaCafe;

    private BigDecimal valorDaTransacaoCafe;

    public TransacaoCafeDTO(TransacaoCafeEntity transacaoCafeEntity){
        this.idTransacaoCafe = transacaoCafeEntity.getIdTransacaoCafe();
        this.quantidadeTransitadaCafe = transacaoCafeEntity.getQuantidadeTransitadaCafe();
        this.idCafe = transacaoCafeEntity.getCafeEntity().getIdCafe();
        this.tipoTransacaCafe = transacaoCafeEntity.getTipoTransacaCafe();
        this.valorDaTransacaoCafe = transacaoCafeEntity.getValorDaTransacaoCafe();
    }

    public static List<TransacaoCafeDTO> converter (List<TransacaoCafeEntity> transacaoCafeEntityLista){
        return transacaoCafeEntityLista
                .stream()
                .map(TransacaoCafeDTO::new)
                .collect(Collectors.toList());
    }
}
