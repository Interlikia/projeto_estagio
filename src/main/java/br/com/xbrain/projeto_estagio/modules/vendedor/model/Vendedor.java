package br.com.xbrain.projeto_estagio.modules.vendedor.model;

import br.com.xbrain.projeto_estagio.modules.venda.model.Venda;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "VENDEDOR")
public class Vendedor {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_VENDEDOR", sequenceName = "SEQ_VENDEDOR", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_VENDEDOR", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Venda> vendas;

}
