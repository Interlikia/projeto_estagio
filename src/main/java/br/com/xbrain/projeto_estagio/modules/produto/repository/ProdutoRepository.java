package br.com.xbrain.projeto_estagio.modules.produto.repository;

import br.com.xbrain.projeto_estagio.modules.produto.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    List<Produto> findAll();
}
