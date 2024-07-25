package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.PessoaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    private Long cpf;

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    public PessoaDTO(PessoaEntity pessoaEntity){
        this.id = pessoaEntity.getId();
        this.cpf = pessoaEntity.getCpf();
        this.nome = pessoaEntity.getNome();
        this.email = pessoaEntity.getEmail();
        this.dataNascimento = pessoaEntity.getDataNascimento();
    }

    public static List<PessoaDTO> converter (List<PessoaEntity> listPessoa){
        return listPessoa
                .stream()
                .map(PessoaDTO::new)
                .collect(Collectors.toList());
    }
}
