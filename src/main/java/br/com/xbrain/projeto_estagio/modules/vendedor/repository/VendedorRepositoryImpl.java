package br.com.xbrain.projeto_estagio.modules.vendedor.repository;


import br.com.xbrain.projeto_estagio.modules.venda.model.Venda;
import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static br.com.xbrain.projeto_estagio.modules.venda.model.QVenda.venda;
import static br.com.xbrain.projeto_estagio.modules.vendedor.model.QVendedor.*;
import static br.com.xbrain.projeto_estagio.modules.venda.model.QVenda.*;

public class VendedorRepositoryImpl implements VendedorRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vendedor> tabularVendedores(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return new JPAQueryFactory(entityManager)
                .select(vendedor)
                .from(vendedor)
                .join(vendedor.vendas, venda).fetchJoin()
                .where(venda.data.between(dataInicio, dataFim))
                .fetch();
    }
}
