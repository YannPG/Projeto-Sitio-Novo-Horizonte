package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<CafeEntity, Long> {
}
