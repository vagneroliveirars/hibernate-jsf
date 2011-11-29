package br.com.caelum.fj26.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe que representa uma instancia da entidade ContaPagar
 * 
 * @author vagner
 *
 */
public class ContaPagar {

	private String descricao;
	private Double valor;
	private Calendar data = new GregorianCalendar();
	private Fornecedor fornecedor;
	private boolean pago;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

}
