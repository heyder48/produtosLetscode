package com.example.produtos.controllers;

import com.example.produtos.dto.ProdutoDto;
import com.example.produtos.form.ProdutoForm;
import com.example.produtos.services.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar() {

        return ResponseEntity.ok(produtoService.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(produtoService.buscarPorId(id));

    }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody ProdutoForm form){

        ProdutoDto produtoDto = produtoService.cadastrar(form);
        URI uri = UriComponentsBuilder.fromPath("/produtos/{id}").buildAndExpand(produtoDto.getId()).toUri();

        return ResponseEntity.created(uri).body(produtoDto);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody ProdutoForm form) {

        return ResponseEntity.ok(produtoService.atualizar(id, form));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Boolean> remover(@PathVariable Long id) {

        produtoService.remover(id);

        return ResponseEntity.ok(true);

    }

}
