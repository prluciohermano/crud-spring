package com.prluciohermano.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prluciohermano.crudspring.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
