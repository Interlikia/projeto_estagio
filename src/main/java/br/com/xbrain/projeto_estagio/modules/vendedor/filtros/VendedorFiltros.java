package br.com.xbrain.projeto_estagio.modules.vendedor.filtros;

import br.com.xbrain.projeto_estagio.modules.vendedor.predicate.VendedorPredicate;
import com.querydsl.core.BooleanBuilder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VendedorFiltros {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public BooleanBuilder toPredicate() {

        return new VendedorPredicate()
                .entreDatas(dataInicio, dataFim)
                .build();
    }

}
