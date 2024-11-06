package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoes;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAprendiz(
        @NotNull int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean ferias,
        DadosInformacoesAprendiz informacoesAprendiz
) {
}
