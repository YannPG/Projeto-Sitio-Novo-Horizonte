package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.RegistroDeTransacaoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RegistroDeTransacaoDTO {

    private LocalDateTime dataTransacao;

    private String descricao;

    private Long idTransacaoCafe;

    private Long idRegistroDeTransacao;

    public RegistroDeTransacaoDTO(RegistroDeTransacaoEntity registroDeTransacaoEntity){
        this.dataTransacao = registroDeTransacaoEntity.getDataTransacao();
        this.descricao = registroDeTransacaoEntity.getDescricao();
        this.idTransacaoCafe = registroDeTransacaoEntity.getTransacaoCafe().getIdTransacaoCafe();
        this.idRegistroDeTransacao = registroDeTransacaoEntity.getIdRegistroDeTransacao();
    }

    public static List<RegistroDeTransacaoDTO> converter(List<RegistroDeTransacaoEntity> listDeRegistroDeTransacao){
        return listDeRegistroDeTransacao
                .stream()
                .map(RegistroDeTransacaoDTO::new)
                .collect(Collectors.toList());
    }

}
