package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.controller;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.dto.EmailPessoaDTO;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.rest.forms.EmailForm;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/email")
public class EmailController {

    public final EmailService emailService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/todoEmailCadastrado")
    public List<EmailPessoaDTO> todoEmailCadastrado(){
        return this.emailService.buscarTodoEmail();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/criarUmEmailPessoa")
    public void criarUmEmailPessoa(@RequestBody @Valid EmailForm emailForm){
        this.emailService.criarUmEmailPessoa(emailForm);
    }

    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/atualizarEmailPessoa/{id}")
    public void atualizarEmailPessoa(@RequestBody @Valid EmailForm emailForm,
                                     @PathVariable Long id){
        this.emailService.atualizarEmailPessoa(emailForm, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deletarEmail/{id}")
    public void deletarEmailPorId(@PathVariable Long id){
        this.emailService.deletarEmailPorId(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/todoEmailVerificado")
    public List<EmailPessoaDTO> todoEmailVerificado(){
        return this.emailService.buscarEmailVerificado();
    }

}
