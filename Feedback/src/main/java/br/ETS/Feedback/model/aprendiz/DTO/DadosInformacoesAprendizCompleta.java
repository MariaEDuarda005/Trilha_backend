package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.informacoes.InformacoesAprendiz;
import br.ETS.Feedback.model.informacoes.InformacoesInstrutor;

public record DadosInformacoesAprendizCompleta(
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        boolean ferias,
        boolean ativo,
        InformacoesAprendiz informacoesAprendiz
) {

    public DadosInformacoesAprendizCompleta(Aprendiz aprendiz){
        this(aprendiz.getId(), aprendiz.getNome(), aprendiz.getEmail(), aprendiz.getEdv(),
                aprendiz.getCurso(), aprendiz.getFerias(), aprendiz.isAtivo(), aprendiz.getInformacoesAprendiz());
    }

}
