package com.felipegoncalves.almoxlog.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.felipegoncalves.almoxlog.entities.Entrada;
import com.felipegoncalves.almoxlog.entities.Lote;

@Embeddable
public class EntradaItemPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "lote_id")
	private Lote lote;

	@ManyToOne
	@JoinColumn(name = "entrada_id")
	private Entrada entrada;

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(entrada, lote);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaItemPK other = (EntradaItemPK) obj;
		return Objects.equals(entrada, other.entrada) && Objects.equals(lote, other.lote);
	}

}
