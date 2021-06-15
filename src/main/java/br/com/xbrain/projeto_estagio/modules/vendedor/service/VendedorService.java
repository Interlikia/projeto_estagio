package br.com.xbrain.projeto_estagio.modules.vendedor.service;

import br.com.xbrain.projeto_estagio.modules.venda.model.Venda;
import br.com.xbrain.projeto_estagio.modules.vendedor.dto.VendedorResponse;
import br.com.xbrain.projeto_estagio.modules.vendedor.filtros.VendedorFiltros;
import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import br.com.xbrain.projeto_estagio.modules.vendedor.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;
    
    public List<VendedorResponse> tabularVendedores(VendedorFiltros vendedorFiltros) {

        List<Vendedor> vendedores = vendedorRepository.findAll().stream().map(vendedor -> {
            vendedor.setVendas(filtrarVendas(vendedor, vendedorFiltros));
            return vendedor;
        }).collect(Collectors.toList());

        return vendedores.stream().map(vendedor -> calcularMediaVendedores(vendedor, vendedorFiltros)).collect(Collectors.toList());

    }

    public List<Venda> filtrarVendas(Vendedor vendedor, VendedorFiltros vendedorFiltros) {

        return vendedor.getVendas().stream().filter(venda -> venda.getData().isAfter(vendedorFiltros.getDataInicio())
        && venda.getData().isBefore(vendedorFiltros.getDataFim())).collect(Collectors.toList());

    }

    public VendedorResponse calcularMediaVendedores(Vendedor vendedor, VendedorFiltros vendedorFiltros) {
        Double totalVendas = (double) vendedor.getVendas().size();
        Double dias = (double) Duration.between(vendedorFiltros.getDataInicio(), vendedorFiltros.getDataFim()).toDays() + 1;
        Double mediaVendasDiarias = totalVendas/dias;
        return VendedorResponse.of(vendedor, totalVendas, mediaVendasDiarias);
    }

    public void cadastrarVendedor(Vendedor vendedor){ vendedorRepository.save(vendedor); }
}
