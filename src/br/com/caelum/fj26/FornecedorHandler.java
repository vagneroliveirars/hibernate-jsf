package br.com.caelum.fj26;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.fj26.modelo.Fornecedor;

public class FornecedorHandler {

	private Fornecedor fornecedor = new Fornecedor();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private long count = 0;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		System.out.println("Lendo fornecedores #" + fornecedores.size());
		return fornecedores;
	}

	public long getCount() {
		return count;
	}
	
	public void salva() {
		System.out.println("Adicionando: " + fornecedor.getNome());
		this.fornecedor.setId(++count);
		this.fornecedores.add(fornecedor);
		this.fornecedor = new Fornecedor();
	}

}
