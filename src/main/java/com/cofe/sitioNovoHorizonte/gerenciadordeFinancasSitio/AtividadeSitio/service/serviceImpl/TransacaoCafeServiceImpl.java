package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.TransacaoCafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.CafeRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.TransacaoCafeRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.TransacaoCafeDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.exception.ResourceNotFoundException;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.TransacaoCafeForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.TransacaoCafeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransacaoCafeServiceImpl implements TransacaoCafeService {

    private final TransacaoCafeRepository transacaoCafeRepository;
    private final CafeRepository cafeRepository;

    @Override
    public List<TransacaoCafeDTO> buscarTodaTransacaoCafe() {
            List<TransacaoCafeEntity> listaTransacaoCafe = this.transacaoCafeRepository.findAll();
            if(listaTransacaoCafe.isEmpty()) throw
                    new ResourceNotFoundException("Não foram encontrados transações");
            return TransacaoCafeDTO.converter(listaTransacaoCafe);
    }

    @Override
    public void criarTransacaoCafe(TransacaoCafeForm transacaoCafeForm) {
        TransacaoCafeEntity transacaoCafeCriado = new TransacaoCafeEntity();
        transacaoCafeCriado.setValorDaTransacaoCafe(transacaoCafeForm.getValorDaTransacaoCafe());
        transacaoCafeCriado.setQuantidadeTransitadaCafe(transacaoCafeForm.getQuantidadeTransitadaCafe());
        transacaoCafeCriado.setTipoTransacaCafe(transacaoCafeForm.getTipoTransacaCafe());
        transacaoCafeCriado.setCafeEntity(this.transacaoCafeRepository
                .findById(transacaoCafeForm.getIdCafe()).get().getCafeEntity());
        this.transacaoCafeRepository.save(transacaoCafeCriado);
    }

    @Override
    public void atualizarTransicaoCafe(TransacaoCafeForm transacaoCafeForm, Long id) {
        Optional<TransacaoCafeEntity> transacaoCafeEncontrado = this.transacaoCafeRepository.findById(id);
        if(transacaoCafeEncontrado.isEmpty()) throw new ResourceNotFoundException("Não foi encontrado nenhuma transacao com este id");
        this.transacaoCafeRepository.save(converterForm(transacaoCafeForm, id));
    }

    @Override
    public void deletarTransacaoCafe(Long id) {
        this.transacaoCafeRepository.deleteById(id);
    }

    public TransacaoCafeEntity converterForm(TransacaoCafeForm transacaoCafeForm, Long id){
        TransacaoCafeEntity transacaoCafeEncontrado = new TransacaoCafeEntity();
        transacaoCafeEncontrado.setIdTransacaoCafe(id);
        transacaoCafeEncontrado.setValorDaTransacaoCafe(transacaoCafeForm.getValorDaTransacaoCafe());
        transacaoCafeEncontrado.setQuantidadeTransitadaCafe(transacaoCafeForm.getQuantidadeTransitadaCafe());
        transacaoCafeEncontrado.setTipoTransacaCafe(transacaoCafeForm.getTipoTransacaCafe());
        transacaoCafeEncontrado.setCafeEntity(this.cafeRepository.findById(transacaoCafeForm.getIdCafe()).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "O ID do café não foi encontrado")));
        return transacaoCafeEncontrado;
    }

    //findByLessthan
    @Override
    public List<TransacaoCafeDTO> encontrarTransacaoComValorMenor(BigDecimal valor) {
        List<TransacaoCafeEntity> transacaoCafeEncontrado = this.transacaoCafeRepository
                .findByValorDaTransacaoCafeLessThan(valor);
        if(transacaoCafeEncontrado.isEmpty()) throw new ResourceNotFoundException("não foi encontrado transacoes com este valor");
        return TransacaoCafeDTO.converter(transacaoCafeEncontrado);
    }

    @Override
    public List<TransacaoCafeDTO> encontrarTransacaoComValorMenorIgual(BigDecimal valor) {
        List<TransacaoCafeEntity> transacaoCafeEncontrado = this.transacaoCafeRepository
                .findByValorDaTransacaoCafeLessThanEqual(valor);
        if(transacaoCafeEncontrado.isEmpty()) throw  new ResourceNotFoundException("não foi encontrado transacoes com este valor");
        return TransacaoCafeDTO.converter(transacaoCafeEncontrado);
    }

    @Override
    public List<TransacaoCafeDTO> encontrarTransacaoComValorMaior(BigDecimal valor) {
        List<TransacaoCafeEntity> transacaoCafeEncontrado = this.transacaoCafeRepository
                .findByValorDaTransacaoCafeGreaterThan(valor);
        if(transacaoCafeEncontrado.isEmpty()) throw  new ResourceNotFoundException("não foi encontrado transacoes com este valor");
        return TransacaoCafeDTO.converter(transacaoCafeEncontrado);
    }

    @Override
    public List<TransacaoCafeDTO> encontrarTransacaoComValorMaiorIgual(BigDecimal valor) {
        List<TransacaoCafeEntity> transacaoCafeEncontrado = this.transacaoCafeRepository
                .findByValorDaTransacaoCafeGreaterThanEqual(valor);
        if(transacaoCafeEncontrado.isEmpty()) throw  new ResourceNotFoundException("não foi encontrado transacoes com este valor");
        return TransacaoCafeDTO.converter(transacaoCafeEncontrado);
    }
}