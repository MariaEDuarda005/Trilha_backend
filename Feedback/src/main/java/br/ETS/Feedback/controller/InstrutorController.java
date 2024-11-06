package br.ETS.Feedback.controller;

// fazer os import pois não está dentro do mesmo pacote
import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoesCompleta;
import br.ETS.Feedback.model.instrutor.DTO.DadosAtualizacaoInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosCadastroInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosListagemInstrutor;
import br.ETS.Feedback.model.instrutor.Instrutor;
import br.ETS.Feedback.model.instrutor.InstrutorRepository;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    // RequestBody -> O corpo da requisição é a informação enviada pelo cliente para sua API.

    @PostMapping
    public ResponseEntity<DadosListagemInstrutor> cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor, UriComponentsBuilder uriComponentsBuilder){
        var instrutor = new Instrutor(dadosCadastroInstrutor);
        instrutorRepository.save(instrutor);
        // pegar a referencia e jogar para uma uri
        var uri = uriComponentsBuilder.path("/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listar(@PageableDefault(size = 10, sort = {"edv"}) Pageable pageable){

          var page =  instrutorRepository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
          return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional // garante que a alteração do banco de dados
    public ResponseEntity<DadosListagemInstrutor> atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor atualizacaoInstrutor) {
        var instrutor = instrutorRepository.getReferenceById(atualizacaoInstrutor.id());
        instrutor.atualizar(atualizacaoInstrutor);
        return ResponseEntity.ok(new DadosListagemInstrutor(instrutor));
    }

    @DeleteMapping("/exclusao/{id}")
    public void excluirDoBanco(@PathVariable int id){
        instrutorRepository.deleteById(id);
    }

    // exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var instrutor = instrutorRepository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosInformacoesCompleta> detalharInstrutor(@PathVariable int id){
        var instrutor = instrutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesCompleta(instrutor));
    }

    // como mandar

//    {
//        "nome":"Vinicius Ferreira",
//            "email":"FerreiraVinicius@br.ETS.com",
//            "edv":"92897645",
//            "curso":"DS",
//            "informacoes":{
//        "disciplina":"Python",
//                "trilha":"CyberSecurity",
//                "faculdade":"Fatec",
//                "turma":"DS 11"
//    }
//    }

}
