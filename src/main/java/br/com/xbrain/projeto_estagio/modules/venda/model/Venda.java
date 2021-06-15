package br.com.xbrain.projeto_estagio.modules.venda.model;

import br.com.xbrain.projeto_estagio.modules.produto.model.Produto;
import br.com.xbrain.projeto_estagio.modules.vendedor.model.Vendedor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "VENDA")
public class Venda {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_VENDA", sequenceName = "SEQ_VENDA", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_VENDA", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "DATA_REGISTRO_VENDA")
	private LocalDateTime data;

	@ManyToOne
	@JoinColumn(name = "FK_VENDEDOR")
	private Vendedor vendedor;

	@Column(name = "VALOR")
	private Double valor;

	@ManyToMany
	@JoinTable(
			name = "PRODUTOS_VENDA",
			joinColumns = @JoinColumn(name = "VENDA.ID"),
			inverseJoinColumns = @JoinColumn(name = "PRODUTO.ID"))
	List<Produto> produtos;
	
}
