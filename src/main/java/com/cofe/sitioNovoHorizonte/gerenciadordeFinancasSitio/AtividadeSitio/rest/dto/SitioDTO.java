package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoProdutorEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.SitioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SitioDTO {

    private Long idSitio;

    private String nome;

    private PessoaSitioDTO dono;

    private TipoProdutorEnum tamanhoProdutor;

    private EnderecoSitioEmbedableDTO produtorEndereco;

    public SitioDTO(SitioEntity sitioEntity) {
        this.idSitio = sitioEntity.getIdSitio();
        this.nome = sitioEntity.getNomeSitio();
        this.tamanhoProdutor = sitioEntity.getTipoProdutorEnum();
        this.dono = new PessoaSitioDTO(sitioEntity.getIdPessoa());
        this.produtorEndereco = new EnderecoSitioEmbedableDTO((sitioEntity.getEnderecoSitioEmbedable()));
    }

    public static List<SitioDTO> converter(List<SitioEntity> listSitio) {
        return listSitio
                .stream()
                .map(SitioDTO::new)
                .collect(Collectors.toList());
    }
}
