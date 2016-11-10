package com.uepb.evento.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Size(min = 3, max = 6, message = "O código deve conter entre 3 e 6 caracteres")
	private String codigo;
	
	@NotEmpty(message = "A descrição é obrigatória")
	private String descricao;
	
	@DecimalMin(value = "1", message="A quantidade deve ser maior que 1")
	private int quantidade;
	
	@NotNull(message = "O preço é obrigatório")
	@Column(precision = 10, scale = 2)
	@DecimalMin(value = "1.00" , message = "O preço não pode ser menor que R$ 1.00")
	@DecimalMax(value = "100.00", message = "O preço não pode ser maior que R$ 100.00")
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private TipoTributacao tributacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public TipoTributacao getTributacao() {
		return tributacao;
	}
	
	public void setTributacao(TipoTributacao tributacao) {
		this.tributacao = tributacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
