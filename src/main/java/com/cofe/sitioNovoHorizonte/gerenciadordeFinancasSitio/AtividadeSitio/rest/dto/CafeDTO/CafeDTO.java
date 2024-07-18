package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums.TipoCafeEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.CafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.SitioDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CafeDTO {

    public Long idCafe;

    public Long quantidade;

    public TipoCafeEnum tipoCafeEnum;

    private SitioCafeDTO sitioDTO;

    public CafeDTO(CafeEntity cafeEntity){
        this.idCafe = cafeEntity.getIdCafe();
        this.quantidade = cafeEntity.getQuantidade();
        this.tipoCafeEnum = cafeEntity.getTipoCafeEnum();
        this.sitioDTO = new SitioCafeDTO(cafeEntity.getSitio());
    }

    public static List<CafeDTO> converter (List<CafeEntity> cafeEntities){
        return cafeEntities
                .stream()
                .map(CafeDTO::new)
                .collect(Collectors.toList());
    }
}
