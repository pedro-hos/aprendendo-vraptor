package br.com.pedroHos.util;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.pedroHos.model.entities.contato.Contato;
import br.com.pedroHos.model.entities.contato.Telefone;
import br.com.pedroHos.model.entities.contato.TipoContato;
import br.com.pedroHos.model.entities.contato.TipoTelefone;
import br.com.pedroHos.model.repositories.contato.Contatos;

@Startup
@Singleton
public class InsereDados {
	
	@Inject
	private Contatos contatos;
	
	@PostConstruct
	public void criaContato() {
		
		contatos.todos();
		
		Contato contato = new Contato();
		contato.setEmail("pedrosjc@outlook.com");
		contato.setNome("Pedro");
		contato.setTipoContato(TipoContato.AMIGO);
		
		Telefone t1 = new Telefone();
		t1.setContato(contato);
		t1.setDdd("12");
		t1.setTelefone("123456");
		t1.setTipoTelefone(TipoTelefone.CELULAR);
		
		Telefone t2 = new Telefone();
		t2.setContato(contato);
		t2.setDdd("12");
		t2.setTelefone("123456789");
		t2.setTipoTelefone(TipoTelefone.CELULAR);
		
		contato.setTelefones(Arrays.asList(t1, t2));
		
		contatos.novo(contato);
		
	}

}
