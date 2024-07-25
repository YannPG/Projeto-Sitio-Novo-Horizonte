package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.RegistroDeTransacaoEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.RegistroDeTransacaoRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.TransacaoCafeRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.RegistroDeTransacaoDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.exception.ResourceNotFoundException;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.RegistroDeTransacaoForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.RegistroDeTransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistroDeTransacaoServiceImpl implements RegistroDeTransacaoService {

    public final RegistroDeTransacaoRepository registroDeTransacaoRepository;
    public final TransacaoCafeRepository transacaoCafeRepository;


    //GET do CRUD
    @Override
    public List<RegistroDeTransacaoDTO> buscarTodoRegistroDeTransacao() {
        List<RegistroDeTransacaoEntity> listRegistroDeTransacao = this.registroDeTransacaoRepository.findAll();
        if (listRegistroDeTransacao.isEmpty()) throw new ResourceNotFoundException("Não foram encontrados registros de transacao");
        return RegistroDeTransacaoDTO.converter(listRegistroDeTransacao);
    }

    //POST do CRUD
    @Override
    public void criarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm) {
        RegistroDeTransacaoEntity registroDeTransacaoCriado = new RegistroDeTransacaoEntity();
        registroDeTransacaoCriado.setDataTransacao(registroDeTransacaoForm.getDataTransacao());
        registroDeTransacaoCriado.setTransacaoCafe( this.transacaoCafeRepository.findById(registroDeTransacaoForm.getIdTransacaoCafe())
                .orElseThrow(() -> new IllegalArgumentException("Transação de café não encontrada para o ID fornecido.")));
        this.registroDeTransacaoRepository.save(registroDeTransacaoCriado);
    }

    //PUT do CRUD
    @Override
    public void atualizarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm, Long id) {
        RegistroDeTransacaoEntity registroDeTransacaoEncontrado = this.registroDeTransacaoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Não foi encontrado nenhum registro neste id"));

        RegistroDeTransacaoEntity registroDeTransacaoAtualizado = convertSitioForm(registroDeTransacaoForm, id);
        this.registroDeTransacaoRepository.save(registroDeTransacaoAtualizado);
    }

    public RegistroDeTransacaoEntity convertSitioForm(RegistroDeTransacaoForm registroDeTransacaoForm, Long id) {
        RegistroDeTransacaoEntity novoRegistroDeTransacao = new RegistroDeTransacaoEntity();
        novoRegistroDeTransacao.setIdRegistroDeTransacao(id);
        novoRegistroDeTransacao.setTransacaoCafe(this.transacaoCafeRepository.findById(registroDeTransacaoForm.getIdTransacaoCafe())
                .orElseThrow(()-> new ResourceNotFoundException("Não foi encontrado ID com este valor")));
        novoRegistroDeTransacao.setDataTransacao(registroDeTransacaoForm.getDataTransacao());
        return novoRegistroDeTransacao;
    }

    //DELEAT do CRUD
    @Override
    public void deletarRegistroDeTransacao(Long id) {
        if(id == null ) throw new ResourceNotFoundException("Não foi encontrado nenhum registro com este ID");
        this.registroDeTransacaoRepository.deleteById(id);
    }

    //FindById
    @Override
    public RegistroDeTransacaoDTO buscarTodoRegistroDeTransacao(Long id) {
        RegistroDeTransacaoEntity registroDeTransacaoEncontradoPeloId = this.registroDeTransacaoRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Não foi encontrado registro com este ID"));
        return RegistroDeTransacaoDTO.converterDTO(registroDeTransacaoEncontradoPeloId);
    }

    //deletById
    @Override
    public void deletarRegistroDeTransacaoPeloId(Long idRegistroDeTransacao) {
        if(idRegistroDeTransacao == null)throw new ResourceNotFoundException("Não há Registro com este ID");
        this.registroDeTransacaoRepository.deleteByIdRegistroDeTransacao(idRegistroDeTransacao);
    }



    //FindFirstBy
    @Override
    public List<RegistroDeTransacaoDTO> encontrarPrimeiroRegistroDeTransacaoDoMes(String mesSelecionado) {
        YearMonth yearMonth = YearMonth.parse(mesSelecionado);
        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23,59,59);

        List<RegistroDeTransacaoEntity> registroDeTransacaoEncontrado = this.registroDeTransacaoRepository
                .findFirstByDataTransacaoBetweenOrderByDataTransacaoAsc(start, end);
        if(registroDeTransacaoEncontrado.isEmpty())throw new ResourceNotFoundException("Não foi encontrado nenhum registro neste mes");
        return RegistroDeTransacaoDTO.converter(registroDeTransacaoEncontrado);
    }
}