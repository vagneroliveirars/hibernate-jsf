package br.com.caelum.fj26.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import br.com.caelum.fj26.modelo.ContaPagar;

/**
 * Classe DAO da entidade {@link ContaPagar}
 * 
 * @author vagner
 *
 */
public class ContaPagarDao extends Dao<ContaPagar> {

	public ContaPagarDao(Session session) {
		super(session, ContaPagar.class);
	}
	
	/**
	 * Retorna o quanto esta sendo gasto por fornecedor
	 * 
	 * @param qtd
	 * @return lista de array de objetos
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> listaFornecedorValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.groupProperty("fornecedor"));
		pl.add(Projections.sum("valor"), "soma");
		c.setProjection(pl);
		c.addOrder(Order.desc("soma"));
		return c.list();
	}

}
