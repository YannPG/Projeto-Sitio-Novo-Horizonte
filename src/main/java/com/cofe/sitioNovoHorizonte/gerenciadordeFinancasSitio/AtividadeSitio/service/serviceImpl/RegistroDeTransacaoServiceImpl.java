package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.RegistroDeTransacaoEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.RegistroDeTransacaoRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.TransacaoCafeRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.RegistroDeTransacaoDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.RegistroDeTransacaoForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.RegistroDeTransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistroDeTransacaoServiceImpl implements RegistroDeTransacaoService {

    public final RegistroDeTransacaoRepository registroDeTransacaoRepository;
    public final TransacaoCafeRepository transacaoCafeRepository;

    @Override
    public List<RegistroDeTransacaoDTO> buscarTodoRegistroDeTransacao() {
        List<RegistroDeTransacaoEntity> listRegistroDeTransacao = this.registroDeTransacaoRepository.findAll();
        if (listRegistroDeTransacao.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não foram encontrados registros de transacao");
        return RegistroDeTransacaoDTO.converter(listRegistroDeTransacao);
    }

    @Override
    public void criarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm) {
        RegistroDeTransacaoEntity registroDeTransacaoCriado = new RegistroDeTransacaoEntity();
        registroDeTransacaoCriado.setDataTransacao(registroDeTransacaoForm.getDataTransacao());
        registroDeTransacaoCriado.setDescricao(registroDeTransacaoForm.getDescricao());
        registroDeTransacaoCriado.setTransacaoCafe( this.transacaoCafeRepository.findById(registroDeTransacaoForm.getIdTransacaoCafe())
                .orElseThrow(() -> new IllegalArgumentException("Transação de café não encontrada para o ID fornecido.")));
        this.registroDeTransacaoRepository.save(registroDeTransacaoCriado);
    }

    @Override
    public void atualizarRegistroDeTransacao(RegistroDeTransacaoForm registroDeTransacaoForm, Long id) {
        RegistroDeTransacaoEntity registroDeTransacaoEncontrado = this.registroDeTransacaoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Não foi encontrado nenhum registro neste id"));

        RegistroDeTransacaoEntity registroDeTransacaoAtualizado = convertSitioForm(registroDeTransacaoForm, id);
        this.registroDeTransacaoRepository.save(registroDeTransacaoAtualizado);
    }

    @Override
    public void encontrarPeloId(Long id) {

    }

    public RegistroDeTransacaoEntity convertSitioForm(RegistroDeTransacaoForm registroDeTransacaoForm, Long id) {
        RegistroDeTransacaoEntity novoRegistroDeTransacao = new RegistroDeTransacaoEntity();
        novoRegistroDeTransacao.setIdRegistroDeTransacao(id);
        novoRegistroDeTransacao.setTransacaoCafe(this.transacaoCafeRepository.findById(registroDeTransacaoForm.getIdTransacaoCafe())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi encontrado ID com este valor")));
        novoRegistroDeTransacao.setDescricao(registroDeTransacaoForm.getDescricao());
        novoRegistroDeTransacao.setDataTransacao(registroDeTransacaoForm.getDataTransacao());
        return novoRegistroDeTransacao;
    }

    @Override
    public void deletarRegistroDeTransacao(Long id) {
        this.registroDeTransacaoRepository.deleteById(id);
    }
}