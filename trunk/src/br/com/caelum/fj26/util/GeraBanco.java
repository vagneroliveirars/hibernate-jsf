package br.com.caelum.fj26.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Classe que gera as tabelas no banco de dados
 * 
 * @author vagner
 * 
 */
public class GeraBanco {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		SchemaExport se = new SchemaExport(configuration);
		se.create(true, true);
	}
}
