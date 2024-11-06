package br.ETS.Feedback.model.instrutor.DTO;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.instrutor.Instrutor;

public record DadosListagemInstrutor(String nome,
                                     String email,
                                     String edv,
                                     Boolean ferias,
                                     Curso curso) {

    // construtor
    public DadosListagemInstrutor(Instrutor instrutor){
        // se refere ao construtor padrão da classe
        this(instrutor.getNome(), instrutor.getEmail(), instrutor.getEdv(),
                instrutor.getFerias(), instrutor.getCurso());
    }

}
 // Boolean com B maiusculo aceita true, false e null