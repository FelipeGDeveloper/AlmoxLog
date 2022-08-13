package com.felipegoncalves.almoxlog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipegoncalves.almoxlog.entities.enums.EntidadeStatus;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String abreviatura;
	private Integer status;

	@JsonIgnore
	@OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Fornecedor fornecedor;
	
	@JsonIgnore
	@OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@JsonIgnore
	@OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Transportadora transportadora;

	public Empresa() {
		super();
	}

	public Empresa(Long id, String nome, String abreviatura, EntidadeStatus status) {
		super();
		this.id = id;
		this.nome = nome;
		this.abreviatura = abreviatura;
		this.setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
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
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

}
