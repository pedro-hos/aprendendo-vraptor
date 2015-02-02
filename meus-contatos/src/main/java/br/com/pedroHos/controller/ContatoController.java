package br.com.pedroHos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.pedroHos.model.entities.contato.Contato;
import br.com.pedroHos.model.entities.contato.Telefone;
import br.com.pedroHos.model.entities.contato.TipoContato;
import br.com.pedroHos.model.entities.contato.TipoTelefone;
import br.com.pedroHos.model.repositories.contato.Contatos;

@Controller
public class ContatoController {
	
	private Result result;
	private Contatos contatos;
	
	/**
	 * CDI eyes only
	 *
	 * @deprecated
	 */
	public ContatoController(){}
	
	@Inject
	public ContatoController( Result result, Contatos contatos ){
		this.result = result;
		this.contatos = contatos;
	}
	
	public void formulario() {
		result.include( TipoContato.values() )
			  .include( TipoTelefone.values())
			  .include("contatoList", contatos.todos());
	}
	
	@Post
	@Path("/contato")
	public void novo( Contato contato ) {
		
		for(Telefone telefone : contato.getTelefones()) {
			telefone.setContato(contato);
		}
		
		contatos.novo(contato);
		result.redirectTo(this).formulario();
	}
	
	@Get
	@Path("/contato")
	public void todos() {
		contatos.todos();
	}
	
	@Delete
	@Path("/contato")
	public void remover(Contato contato) {
		contatos.remover(contato);
		result.redirectTo(this).formulario();
	}

}
