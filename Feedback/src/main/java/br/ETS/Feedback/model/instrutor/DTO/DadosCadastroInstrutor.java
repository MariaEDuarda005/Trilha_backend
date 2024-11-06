package br.ETS.Feedback.model.instrutor.DTO;

import br.ETS.Feedback.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroInstrutor(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank @Pattern(regexp = "^\\d{8}$") String edv,
        @NotNull Curso curso,
        @NotNull @Valid DadosInformacoes informacoes,
        @NotNull Boolean ferias) {
}
