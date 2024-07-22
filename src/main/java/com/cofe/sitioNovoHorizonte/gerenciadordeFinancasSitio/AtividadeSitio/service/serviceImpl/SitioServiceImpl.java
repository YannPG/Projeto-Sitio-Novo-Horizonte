package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.SitioEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.PessoaRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.SitioRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.SitioDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.SitioForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.SitioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SitioServiceImpl implements SitioService {

    private final SitioRepository sitioRepository;
    private final PessoaRepository pessoaRepository;

    @Override
    public List<SitioDTO> buscarTodoSitio() {
        List<SitioEntity> listSitioEntity = this.sitioRepository.findAll();
        if(listSitioEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND
                ,"Não foi encontrado um Sitio" );
        return SitioDTO.converter(listSitioEntity);
    }

    @Override
    public void criarSitio(SitioForm sitioForm) {
        SitioEntity sitioCriado = new SitioEntity();

        sitioCriado.setIdPessoa(this.pessoaRepository.findById(sitioForm.getIdPessoa())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada")));
        sitioCriado.setNomeSitio(sitioForm.getNomeSitio());
        sitioCriado.setTipoProdutorEnum(sitioForm.getTipoProdutorEnum());
        sitioCriado.setEnderecoSitioEmbedable(sitioForm.getEnderecoProdutorEmbedable());

       this.sitioRepository.save(sitioCriado);
    }

    @Override
    public void atualizarSitio(SitioForm sitioForm, Long idSitio) {
        if (idSitio == null) {
            throw new IllegalArgumentException("ID do sitio não pode ser nulo");
        }
        SitioEntity sitioEncontrado = this.sitioRepository.findById(idSitio).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Sitio não Encontrado"));

        SitioEntity sitioAtualizado = convertSitioFormToEntity(sitioForm, idSitio);
        this.sitioRepository.save(sitioAtualizado);
    }

    private SitioEntity convertSitioFormToEntity(SitioForm sitioForm, Long idSitio) {
        SitioEntity novoSitio = new SitioEntity();
        novoSitio.setIdSitio(idSitio);
        novoSitio.setEnderecoSitioEmbedable(sitioForm.getEnderecoProdutorEmbedable());
        novoSitio.setNomeSitio(sitioForm.getNomeSitio());
        novoSitio.setTipoProdutorEnum(sitioForm.getTipoProdutorEnum());
        novoSitio.setIdPessoa(this.pessoaRepository.findById(sitioForm.getIdPessoa()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada")));

        return novoSitio;
    }

    @Override
    public void deletarSitioPeloId(Long idSitio){
        SitioEntity sitio = this.sitioRepository.findById(idSitio).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Sitio não encontrado"));
        this.sitioRepository.deleteById(idSitio);
    }
}
