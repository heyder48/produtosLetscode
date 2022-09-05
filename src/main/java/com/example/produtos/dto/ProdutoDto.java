package com.example.produtos.dto;

import com.example.produtos.modelos.Produto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoDto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco.setScale(2, RoundingMode.HALF_DOWN);
    }
}
