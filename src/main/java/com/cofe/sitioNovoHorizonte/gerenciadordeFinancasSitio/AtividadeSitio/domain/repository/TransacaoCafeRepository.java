package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.TransacaoCafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransacaoCafeRepository extends JpaRepository<TransacaoCafeEntity, Long> {
    List<TransacaoCafeEntity> findByValorDaTransacaoCafeLessThan(BigDecimal valor);

    List<TransacaoCafeEntity> findByValorDaTransacaoCafeLessThanEqual(BigDecimal valor);

    List<TransacaoCafeEntity> findByValorDaTransacaoCafeGreaterThan(BigDecimal valor);

    List<TransacaoCafeEntity> findByValorDaTransacaoCafeGreaterThanEqual(BigDecimal valor);
}
