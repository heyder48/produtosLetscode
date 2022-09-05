package com.example.produtos.services;

import com.example.produtos.dao.ProdutoDao;
import com.example.produtos.dto.ProdutoDto;
import com.example.produtos.form.ProdutoForm;
import com.example.produtos.modelos.Produto;
import com.example.produtos.services.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public List<ProdutoDto> listar() {

        List<Produto> produtos = produtoDao.findAll();

        return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());

    }

    @Override
    public ProdutoDto buscarPorId(Long id) {

        Produto produto = produtoDao.findById(id).get();

        return new ProdutoDto(produto);


    }

    @Override
    public ProdutoDto cadastrar(ProdutoForm form) {
        Produto produto = new Produto(form.getNome(), form.getDescricao(), new BigDecimal(form.getPreco()));
        produtoDao.save(produto);
        return new ProdutoDto(produto);
    }

    @Override
    public ProdutoDto atualizar(Long id, ProdutoForm form) {
        Produto produto = produtoDao.findById(id).get();
        if (form.getNome() != null  && !form.getNome().isEmpty()) {
            produto.setNome(form.getNome());
        }
        if (form.getDescricao() != null && !form.getDescricao().isEmpty()) {
            produto.setDescricao(form.getDescricao());
        }
        if (form.getPreco() != null ) {
            produto.setPreco(new BigDecimal(form.getPreco()));
        }

        return new ProdutoDto(produto);
    }

    @Override
    public void remover(Long id) {
        produtoDao.deleteById(id);

    }
}
