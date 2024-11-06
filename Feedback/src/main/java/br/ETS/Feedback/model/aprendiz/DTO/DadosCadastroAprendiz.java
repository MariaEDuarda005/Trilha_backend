package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAprendiz(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank @Pattern(regexp = "^\\d{8}$") String edv,
        @NotNull Curso curso,
        @NotNull @Valid DadosInformacoesAprendiz informacoes,
        @NotNull Boolean ferias
) {
}
