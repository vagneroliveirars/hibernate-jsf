package br.com.caelum.fj26;

import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import br.com.caelum.fj26.dao.Dao;
import br.com.caelum.fj26.dao.FornecedorDao;
import br.com.caelum.fj26.modelo.Fornecedor;
import br.com.caelum.fj26.util.HibernateUtil;

/**
 * MBean que gerencia a entidade {@link Fornecedor}
 * 
 * @author vagner
 * 
 */
public class FornecedorHandler {

	private Fornecedor fornecedor = new Fornecedor();

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * Retorna uma lista de fornecedores
	 * 
	 * @return uma lista de {@link Fornecedor}
	 */
	public List<Fornecedor> getFornecedores() {
		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);
		return dao.list();
	}

	/**
	 * Salva o Fornecedor
	 */
	public void salva() {
		Session session = HibernateUtil.currentSession();

		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);
		dao.merge(this.fornecedor);

		this.fornecedor = new Fornecedor();
	}

	/**
	 * Escolhe um fornecedor para visualizacao
	 * 
	 * @param event
	 */
	public void escolheFornecedor(ActionEvent event) {
		// pega o id do fornecedor
		UIParameter val = (UIParameter) event.getComponent().findComponent("editId");
		Long id = Long.valueOf(val.getValue().toString());

		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);

		this.fornecedor = dao.load(id);
	}

	/**
	 * Devolve sugestoes de nomes de fornecedores, de acordo com o que
	 * comecou a ser digitado
	 * 
	 * @param busca
	 * @return uma lista de Strings que serao utilizadas para a criacao do
	 *         combobox de sugestao
	 */
	public List<String> suggest(String busca) {
		Session session = HibernateUtil.currentSession();
		FornecedorDao dao = new FornecedorDao(session);
		return dao.buscaPeloComecoDoNome(busca);
	}

}
