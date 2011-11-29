package br.com.caelum.fj26;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.com.caelum.fj26.modelo.ContaPagar;
import br.com.caelum.fj26.modelo.Fornecedor;

/**
 * MBean que gerencia a entidade {@link ContaPagar} 
 * 
 * @author vagner
 *
 */
public class ContaPagarHandler {
	
	private ContaPagar contaPagar = new ContaPagar();
	private List<ContaPagar> contas = new ArrayList<ContaPagar>();
	private HtmlSelectOneMenu fornecedorSelecionado;
	private FornecedorHandler fornecedorHandler;	// injecao de dependencias 
		
	public ContaPagar getContaPagar() {
		return contaPagar;
	}
	
	public List<ContaPagar> getContas() {
		return contas;
	}
	
	public HtmlSelectOneMenu getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(HtmlSelectOneMenu fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	
	public FornecedorHandler getFornecedorHandler() {
		return fornecedorHandler;
	}

	public void setFornecedorHandler(FornecedorHandler fornecedorHandler) {
		this.fornecedorHandler = fornecedorHandler;
	}

	/**
	 * Faz o lookup do bean FornecedorHandler
	 * 
	 * @return um objeto {@link FornecedorHandler}
	 */
	/* Comentado para usar injecao de dependencias ao inves do facesContext
	private FornecedorHandler pegaFornecedorHandler() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FornecedorHandler handler = (FornecedorHandler) facesContext
				.getApplication().getVariableResolver().resolveVariable(facesContext, "FornecedorHandler");
		return handler;
	}
	*/
	
	/**
	 * Gera um combobox de Fornecedores  
	 * 
	 * @return uma lista de SelectItem
	 */
	public List<SelectItem> getFornecedoresParaComboBox() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		
		/* Comentado para usar injecao de dependencias ao inves do facesContext
		FornecedorHandler handler = pegaFornecedorHandler();
		for (Fornecedor f : handler.getFornecedores()) {
			lista.add(new SelectItem(f.getId().toString(), f.getNome()));
		}
		*/
		
		for (Fornecedor f : fornecedorHandler.getFornecedores()) {
			lista.add(new SelectItem(f.getId().toString(), f.getNome()));
		}
		return lista;
	}
	
	/**
	 * Salva a ContaPagar
	 * 
	 * @param event
	 */
	public void salva(ActionEvent event) {
		System.out.println("Gravando a conta: " + contaPagar.getDescricao());
		System.out.println("Pago: " + contaPagar.isPago());
		
		int id = Integer.parseInt(fornecedorSelecionado.getValue().toString());
		Fornecedor f = fornecedorHandler.getFornecedores().get(id - 1);
		contaPagar.setFornecedor(f);
		
		System.out.println("Fornecedor: " + contaPagar.getFornecedor().getNome());
		
		this.contas.add(contaPagar);
		contaPagar = new ContaPagar();
	}

}
