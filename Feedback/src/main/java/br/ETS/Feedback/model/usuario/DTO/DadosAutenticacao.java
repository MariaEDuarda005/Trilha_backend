package br.ETS.Feedback.model.usuario.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(
        @NotNull String login,
        @NotNull String senha
) {

}
