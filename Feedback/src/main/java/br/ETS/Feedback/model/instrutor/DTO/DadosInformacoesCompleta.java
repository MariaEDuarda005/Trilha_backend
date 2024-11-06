package br.ETS.Feedback.model.instrutor.DTO;

import br.ETS.Feedback.model.informacoes.InformacoesInstrutor;
import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.instrutor.Instrutor;

public record DadosInformacoesCompleta(
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        boolean ferias,
        boolean ativo,
        InformacoesInstrutor informacoesInstrutor
) {

    public DadosInformacoesCompleta(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getEdv(),
        instrutor.getCurso(), instrutor.getFerias(), instrutor.isAtivo(), instrutor.getInformacoesInstrutor());
    }
}
