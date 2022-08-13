package com.felipegoncalves.almoxlog.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipegoncalves.almoxlog.entities.enums.EntidadeStatus;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Integer status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<Lote> lotes = new ArrayList<>();

	public Produto() {
		super();
	}

	public Produto(Long id, String descricao, EntidadeStatus status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public EntidadeStatus getStatus() {
		return EntidadeStatus.valueOf(status);
	}

	public void setStatus(EntidadeStatus entidadeStatus) {

		if (entidadeStatus != null) {
			this.status = entidadeStatus.getCode();
		}

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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
