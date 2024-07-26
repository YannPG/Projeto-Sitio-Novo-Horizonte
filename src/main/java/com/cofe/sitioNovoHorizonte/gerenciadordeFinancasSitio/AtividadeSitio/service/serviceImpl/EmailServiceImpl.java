package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.serviceImpl;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.models.EmailEntity;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.repository.EmailRepository;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.EmailPessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.exception.ResourceNotFoundException;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.EmailForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    public final EmailRepository emailRepository;

    @Override
    public List<EmailPessoaDTO> buscarTodoEmail() {
        List<EmailEntity> emailEncontrado = this.emailRepository.findAll();
        if (emailEncontrado.isEmpty()) throw new ResourceNotFoundException("Não foi encontrado nenhum email");
        return EmailPessoaDTO.converter(emailEncontrado);
    }

    @Override
    public void criarUmEmailPessoa(EmailForm emailForm) {
        EmailEntity emailCriado = new EmailEntity();
            emailCriado.setEmail(emailForm.getEmail());
            emailCriado.setDataDeCadastro(LocalDateTime.now());
            this.emailRepository.save(emailCriado);
    }

    @Override
    public void atualizarEmailPessoa(EmailForm emailForm, Long id) {
        Optional<EmailEntity> emailEncontrado = this.emailRepository.findById(id);
        if (emailEncontrado.isEmpty()) throw new ResourceNotFoundException("Não foi encontrado Email com este id");
        this.emailRepository.save(converterForm(emailForm, id));
    }


    public EmailEntity converterForm(EmailForm emailForm, Long id) {
        EmailEntity emailAtualizado = this.emailRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException( "Esse id não foi encontrado"));
        emailAtualizado.setEmail(emailForm.getEmail());
        emailAtualizado.setDataDeCadastro(LocalDateTime.now());
        return emailAtualizado;
    }


    @Override
    public void deletarEmailPorId(Long id) {
        this.emailRepository.deleteById(id);
    }

    @Override
    public List<EmailPessoaDTO> buscarEmailVerificado() {
        List<EmailEntity> emailEncontrado = this.emailRepository.findAll();
        if(emailEncontrado.isEmpty()) throw new ResourceNotFoundException("Não foram encontrados emails");

        List<EmailPessoaDTO> emailEncontradoFiltrado = emailEncontrado
                .stream()
                .filter(email -> email.getEmail().endsWith("@hotmail.com"))
                .map(email -> new EmailPessoaDTO(email.getIdUsuario(), email.getEmail()))
                .collect(Collectors.toList());

        return emailEncontradoFiltrado;
    }

}
