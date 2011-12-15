package br.com.caelum.fj26.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Classe DAO generica que serve para qualquer entidade e que fornece as
 * operacoes basicas
 * 
 * @author vagner
 * 
 * @param <T>
 */
public class Dao<T> {

	private static Logger logger = Logger.getLogger(Dao.class);

	private Class persistentClass;

	private Session session;

	public Dao(Session session, Class persistentClass) {
		this.session = session;
		this.persistentClass = persistentClass;
	}

	protected Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	public T load(Long id) {
		logger.info("Lendo " + persistentClass + " com id " + id);
		return (T) session.load(persistentClass, id);
	}

	public void save(T t) {
		logger.info("Salvando " + t);
		session.save(t);
	}

	public void delete(T t) {
		logger.info("Deletando " + t);
		session.delete(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return session.createCriteria(persistentClass).list();
	}

	public void saveOrUpdate(T t) {
		logger.info("Salvando ou atualizando " + t);
		session.saveOrUpdate(t);
	}
	
	public void merge(T t) {
		logger.info("Merge " + t);
		session.merge(t);
	}

}
