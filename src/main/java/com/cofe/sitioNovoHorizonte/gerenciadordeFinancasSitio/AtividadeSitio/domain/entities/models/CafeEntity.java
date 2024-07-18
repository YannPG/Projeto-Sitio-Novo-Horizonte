package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoCafeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cafe", schema = "public")
public class CafeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCafe;

    private Long quantidade;

    @Column(name = "Tipo_De_Cafe")
    private TipoCafeEnum tipoCafeEnum;

    @ManyToOne
    @JoinColumn(name = "id_Sitio", nullable = false, updatable = false)
    private SitioEntity sitio;
}