package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.PessoaEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.PessoaRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.SitioRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.exception.ResourceNotFoundException;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.PessoaForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    public final PessoaRepository pessoaRepository;
    public final SitioRepository sitioRepository;

    @Override
    public List<PessoaDTO> buscarTodaPessoa() {
        List<PessoaEntity> listaDePessoa = this.pessoaRepository.findAll();
        if (listaDePessoa.isEmpty()) throw  new ResourceNotFoundException("Lista de pessoa está vazia");
        return PessoaDTO.converter(listaDePessoa);
    }

    @Override
    public void criarPessoa(PessoaForm pessoaForm) {
        PessoaEntity pessoaCriada = new PessoaEntity();

        pessoaCriada.setNome(pessoaForm.getNome());
        pessoaCriada.setEmail(pessoaForm.getEmail());
        pessoaCriada.setCpf(pessoaForm.getCpf());
        pessoaCriada.setDataNascimento(LocalDate.parse(pessoaForm.getDataNascimento()));
        this.pessoaRepository.save(pessoaCriada);
    }

    @Override
    public void atualizarPessoa(PessoaForm pessoaForm, Long id) {
        Optional<PessoaEntity> pessoaEncontrada = this.pessoaRepository.findById(id);
        if (pessoaEncontrada.isEmpty()) throw new ResourceNotFoundException("Essa pessoa não existe");
        this.pessoaRepository.save(converterForm(pessoaForm,id));
    }

    public PessoaEntity converterForm(PessoaForm pessoaForm, Long id) {
        PessoaEntity pessoaCriada = new PessoaEntity();
        pessoaCriada.setId(id);
        pessoaCriada.setNome(pessoaForm.getNome());
        pessoaCriada.setEmail(pessoaForm.getEmail());
        pessoaCriada.setCpf(pessoaForm.getCpf());
        pessoaCriada.setDataNascimento(LocalDate.parse(pessoaForm.getDataNascimento()));
        return pessoaCriada;
    }

    @Override
    public void deletarPessoa(Long id) {
        this.pessoaRepository.deleteById(id);
    }

    //FindByOrderAsc
    @Override
    public List<PessoaDTO> encontrarPessoaPorOrdemAlfabetica() {
        List<PessoaEntity> listTodaPessoa = this.pessoaRepository.findAllByOrderByNomeAsc();
        if(listTodaPessoa.isEmpty()) throw new ResourceNotFoundException("lista de pessoas está vazia");
        return PessoaDTO.converter(listTodaPessoa);
    }

    //FindByOrderDesc
    @Override
    public List<PessoaDTO> encontrarPessoaPorOrdemDecrescente() {
        List<PessoaEntity> listTodaPessoaDesc = this.pessoaRepository.findAllByOrderByNomeDesc();
        if(listTodaPessoaDesc.isEmpty()) throw new ResourceNotFoundException("Lista de pessoas está vazia");
        return PessoaDTO.converter(listTodaPessoaDesc);
    }

    //FindByCpf
    @Override
    public List<PessoaDTO> econtrarPessoaPorCpf(Long cpf) {
        List<PessoaEntity> listaPessoaPorCpf = this.pessoaRepository.findByCpf(cpf);
        if(listaPessoaPorCpf.isEmpty())throw new ResourceNotFoundException("Não há pessoas com este Cpf");
        return PessoaDTO.converter(listaPessoaPorCpf);
    }

    //FindByIn
    @Override
    public List<PessoaDTO> encontrarPessoaPorDataDeNascimento(List<LocalDate> dataNascimento) {
        List<PessoaEntity> pessoaEncontradaPorDataNascimento = this.pessoaRepository
                .findByDataNascimentoIn(dataNascimento);
        if(pessoaEncontradaPorDataNascimento.isEmpty()) throw new ResourceNotFoundException("Não foi encontrada pessoa com está data de nascimento");
        return PessoaDTO.converter(pessoaEncontradaPorDataNascimento);
    }

    //findByBetween
    @Override
    public List<PessoaDTO> encontrarPessoaEntreDatas(LocalDate dataInicial, LocalDate dataFinal) {
        List<PessoaEntity> pessoaEncontradaEntreDatas = this.pessoaRepository
                .findByDataNascimentoBetween(dataInicial, dataFinal);
        if(pessoaEncontradaEntreDatas.isEmpty()) throw new ResourceNotFoundException("Não foram encontradas pessoas entre as datas solicitadas");
        return PessoaDTO.converter(pessoaEncontradaEntreDatas);
    }

}
