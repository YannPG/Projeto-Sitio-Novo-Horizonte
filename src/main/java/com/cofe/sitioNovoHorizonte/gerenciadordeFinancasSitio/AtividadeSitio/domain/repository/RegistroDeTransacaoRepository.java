package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.RegistroDeTransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroDeTransacaoRepository extends JpaRepository<RegistroDeTransacaoEntity, Long> {
    void deleteByIdRegistroDeTransacao(Long idRegistroDeTransacao);

    List<RegistroDeTransacaoEntity> findFirstByDataTransacaoBetweenOrderByDataTransacaoAsc(LocalDateTime start, LocalDateTime end);

}
