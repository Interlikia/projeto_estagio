package br.com.xbrain.projeto_estagio.modules.vendedor.dto;

import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import lombok.Data;

@Data
public class VendedorResponse {

    private String nomeVendedor;
    private Double totalVendas;
    private Double mediaVendasDiarias;

    public static VendedorResponse of(Vendedor vendedor, Double totalVendas, Double mediaVendasDiarias) {
        VendedorResponse vendedorResponse = new VendedorResponse();
        vendedorResponse.setNomeVendedor(vendedor.getNome());
        vendedorResponse.setTotalVendas(totalVendas);
        vendedorResponse.setMediaVendasDiarias(mediaVendasDiarias);

        return vendedorResponse;
    }

}
