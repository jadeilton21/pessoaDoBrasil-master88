package pessoa.social.brasil.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pessoa.social.brasil.domain.pessoa.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoa")
public class Pessoa1Controller {

    @Autowired
    private PessoaRespository respository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        respository.save(pessoa);
        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        var page = respository.findAllByAtivoTrue(paginacao).map(DadosListagemPessoa::new);


         return ResponseEntity.ok(page);


    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtulizarPessoa dados){
            var pessoa = respository.getReferenceById(dados.id());
            pessoa.atualizarInformacoes(dados);

            return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        var pessoa = respository.getReferenceById(id);
        pessoa.excluir();
        return ResponseEntity.noContent().build();
    }





}
