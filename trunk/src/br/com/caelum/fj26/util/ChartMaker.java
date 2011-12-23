package br.com.caelum.fj26.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import br.com.caelum.fj26.dao.ContaPagarDao;
import br.com.caelum.fj26.modelo.Fornecedor;

/**
 * Classe responsavel por gerar graficos
 * 
 * @author vagner
 *
 */
public class ChartMaker {
	
	/**
	 * Gera um grafico a partir de um dataset
	 * 
	 * @param ds O dataset com os dados necessarios para gerar o grafico 
	 * @return o grafico JFreeChart gerado 
	 * @throws IOException
	 */
	public static JFreeChart geraChart(DefaultPieDataset ds) throws IOException {
		JFreeChart grafico = ChartFactory.createPieChart("Contas a pagar", ds, true, false, false);
		grafico.getPlot().setForegroundAlpha(0.4f);
		return grafico;
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * Recupera os dados do DAO e gera o Dataset utilizado para gerar o grafico
		 */
		ContaPagarDao cpd = new ContaPagarDao(HibernateUtil.openSession());
		
		List<Object[]> data = cpd.listaFornecedorValor();
		DefaultPieDataset ds = new DefaultPieDataset();
		
		for (Object[] objeto : data) {
			Fornecedor f = (Fornecedor) objeto[0];
			ds.setValue(f.getNome(), (Number) objeto[1]);
		}
		
		JFreeChart grafico = ChartMaker.geraChart(ds);
		ChartUtilities.saveChartAsJPEG(new File("image.jpg"), grafico, 640, 480);
	}
	
}
