package br.com.pedroHos.model.repositories.contato;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.pedroHos.model.entities.contato.Contato;
import br.com.pedroHos.model.repositories.Repository;

@Stateless
public class Contatos extends Repository<Contato> {

	public List<Contato> todosAtivos() {

		String jpql = "select c from Contato c where c.ativo = :ativo";

		TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
		query.setParameter("ativo", true);

		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void desativarComId(Long id) {
		desativarOuAtivar(id, false);
	}

	public void ativarComId(Long id) {
		desativarOuAtivar(id, true);
	}

	protected void desativarOuAtivar(Long id, boolean ativar) {
		String jpql = "update Contato c set c.ativo = :ativo where c.id = :id";
		Query query = em.createQuery(jpql);
		query.setParameter("ativo", ativar);
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
