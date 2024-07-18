package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.PessoaEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PessoaSitioCafeDTO {

    private String nome;

    public PessoaSitioCafeDTO(PessoaEntity pessoaEntity){
        this.nome = pessoaEntity.getNome();
    }

    public static List<PessoaDTO> converter (List<PessoaEntity> listPessoa){
        return listPessoa
                .stream()
                .map(PessoaDTO::new)
                .collect(Collectors.toList());
    }
}
