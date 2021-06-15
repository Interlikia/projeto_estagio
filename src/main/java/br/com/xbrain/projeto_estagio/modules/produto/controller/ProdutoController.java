package br.com.xbrain.projeto_estagio.modules.produto.controller;

import br.com.xbrain.projeto_estagio.modules.produto.model.Produto;
import br.com.xbrain.projeto_estagio.modules.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping ("listar")
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@PostMapping ("cadastrar")
	public void cadastrarProduto(@Validated @RequestBody Produto produto){
		produtoService.cadastrarProduto(produto);
	}
	
}
