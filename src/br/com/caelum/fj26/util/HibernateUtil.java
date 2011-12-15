package br.com.caelum.fj26.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Classe responsavel por adquirir Sessions
 * 
 * @author vagner
 *
 */
public class HibernateUtil {

	private static final Logger logger = Logger.getLogger(HibernateUtil.class);
	
	private static final SessionFactory sessionFactory;
	private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		logger.info("Abrindo uma nova sessao");
		if (sessions.get() != null) {
			logger.error("Ja havia uma sessao para esta thread!!");
			// grave, alguem nao fechou uma sessao ja aberta
		}
		sessions.set(sessionFactory.openSession());
		return sessions.get();
	}
	
	public static void closeCurrentSession() {
		logger.info("Fechando a sessao corrente");
		sessions.get().close();
		sessions.set(null);
	}
	
	public static Session currentSession() {
		logger.info("Retornando a sessao corrente");
		return sessions.get();
	}
	
}
