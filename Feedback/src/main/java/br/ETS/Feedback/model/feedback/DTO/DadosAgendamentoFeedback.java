package br.ETS.Feedback.model.feedback.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoFeedback(@NotNull int idInstrutor,
                                       @NotNull int idAprendiz,
                                       @NotNull @Future LocalDateTime dateTime) {
}
