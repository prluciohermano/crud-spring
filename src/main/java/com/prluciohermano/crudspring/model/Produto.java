package com.prluciohermano.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length=100, nullable=false)
    private String descricao;

    @Column(length=10, nullable=false)
    private String anoModelo;

    @Column(length=20, nullable=false)
    private String corProduto;

    @Column
    private Double precoEntrada;

    @Column(length=20, nullable=false)
    private String categoria;
    
}
