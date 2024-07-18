package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Registro_De_Transacao")
public class RegistroDeTransacaoEntity {

    @ManyToMany
    @JoinTable( name = "transacao_pessoa",
            joinColumns = @JoinColumn(name = "id_registro_de_transacao"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Set<PessoaEntity> pessoas;

    @ManyToOne
    @JoinColumn(name = "id_Transacao_Cafe", updatable = false,insertable = false)
    private TransacaoCafeEntity transacaoCafe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro_De_Transacao")
    private Long idTransicao;

    @Column(name = "data_Transacao")
    private LocalDateTime dataTransacao;

    private String descricao;
}
