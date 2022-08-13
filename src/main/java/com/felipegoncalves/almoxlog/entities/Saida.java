package com.felipegoncalves.almoxlog.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_saida")
public class Saida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String guia;
	private LocalDate data;
	private Integer volumes;
	private Double cubagem;
	private Double peso;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "transportadora_id")
	private Transportadora transportadora;

	@ManyToMany
	@JoinTable(name = "tb_saida_categoria", joinColumns = @JoinColumn(name = "saida_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<CategoriaSaida> categorias = new HashSet<>();
	
	@OneToMany(mappedBy = "id.saida")
	private Set<SaidaItem> itens = new HashSet<>();

	public Saida() {
		super();
	}

	public Saida(Long id, String guia, LocalDate data, Integer volumes, Double cubagem, Double peso, Cliente cliente,
			Transportadora transportadora) {
		super();
		this.id = id;
		this.guia = guia;
		this.data = data;
		this.volumes = volumes;
		this.cubagem = cubagem;
		this.peso = peso;
		this.cliente = cliente;
		this.transportadora = transportadora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getVolumes() {
		return volumes;
	}

	public void setVolumes(Integer volumes) {
		this.volumes = volumes;
	}

	public Double getCubagem() {
		return cubagem;
	}

	public void setCubagem(Double cubagem) {
		this.cubagem = cubagem;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Set<CategoriaSaida> getCategorias() {
		return categorias;
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
	
	public Set<SaidaItem> getItens() {
		return itens;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (SaidaItem x : itens) {
			sum += x.getSubTotal();
		}
		return sum;
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
		Saida other = (Saida) obj;
		return Objects.equals(id, other.id);
	}

}
