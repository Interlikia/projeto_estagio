package br.com.xbrain.projeto_estagio.modules.vendedor.predicate;

import br.com.xbrain.projeto_estagio.modules.venda.model.QVenda;
import com.querydsl.core.BooleanBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

public class VendedorPredicate {

    private QVenda venda = QVenda.venda;
    private BooleanBuilder builder;

    public VendedorPredicate() {
        this.builder = new BooleanBuilder();
    }

    public VendedorPredicate(BooleanBuilder builder) {
        this.builder = builder;
    }

    public VendedorPredicate entreDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (Objects.nonNull(dataInicio) && Objects.nonNull(dataFim)) {
            builder.and(venda.data.between(dataInicio, dataFim));
        }
        return this;
    }

    public BooleanBuilder build() {
        return this.builder;
    }
}
