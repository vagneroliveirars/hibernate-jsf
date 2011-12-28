package br.com.caelum.fj26.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import br.com.caelum.fj26.dao.ContaPagarDao;
import br.com.caelum.fj26.modelo.Fornecedor;

/**
 * Servlet que gera um grafico de contas por fornecedor 
 * 
 * @author vagner
 *
 */
public class ChartServlet extends HttpServlet {

	private static final long serialVersionUID = -4282714796481213088L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		 * Recupera os dados do DAO e gera o dataset utilizado para gerar o grafico
		 */
		ContaPagarDao cpd = new ContaPagarDao(HibernateUtil.currentSession());
		
		List<Object[]> data = cpd.listaFornecedorValor();
		DefaultPieDataset ds = new DefaultPieDataset();
		
		for (Object[] objeto : data) {
			Fornecedor f = (Fornecedor) objeto[0];
			ds.setValue(f.getNome(), (Number) objeto[1]);
		}
		
		// gera o grafico
		JFreeChart grafico = ChartMaker.geraChart(ds);
		
		// envia o stream de bytes para o response da servlet
		resp.setContentType("image/jpeg");
		ChartUtilities.writeChartAsJPEG(resp.getOutputStream(), grafico, 300, 200);
	}

}
