package com.felipegoncalves.almoxlog.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.felipegoncalves.almoxlog.entities.Lote;
import com.felipegoncalves.almoxlog.entities.Saida;

@Embeddable
public class SaidaItemPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "lote_id")
	private Lote lote;

	@ManyToOne
	@JoinColumn(name = "saida_id")
	private Saida saida;

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(saida, lote);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaidaItemPK other = (SaidaItemPK) obj;
		return Objects.equals(saida, other.saida) && Objects.equals(lote, other.lote);
	}

}
