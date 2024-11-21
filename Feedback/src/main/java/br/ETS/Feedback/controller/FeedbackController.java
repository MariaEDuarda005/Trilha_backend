package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.feedback.DTO.DadosAgendamentoFeedback;
import br.ETS.Feedback.model.feedback.DTO.DadosDetalhamentoFeedback;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoFeedback dadosAgendamentoFeedback){
        //return ResponseEntity.ok(new DadosDetalhamentoFeedback());
        return null;
    }
}
