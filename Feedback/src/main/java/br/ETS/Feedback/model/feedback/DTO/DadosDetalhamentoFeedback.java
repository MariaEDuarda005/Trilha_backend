package br.ETS.Feedback.model.feedback.DTO;

import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.instrutor.Instrutor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalhamentoFeedback(int id,
                                        int idInstrutor,
                                        int idAprendiz,
                                        LocalDateTime dateTime) {

    public DadosDetalhamentoFeedback(int id, int idInstrutor, int idAprendiz, LocalDateTime dateTime) {
        this.id = id;
        this.idInstrutor = idInstrutor;
        this.idAprendiz = idAprendiz;
        this.dateTime = dateTime;
    }
}
