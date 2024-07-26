package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.EmailEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.formatacao.FormatarLocalDateTime.formatLocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailPessoaDTO {

    private String email;

    private Long idUsuario;

    private String dataDeCadastro;

    public EmailPessoaDTO(EmailEntity emailEntity){
        this.email = emailEntity.getEmail();
        this.dataDeCadastro = formatLocalDateTime(emailEntity.getDataDeCadastro());
        this.idUsuario = emailEntity.getIdUsuario();
    }

    public EmailPessoaDTO(Long idUsuario, String email) {
        this.email = email;
        this.idUsuario = idUsuario;
        this.dataDeCadastro = "";
    }

    public static List<EmailPessoaDTO> converter (List<EmailEntity> listEmail){
        return listEmail
                .stream()
                .map(EmailPessoaDTO::new)
                .collect(Collectors.toList());
    }
}
