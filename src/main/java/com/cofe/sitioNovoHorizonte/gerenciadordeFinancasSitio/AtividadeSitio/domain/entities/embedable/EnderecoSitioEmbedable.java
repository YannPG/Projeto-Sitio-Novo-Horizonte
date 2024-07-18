package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.embedable;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EnderecoSitioEmbedable {

    @Column(name = "Endereco_Sitio")
    private String enderecoSitio;
}