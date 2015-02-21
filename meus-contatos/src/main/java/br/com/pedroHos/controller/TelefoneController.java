package br.com.pedroHos.controller;

import static br.com.caelum.vraptor.view.Results.json;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.pedroHos.model.entities.contato.TipoTelefone;

@Controller
public class TelefoneController {
	
	private Result result;

	/**
	 * CDI eyes only
	 * @deprecated
	 */
	public TelefoneController() {}

	@Inject
	public TelefoneController(Result result) {
		this.result = result;
	}
	
	@Get
	@Path(value = "/telefone/tipo")
	public void tipos() {
		result.use(json())
			  .withoutRoot()
			  .from(TipoTelefone.values())
			  .serialize();
	}

}
