package br.com.pedroHos.model.entities.contato;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.pedroHos.model.entities.DefaultEntity;

@Entity
public class Contato extends DefaultEntity {

	private static final long serialVersionUID = 1;
	
	private String nome;
	private String email;
	
	@OneToMany(mappedBy = "contato", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Telefone> telefones;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_contato")
	private TipoContato tipoContato;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

}
