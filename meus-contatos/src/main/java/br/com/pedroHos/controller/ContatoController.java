package br.com.pedroHos.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.status;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.pedroHos.model.entities.contato.Contato;
import br.com.pedroHos.model.entities.contato.Telefone;
import br.com.pedroHos.model.entities.contato.TipoContato;
import br.com.pedroHos.model.repositories.contato.Contatos;

@Controller
@Path(value = "/contato")
public class ContatoController {
	
	private Result result;
	private Contatos contatos;
	
	/**
	 * CDI eyes only
	 * @deprecated
	 */
	public ContatoController(){}
	
	@Inject
	public ContatoController( Result result, Contatos contatos ){
		this.result = result;
		this.contatos = contatos;
	}
	
	@Get
	@Path(value = "/tipo")
	public void tipos() {
		result.use(json())
			  .withoutRoot()
			  .from(TipoContato.values())
			  .serialize();
	}
	
	@Post
	@Path(value = {"/", ""})
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public void novo( Contato contato ) {
		setPhone(contato);
		contatos.novo(contato);
		result.use(status()).ok();
	}
	
	@Get
	@Path(value = {"/", ""})
	public void todos() {
		result.use(json())
			  .withoutRoot()
			  .from(contatos.todosAtivos())
			  .include("telefones")
			  .serialize();
	}
	
	@Put
	@Path(value = "/contato/{id}")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public void editar(Contato contato, Long id) {
		contato.setId(id);
		setPhone(contato);
		contatos.atualizar(contato);
		result.use(status()).ok();
	}

	protected void setPhone(Contato contato) {
		if(contato.getTelefones() != null) {
			for (Telefone telefone : contato.getTelefones()) {
				telefone.setContato(contato);
			}
		}
	}
	
	@Delete
	@Path(value = "/contato/{id}")
	public void remover(Long id) {
		contatos.desativarComId(id);
		result.use(status()).ok();
	}

}
