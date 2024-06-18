package com.remedio.thiago.curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.remedio.thiago.curso.DTOItemRegistration.DadosAtualizarRemedio;
import com.remedio.thiago.curso.DTOItemRegistration.DadosCadastroRemedio;
import com.remedio.thiago.curso.DTOItemRegistration.DadosDetalhamentoRemedio;
import com.remedio.thiago.curso.DTOItemRegistration.DadosListagemRemedio;
import com.remedio.thiago.curso.Repositories.RemedioRepository;
import com.remedio.thiago.curso.remedio.Remedio;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uriBuilder){
        var remedio = repository.save(new Remedio(dados));
        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));

    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedio>> Listar(){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {  
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar (@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar(); 
        return ResponseEntity.noContent().build();
        
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<Void> ativar (@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.ativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> detalhar(@PathVariable Long id) {  
        var remedio = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));

    }
}
