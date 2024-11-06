package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.aprendiz.AprendizRepository;
import br.ETS.Feedback.model.aprendiz.DTO.DadosAtualizacaoAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosCadastroAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosInformacoesAprendizCompleta;
import br.ETS.Feedback.model.aprendiz.DTO.DadosListagemAprendiz;
import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoesCompleta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/aprendiz")
public class AprendizController {

    @Autowired
    private AprendizRepository aprendizRepository;

    @PostMapping
    public ResponseEntity<DadosListagemAprendiz> cadastrar(@RequestBody @Valid DadosCadastroAprendiz dados, UriComponentsBuilder uriComponentsBuilder){
        var aprendiz = new Aprendiz(dados);
        aprendizRepository.save(aprendiz);
        var uri = uriComponentsBuilder.path("/aprendiz/{id}").buildAndExpand(aprendiz.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemAprendiz(aprendiz));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemAprendiz>> listar(){
        var list = aprendizRepository.findAllByAtivoTrue().stream().map(
                DadosListagemAprendiz::new
        ).toList();

        return ResponseEntity.ok(list);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemAprendiz> atualizar(@RequestBody @Valid DadosAtualizacaoAprendiz dados){
        var aprendiz = aprendizRepository.getReferenceById(dados.id());
        aprendiz.atualizar(dados);
        return ResponseEntity.ok(new DadosListagemAprendiz(aprendiz));
    }

    @DeleteMapping("/exclusao/{id}")
    public void excluirDoBanco(@PathVariable int id){
        aprendizRepository.deleteById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Aprendiz> excluir(@PathVariable int id){
        var aprendiz = aprendizRepository.getReferenceById(id);
        aprendiz.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosInformacoesAprendizCompleta> detalharAprendiz(@PathVariable int id){
        var aprendiz = aprendizRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesAprendizCompleta(aprendiz));
    }

    // como mandar

//    {
//        "id": 1,
//            "nome":"Maria Eduarda Ferreira",
//            "email":"maria.eduarda@br.ETS.com",
//            "edv":"92903533",
//            "curso":"DS",
//            "ferias":false,
//            "informacoes":{
//        "disciplina":"Java",
//                "trilha":"DEV - Backend",
//                "faculdade":"Senai",
//                "turma":"DS 8"
//    }
//    }
}
