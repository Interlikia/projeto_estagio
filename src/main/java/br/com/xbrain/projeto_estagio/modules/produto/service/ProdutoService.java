package br.com.xbrain.projeto_estagio.modules.produto.service;

import br.com.xbrain.projeto_estagio.modules.produto.model.Produto;
import br.com.xbrain.projeto_estagio.modules.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void cadastrarProduto(Produto produto){ produtoRepository.save(produto); }
}
