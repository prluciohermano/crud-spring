package com.prluciohermano.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prluciohermano.crudspring.model.Produto;
import com.prluciohermano.crudspring.repository.ProdutoRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> list(){
        return produtoRepository.findAll();
    }

    @PostMapping
    private ResponseEntity<Produto> create(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<Produto> update(@PathVariable Long id,
             @RequestBody Produto produto) {
        return produtoRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setDescricao(produto.getDescricao());
                    recordFound.setAnoModelo(produto.getAnoModelo());
                    recordFound.setCorProduto(produto.getCorProduto());
                    recordFound.setPrecoEntrada(produto.getPrecoEntrada());
                    recordFound.setCategoria(produto.getCategoria());

                    Produto updated = produtoRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
