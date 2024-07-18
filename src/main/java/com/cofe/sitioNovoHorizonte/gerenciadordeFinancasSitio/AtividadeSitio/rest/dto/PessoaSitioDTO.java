package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.PessoaEntity;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PessoaSitioDTO {

    private Long idPessoa;

    public PessoaSitioDTO(PessoaEntity pessoaEntity) {
        this.idPessoa = pessoaEntity.getId();
    }

    public static List<PessoaSitioDTO> converter (List<PessoaEntity> listaDeSitios){
        return listaDeSitios
                .stream()
                .map(PessoaSitioDTO::new)
                .collect(Collectors.toList());
    }
}
