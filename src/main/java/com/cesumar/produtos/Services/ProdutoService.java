package com.cesumar.produtos.Services;

import com.cesumar.produtos.Models.ProdutoModel;
import com.cesumar.produtos.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> getAll() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> get(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoModel create(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> delete(Long id) {
        Optional<ProdutoModel> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produtoRepository.deleteById(id);
        }
        return optional;
    }

    public Optional<ProdutoModel> patch(Long id, ProdutoModel produtoModel) {
        Optional<ProdutoModel> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produtoModel.setId(id);
            produtoRepository.save(produtoModel);
        }
        return optional;
    }
}
