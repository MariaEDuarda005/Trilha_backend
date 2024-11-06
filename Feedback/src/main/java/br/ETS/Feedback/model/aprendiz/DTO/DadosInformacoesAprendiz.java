package br.ETS.Feedback.model.aprendiz.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosInformacoesAprendiz(
        @NotBlank String trilha,
        @NotBlank String faculdade,
        @NotBlank String turma
) {
}
