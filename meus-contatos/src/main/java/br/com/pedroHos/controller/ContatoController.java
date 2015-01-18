package br.com.pedroHos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.pedroHos.model.entities.contato.Contato;
import br.com.pedroHos.model.entities.contato.TipoContato;
import br.com.pedroHos.model.entities.contato.TipoTelefone;
import br.com.pedroHos.model.repositories.contato.Contatos;

@Controller
public class ContatoController {
	
	private Result result;
	private Contatos contatos;
	
	@Deprecated
	public ContatoController(){}
	
	@Inject
	public ContatoController( Result result, Contatos contatos ){
		this.result = result;
		this.contatos = contatos;
	}
	
	public void formulario() {
		result.include( TipoContato.values() )
			  .include( TipoTelefone.values());
	}
	
	@Post
	@Path("/contato")
	public void novo( Contato contato ) {
		contatos.novo(contato);
		result.redirectTo(this).formulario();
	}

}
