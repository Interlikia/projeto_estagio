package br.com.xbrain.projeto_estagio.modules.produto.model;

import br.com.xbrain.projeto_estagio.modules.venda.model.Venda;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "PRODUTO")
public class Produto {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_PRODUTO", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "VALOR")
	private Double valor;

	@ManyToMany(mappedBy = "produtos", cascade = CascadeType.MERGE)
	private List<Venda> vendas;

}
