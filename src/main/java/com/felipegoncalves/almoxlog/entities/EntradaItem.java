package com.felipegoncalves.almoxlog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipegoncalves.almoxlog.entities.pk.EntradaItemPK;

@Entity
@Table(name = "tb_entrada_item")
public class EntradaItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EntradaItemPK id = new EntradaItemPK();

	private Integer quantidade;
	private Double preco;

	public EntradaItem() {
		super();
	}

	public EntradaItem(Lote lote, Entrada entrada, Integer quantidade, Double preco) {
		super();
		id.setLote(lote);
		id.setEntrada(entrada);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Lote getLote() {
		return id.getLote();
	}

	public void setLote(Lote lote) {
		id.setLote(lote);
	}

	@JsonIgnore
	public Entrada getEntrada() {
		return id.getEntrada();
	}

	public void setEntrada(Entrada entrada) {
		id.setEntrada(entrada);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getSubTotal() {
		return preco * quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaItem other = (EntradaItem) obj;
		return Objects.equals(id, other.id);
	}

}
