package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.CafeEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.PessoaEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.PessoaRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.PessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.PessoaForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    public final PessoaRepository pessoaRepository;

    @Override
    public List<PessoaDTO> buscarTodaPessoa() {
        List<PessoaEntity> listaDePessoa = this.pessoaRepository.findAll();
        if (listaDePessoa.isEmpty()) throw  new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Lista de pessoa está vazia");
        return PessoaDTO.converter(listaDePessoa);
    }

    @Override
    public void criarPessoa(PessoaForm pessoaForm) {
        PessoaEntity pessoaCriada = new PessoaEntity();

        pessoaCriada.setNome(pessoaForm.getNome());
        pessoaCriada.setEmail(pessoaForm.getEmail());
        pessoaCriada.setCpf(pessoaForm.getCpf());
        this.pessoaRepository.save(pessoaCriada);
    }

    @Override
    public void atualizarPessoa(PessoaForm pessoaForm, Long id) {
        Optional<PessoaEntity> pessoaEncontrada = this.pessoaRepository.findById(id);
        if (pessoaEncontrada.isEmpty()) throw new RuntimeException("Essa pessoa não existe");
        this.pessoaRepository.save(converterForm(pessoaForm,id));
    }

    public PessoaEntity converterForm(PessoaForm pessoaForm, Long id) {
        PessoaEntity pessoaCriada = new PessoaEntity();
        pessoaCriada.setId(id);
        pessoaCriada.setNome(pessoaForm.getNome());
        pessoaCriada.setEmail(pessoaForm.getEmail());
        pessoaCriada.setCpf(pessoaForm.getCpf());
        return pessoaCriada;
    }

    @Override
    public void deletarPessoa(Long id) {
        this.pessoaRepository.deleteById(id);
    }

}
