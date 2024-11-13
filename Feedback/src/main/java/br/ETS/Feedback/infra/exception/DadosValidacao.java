package br.ETS.Feedback.infra.exception;

import org.springframework.validation.FieldError;

public record DadosValidacao(String field, String message) {

    public DadosValidacao(FieldError fieldError){
        // pegar o erro só os campos necessários
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }

}
