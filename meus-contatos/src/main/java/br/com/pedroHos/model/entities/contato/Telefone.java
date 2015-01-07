package br.com.pedroHos.model.entities.contato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.pedroHos.model.entities.DefaultEntity;

@Entity
public class Telefone extends DefaultEntity {

	private static final long serialVersionUID = 1L;
	
	private String ddd;
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone")
	private TipoTelefone TipoTelefone;
	
	@ManyToOne
	@JoinColumn(name = "contato_fk")
	private Contato contato;
	
	public TipoTelefone getTipoTelefone() {
		return TipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		TipoTelefone = tipoTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	

}
