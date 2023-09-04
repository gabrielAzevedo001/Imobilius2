package br.com.imobilius2.controller;

import br.com.imobilius2.domain.imovel.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("imoveis")
public class ImovelController {

    @Autowired
    private ImovelRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroImovel dados, UriComponentsBuilder uriBuilder) {
        var imovel = new Imovel(dados);
        repository.save(imovel);

        var uri = uriBuilder.path("imoveis/{id}").buildAndExpand(imovel.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoImovel(imovel));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemImovel>> listar(@PageableDefault(size = 10, sort = {"endereco.logradouro"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemImovel::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var imovel = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoImovel(imovel));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoImovel dados) {
        var imovel = repository.getReferenceById(dados.id());
        imovel.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoImovel(imovel));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var imovel = repository.getReferenceById(id);
        imovel.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
