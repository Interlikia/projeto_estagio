package br.com.xbrain.projeto_estagio.modules.vendedor.controller;

import br.com.xbrain.projeto_estagio.modules.vendedor.dto.VendedorResponse;
import br.com.xbrain.projeto_estagio.modules.vendedor.filtros.VendedorFiltros;
import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import br.com.xbrain.projeto_estagio.modules.vendedor.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@GetMapping ("tabulacao")
	public List<VendedorResponse> tabularVendedores(@RequestBody VendedorFiltros vendedorFiltros) {
		return vendedorService.tabularVendedores(vendedorFiltros);
	}

	@PostMapping ("cadastrar")
	public void cadastrarVendedor(@Validated @RequestBody Vendedor vendedor){
		vendedorService.cadastrarVendedor(vendedor);
	}
	
}
