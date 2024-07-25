package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository <PessoaEntity,Long> {
    List<PessoaEntity> findAllByOrderByNomeAsc();

    List<PessoaEntity> findAllByOrderByNomeDesc();

    List<PessoaEntity> findByCpf(Long cpf);

    List<PessoaEntity> findByDataNascimentoIn(Collection<LocalDate> dataNascimento);

    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
