package br.ETS.Feedback.model.aprendiz;

import br.ETS.Feedback.Curso;
import br.ETS.Feedback.model.aprendiz.DTO.DadosAtualizacaoAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosCadastroAprendiz;
import br.ETS.Feedback.model.informacoes.InformacoesAprendiz;
import br.ETS.Feedback.model.informacoes.InformacoesInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosAtualizacaoInstrutor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Aprendiz")
@Table(name = "tbAprendiz")
public class Aprendiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // adicionando sempre de 1 em 1
    private int id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded // vai ser links a tabela instrutor com a de informações
    private InformacoesAprendiz informacoesAprendiz;

    private Boolean ferias;

    private boolean ativo;


    public Aprendiz(DadosCadastroAprendiz dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.edv = dados.edv();
        this.curso = dados.curso();
        this.informacoesAprendiz = new InformacoesAprendiz(dados.informacoes());

        this.ferias = dados.ferias();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoAprendiz atualizacaoAprendiz) {
        if (atualizacaoAprendiz.nome() != null){
            this.nome = atualizacaoAprendiz.nome();
        }
        if (atualizacaoAprendiz.email() != null){
            this.email = atualizacaoAprendiz.email();
        }
        if (atualizacaoAprendiz.edv() != null){
            this.edv = atualizacaoAprendiz.edv();
        }
        if (atualizacaoAprendiz.curso() != null){
            this.curso = atualizacaoAprendiz.curso();
        }
        if (atualizacaoAprendiz.ferias() != null){
            this.ferias = atualizacaoAprendiz.ferias();
        }
        if (atualizacaoAprendiz.informacoesAprendiz() != null){
            this.informacoesAprendiz.atualizar(atualizacaoAprendiz.informacoesAprendiz());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
