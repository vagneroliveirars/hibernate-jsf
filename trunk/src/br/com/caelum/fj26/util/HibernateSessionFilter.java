package br.com.caelum.fj26.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filtro responsavel por interceptar as requisicoes do servidor e abrir uma
 * nova sessao, juntamente com uma transacao. Depois que todo fluxo e executado,
 * comita e fecha a sessao corrente.
 * 
 * @author vagner
 * 
 */
public class HibernateSessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {

		try {
			HibernateUtil.openSession();
			HibernateUtil.currentSession().beginTransaction();
			fc.doFilter(req, res);
			HibernateUtil.currentSession().getTransaction().commit();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			HibernateUtil.closeCurrentSession();
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
