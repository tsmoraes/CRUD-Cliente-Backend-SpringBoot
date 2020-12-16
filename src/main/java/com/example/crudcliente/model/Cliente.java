package com.example.crudcliente.model;

/**
 * @author Thiago da Silva Moraes
 */

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;

	private long cpf;
	
	private int cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
	private String complemento;
	
	@Column(name = "telefone_obrigatorio")
	private long telefone;
	
	@Column(name = "tipo_telefone")
	private String tipoTel;
	
	@Column(name = "add_residenciais")
	@ElementCollection
	private List<Long> telResidencial;
	
	@Column(name = "add_comerciais")
	@ElementCollection
	private List<Long> telComercial;
	
	@Column(name = "add_celulares")
	@ElementCollection
	private List<Long> telCelular;

	private String email;
	
	@Column(name = "add_emails")
	@ElementCollection
	private List<String> emails;

	public Cliente() {
		super();
	}

	public Cliente(String nome, long cpf, int cep, String logradouro, String bairro, String cidade, String uf,
			String complemento, long telefone, String tipoTel, List<Long> telResidencial, List<Long> telComercial,
			List<Long> telCelular, String email, List<String> emails) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
		this.telefone = telefone;
		this.tipoTel = tipoTel;
		this.telResidencial = telResidencial;
		this.telComercial = telComercial;
		this.telCelular = telCelular;
		this.email = email;
		this.emails = emails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getTipoTel() {
		return tipoTel;
	}

	public void setTipoTel(String tipoTel) {
		this.tipoTel = tipoTel;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(List<Long> telResidencial) {
		this.telResidencial = telResidencial;
	}

	public List<Long> getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(List<Long> telComercial) {
		this.telComercial = telComercial;
	}

	public List<Long> getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(List<Long> telCelular) {
		this.telCelular = telCelular;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
		
}
