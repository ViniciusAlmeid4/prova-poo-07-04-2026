package com.cesumar.produtos.Controllers;

import com.cesumar.produtos.Models.ProdutoModel;
import com.cesumar.produtos.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(path = "")
    public List<ProdutoModel> getAll() {
        return produtoService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> getById(@PathVariable Long id) {
        Optional <ProdutoModel> optional = produtoService.get(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "")
    public ResponseEntity<ProdutoModel> save(@RequestBody ProdutoModel produtoModel) {
        return ResponseEntity.ok().body(produtoService.create(produtoModel));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> update(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        Optional<ProdutoModel> optional = produtoService.patch(id, produtoModel);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else   {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<ProdutoModel> optional = produtoService.delete(id);
        if (optional.isPresent()) {
            return ResponseEntity.noContent().build();
        } else   {
            return ResponseEntity.notFound().build();
        }
    }
}
