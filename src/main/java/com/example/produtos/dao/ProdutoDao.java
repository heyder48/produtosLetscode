package com.example.produtos.dao;

import com.example.produtos.modelos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {


}
