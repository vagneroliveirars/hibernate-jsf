package br.com.caelum.fj26;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
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
	
	/**
	 * Faz o lookup do bean FornecedorHandler
	 * 
	 * @return um objeto {@link FornecedorHandler}
	 */
	private FornecedorHandler pegaFornecedorHandler() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FornecedorHandler handler = (FornecedorHandler) facesContext
				.getApplication().getVariableResolver().resolveVariable(facesContext, "FornecedorHandler");
		return handler;
	}
	
	/**
	 * Gera um combobox de Fornecedores  
	 * 
	 * @return uma lista de SelectItem
	 */
	public List<SelectItem> getFornecedoresParaComboBox() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		
		FornecedorHandler handler = pegaFornecedorHandler();
		for (Fornecedor f : handler.getFornecedores()) {
			lista.add(new SelectItem(f.getId().toString(), f.getNome()));
		}
		return lista;
	}

}
