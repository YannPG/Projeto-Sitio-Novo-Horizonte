package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.SitioEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.EnderecoSitioEmbedableDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.SitioDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class SitioCafeDTO {

    private Long idSitio;

    private String nome;

    private PessoaSitioCafeDTO dono;

    private EnderecoSitioEmbedableDTO produtorEndereco;

    public SitioCafeDTO(SitioEntity sitioEntity) {
        this.idSitio = sitioEntity.getIdSitio();
        this.nome = sitioEntity.getNomeSitio();
        this.dono = new PessoaSitioCafeDTO(sitioEntity.getIdPessoa());
        this.produtorEndereco = new EnderecoSitioEmbedableDTO((sitioEntity.getEnderecoSitioEmbedable()));
    }

    public static List<SitioDTO> converter(List<SitioEntity> listSitio) {
        return listSitio
                .stream()
                .map(SitioDTO::new)
                .collect(Collectors.toList());
    }
}
