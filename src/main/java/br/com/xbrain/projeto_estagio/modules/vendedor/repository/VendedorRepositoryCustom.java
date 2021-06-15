package br.com.xbrain.projeto_estagio.modules.vendedor.repository;

import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;

import java.time.LocalDateTime;
import java.util.List;

public interface VendedorRepositoryCustom {
    List<Vendedor> tabularVendedores(LocalDateTime dataInicio, LocalDateTime dataFim);
}
