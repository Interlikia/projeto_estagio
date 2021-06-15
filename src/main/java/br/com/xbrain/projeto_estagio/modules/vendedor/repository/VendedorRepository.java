package br.com.xbrain.projeto_estagio.modules.vendedor.repository;

import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

    @Override
    public List<Vendedor> findAll();

}
