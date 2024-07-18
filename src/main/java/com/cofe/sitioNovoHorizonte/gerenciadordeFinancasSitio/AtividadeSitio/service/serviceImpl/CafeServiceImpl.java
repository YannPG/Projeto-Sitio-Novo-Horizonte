package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.CafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.SitioEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.CafeRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.SitioRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.CafeDTO.CafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.CafeForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.CafeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CafeServiceImpl implements CafeService {

    public final CafeRepository cafeRepository;
    private final SitioRepository sitioRepository;

    @Override
    public List<CafeDTO> buscarTodoCafe() {
        List<CafeEntity> listaDeCafe = this.cafeRepository.findAll();
        if(listaDeCafe.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não foi econtrado nenhum café");
        return CafeDTO.converter(listaDeCafe);
    }

    @Override
    public void criarCafe(CafeForm cafeForm) {
        CafeEntity cafeCriado = new CafeEntity();

        cafeCriado.setTipoCafeEnum(cafeForm.getTipoCafeEnum());
        cafeCriado.setQuantidade(cafeForm.getQuantidade());
        cafeCriado.setSitio(this.sitioRepository
                .findById(cafeForm.getIdSitioCafe())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Sitio não encontrado")));
        this.cafeRepository.save(cafeCriado);
    }

    @Override
    public void atualizarCafe(CafeForm cafeForm, Long id) {
        Optional<CafeEntity> cafeEncontrado = this.cafeRepository.findById(id);
        if(cafeEncontrado.isEmpty()) throw new RuntimeException("Esse cafe não existe");
        this.cafeRepository.save(converterForm(cafeForm, id));
    }

    public CafeEntity converterForm(CafeForm cafeForm, Long id) {
        CafeEntity cafeEntity = new CafeEntity();
        cafeEntity.setIdCafe(id);
        cafeEntity.setTipoCafeEnum(cafeForm.getTipoCafeEnum());
        cafeEntity.setQuantidade(cafeForm.getQuantidade());
        cafeEntity.setSitio(this.sitioRepository
                .findById(cafeForm.getIdSitioCafe())
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Sitio não encontrado!")));
        return cafeEntity;
    }
}
