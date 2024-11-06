package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.informacoes.InformacoesInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosAtualizacaoInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosCadastroInstrutor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Instrutor")
@Table(name = "tbInstrutores")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // adicionando sempre de 1 em 1
    private int id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded // vai ser links a tabela instrutor com a de informações
    private InformacoesInstrutor informacoesInstrutor;

    private Boolean ferias;

    private boolean ativo;


    public Instrutor(DadosCadastroInstrutor dadosCadastroInstrutor){
        this.nome = dadosCadastroInstrutor.nome();
        this.email = dadosCadastroInstrutor.email();
        this.edv = dadosCadastroInstrutor.edv();
        this.curso = dadosCadastroInstrutor.curso();
        this.informacoesInstrutor = new InformacoesInstrutor(dadosCadastroInstrutor.informacoes());

        this.ferias = dadosCadastroInstrutor.ferias();

        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoInstrutor atualizacaoInstrutor) {
        if (atualizacaoInstrutor.nome() != null){
            this.nome = atualizacaoInstrutor.nome();
        }
        if (atualizacaoInstrutor.email() != null){
            this.email = atualizacaoInstrutor.email();
        }
        if (atualizacaoInstrutor.edv() != null){
            this.edv = atualizacaoInstrutor.edv();
        }
        if (atualizacaoInstrutor.curso() != null){
            this.curso = atualizacaoInstrutor.curso();
        }
        if (atualizacaoInstrutor.ferias() != null){
            this.ferias = atualizacaoInstrutor.ferias();
        }
        if (atualizacaoInstrutor.informacoes() != null){
            this.informacoesInstrutor.atualizar(atualizacaoInstrutor.informacoes());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
