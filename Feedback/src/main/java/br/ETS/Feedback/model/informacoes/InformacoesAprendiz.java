package br.ETS.Feedback.model.informacoes;

import br.ETS.Feedback.model.aprendiz.DTO.DadosInformacoesAprendiz;
import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoes;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter // faz metodos getter para todos os atributos
@Setter // faz metodos setter para todos os atributos
@AllArgsConstructor // construtor com todos os atributos
@NoArgsConstructor // faz construtor padrão, sem atributos
@EqualsAndHashCode // faz o metodo equal e hashcode
@Embeddable // É A TABELA SECUNDARIA, LIGADA A TABELA DE APRENDIZ
public class InformacoesAprendiz {

    private String trilha;
    private String faculdade;
    private String turma;

    public InformacoesAprendiz(DadosInformacoesAprendiz dadosInformacoesAprendiz){
        this.trilha = dadosInformacoesAprendiz.trilha();
        this.faculdade = dadosInformacoesAprendiz.faculdade();
        this.turma = dadosInformacoesAprendiz.turma();
    }

    public void atualizar(DadosInformacoesAprendiz dadosInformacoes){
        this.trilha = dadosInformacoes.trilha() != null ? dadosInformacoes.trilha() : this.trilha;
        this.faculdade = dadosInformacoes.faculdade() != null ? dadosInformacoes.faculdade() : this.faculdade;
        this.turma = dadosInformacoes.turma() != null ? dadosInformacoes.turma() : this.turma;
    }


}
