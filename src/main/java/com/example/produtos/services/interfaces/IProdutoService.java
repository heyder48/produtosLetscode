package com.example.produtos.services.interfaces;

import com.example.produtos.dto.ProdutoDto;
import com.example.produtos.form.ProdutoForm;

import java.util.List;

public interface IProdutoService {
    
    List<ProdutoDto> listar();

    ProdutoDto buscarPorId(Long id);

    ProdutoDto cadastrar(ProdutoForm form);

    ProdutoDto atualizar(Long id, ProdutoForm form);

    void remover(Long id);
}
