package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.embedable.EnderecoSitioEmbedable;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoProdutorEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Sitio", schema = "public")
public class SitioEntity {

    @Id
    @Column(name = "idSitio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSitio;

    @Embedded
    @Column(name = "Endereco_Sitio")
    private EnderecoSitioEmbedable enderecoSitioEmbedable;

    @Column(name = "Nome_Do_Sitio")
    private String nomeSitio;

    @Column(name = "Tamanho_Do_Produtor")
    private TipoProdutorEnum tipoProdutorEnum;

    @ManyToOne
    @JoinColumn(name = "id_Pessoa")
    private PessoaEntity idPessoa;
}
