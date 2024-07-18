package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoTransacaoCafeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tansacao_Cafe")
public class TransacaoCafeEntity {

    @ManyToOne
    @JoinColumn(name = "id_Cafe", nullable = false, updatable = false)
    private CafeEntity cafeEntity;

    @Id
    @Column(name = "id_Transacao_Cafe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacaoCafe;

    @Column(name = "quantidade_Transitada")
    private Long quantidadeTransitadaCafe;

    @Column(name = "tipo_Transacao")
    private TipoTransacaoCafeEnum tipoTransacaCafe;

    @Column(name = "valor_Da_Transacao")
    private BigDecimal valorDaTransacaoCafe;

}
