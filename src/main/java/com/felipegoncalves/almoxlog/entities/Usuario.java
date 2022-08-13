package com.felipegoncalves.almoxlog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.felipegoncalves.almoxlog.entities.enums.EntidadeStatus;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;

	@OneToOne
	@MapsId
	private Pessoa pessoa;

	private Integer status;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String login, String senha, Pessoa pessoa, EntidadeStatus status) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
		this.setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
