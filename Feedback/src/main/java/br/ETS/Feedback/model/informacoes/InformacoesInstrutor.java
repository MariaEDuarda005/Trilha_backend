package br.ETS.Feedback.model.informacoes;

import br.ETS.Feedback.model.aprendiz.DTO.DadosInformacoesAprendiz;
import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoes;
import jakarta.persistence.*;
import lombok.*;

@Getter // faz metodos getter para todos os atributos
@Setter // faz metodos setter para todos os atributos
@AllArgsConstructor // construtor com todos os atributos
@NoArgsConstructor // faz construtor padrão, sem atributos
@EqualsAndHashCode // faz o metodo equal e hashcode
@Embeddable // É A TABELA SECUNDARIA, LIGADA A TABELA DE INSTRUTOR
public class InformacoesInstrutor {

    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    public InformacoesInstrutor(DadosInformacoes dadosInformacoes){
        this.disciplina = dadosInformacoes.disciplina();
        this.trilha = dadosInformacoes.trilha();
        this.faculdade = dadosInformacoes.faculdade();
        this.turma = dadosInformacoes.turma();
    }

    public void atualizar(DadosInformacoes dadosInformacoes){
        this.disciplina = dadosInformacoes.disciplina() != null ? dadosInformacoes.disciplina() : this.disciplina;
        this.trilha = dadosInformacoes.trilha() != null ? dadosInformacoes.trilha() : this.trilha;
        this.faculdade = dadosInformacoes.faculdade() != null ? dadosInformacoes.faculdade() : this.faculdade;
        this.turma = dadosInformacoes.turma() != null ? dadosInformacoes.turma() : this.turma;
    }

}
