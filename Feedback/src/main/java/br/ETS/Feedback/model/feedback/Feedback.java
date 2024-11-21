package br.ETS.Feedback.model.feedback;

import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.instrutor.Instrutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_feedback")
@Entity(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aprendiz_id")
    private Aprendiz aprendiz;

    private LocalDateTime dateTime;

    public Feedback(Instrutor instrutor, Aprendiz aprendiz, LocalDateTime dateTime) {
        this.instrutor = instrutor;
        this.aprendiz = aprendiz;
        this.dateTime = dateTime;
    }
}
