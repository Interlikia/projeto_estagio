package br.com.xbrain.projeto_estagio.modules.venda.controller;

import br.com.xbrain.projeto_estagio.modules.venda.model.Venda;
import br.com.xbrain.projeto_estagio.modules.venda.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@PostMapping("registrar-venda")
	public void registrar(@Validated @RequestBody Venda venda) {
		vendaService.registrar(venda);
	}
	
}
