package br.com.caelum.fj26.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.fj26.modelo.Fornecedor;

/**
 * Classe DAO da entidade {@link Fornecedor}
 * 
 * @author vagner
 * 
 */
public class FornecedorDao extends Dao<Fornecedor> {

	public FornecedorDao(Session session) {
		super(session, Fornecedor.class);
	}

	/**
	 * Devolve sugestoes baseadas nos nomes de fornecedores, de acordo com o que
	 * comecou a ser digitado
	 * 
	 * @param busca
	 * @return uma lista de Strings
	 */
	@SuppressWarnings("unchecked")
	public List<String> buscaPeloComecoDoNome(String busca) {
		Criteria c = getSession().createCriteria(Fornecedor.class);
		c.add(Restrictions.ilike("nome", busca + "%"));
		c.addOrder(Order.asc("nome"));
		c.setProjection(Projections.property("nome"));
		return c.list();
	}

}
