package br.com.xbrain.projeto_estagio.modules.vendedor.repository;

import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import org.springframework.data.repository.CrudRepository;

public interface VendedorRepository extends CrudRepository<Vendedor, Integer>, VendedorRepositoryCustom {

}
