package com.felipegoncalves.almoxlog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipegoncalves.almoxlog.entities.pk.SaidaItemPK;

@Entity
@Table(name = "tb_saida_item")
public class SaidaItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SaidaItemPK id = new SaidaItemPK();

	private Integer quantidade;
	private Double preco;

	public SaidaItem() {
		super();
	}

	public SaidaItem(Lote lote, Saida saida, Integer quantidade, Double preco) {
		super();
		id.setLote(lote);
		id.setSaida(saida);
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
	public Saida getSaida() {
		return id.getSaida();
	}

	public void setSaida(Saida saida) {
		id.setSaida(saida);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPreco() {
		return preco;
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
		SaidaItem other = (SaidaItem) obj;
		return Objects.equals(id, other.id);
	}

}
