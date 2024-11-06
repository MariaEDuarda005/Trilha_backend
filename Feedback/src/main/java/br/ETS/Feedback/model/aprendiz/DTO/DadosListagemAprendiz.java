package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.aprendiz.Aprendiz;

public record DadosListagemAprendiz(
        String nome,
        String email,
        String edv,
        Boolean ferias,
        Curso curso
) {

    public DadosListagemAprendiz(Aprendiz aprendiz){
        this(aprendiz.getNome(), aprendiz.getEmail(), aprendiz.getEdv(),
                aprendiz.getFerias(), aprendiz.getCurso());
    }

}
