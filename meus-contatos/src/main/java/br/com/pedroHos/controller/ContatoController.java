package br.com.pedroHos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
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
	
	public void formulario() {}

}
