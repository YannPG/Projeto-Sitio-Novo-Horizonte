package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.embedable.EnderecoSitioEmbedable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoSitioEmbedableDTO {

    private String enderecoSitio;

    public EnderecoSitioEmbedableDTO(EnderecoSitioEmbedable produtorEmbedable) {
        this.enderecoSitio = produtorEmbedable.getEnderecoSitio();
    }

    public static List<EnderecoSitioEmbedableDTO> converter(List<EnderecoSitioEmbedable> listaEnderecoSitioEmbedable) {
        return listaEnderecoSitioEmbedable
                .stream()
                .map(EnderecoSitioEmbedableDTO::new)
                .collect(Collectors.toList());
    }
}
