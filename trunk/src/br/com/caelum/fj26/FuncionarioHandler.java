package br.com.caelum.fj26;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.com.caelum.fj26.modelo.Funcionario;

/**
 * MBean que gerencia a entidade {@link Funcionario}
 * 
 * @author vagner
 *
 */
public class FuncionarioHandler {

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private ListDataModel<Funcionario> dataModel = new ListDataModel<Funcionario>();
	private long count = 0;	// incrementa os ids

	/**
	 * Retorna um funcionario
	 * 
	 * @return um objeto {@link Funcionario}
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Retorna uma lista de funcionarios
	 * 
	 * @return um ListDataModel de {@link Funcionario}
	 */
	public ListDataModel<Funcionario> getFuncionarios() {
		this.dataModel.setWrappedData(funcionarios);
		return dataModel;
	}

	public long getCount() {
		return count;
	}

	/**
	 * Salva o Funcionario
	 */
	public void salva() {
		System.out.println("Adicionando: " + funcionario.getNome());
		if (funcionario.getId() == null) {
			this.funcionario.setId(++count);
			this.funcionarios.add(funcionario);			
		}
		this.funcionario = new Funcionario();
	}
	
	/**
	 * Pega o Funcionario selecionado atraves do id passado como parametro
	 * 
	 * @param event
	 */
	public void escolheFuncionario(ActionEvent event) {
		System.out.println("Escolhe um funcionario para visualizacao");
		UIParameter val = (UIParameter) event.getComponent().findComponent("editId");
		Long id = Long.valueOf(val.getValue().toString());
		for (Funcionario f : this.funcionarios) {
			if (f.getId().equals(id)) {
				System.out.println("Achei " + f);
				this.funcionario = f;
				break;
			}
		}
	}
	
	/**
	 * Pega o Funcionario selecionado atraves da classe FacesContext
	 */
	public void escolheFuncionario() {
		System.out.println("Escolhe um funcionario para visualizacao");		
		FacesContext fc = FacesContext.getCurrentInstance();
		Funcionario f = (Funcionario) fc.getExternalContext().getRequestMap().get("f");
		this.funcionario = f;
	}
	
	/**
	 * Pega o funcionario selecionado atraves da classe ListDataModel
	 */
	public void selecionaFuncionario() {
		System.out.println("Seleciona um funcionario para visualizacao");
		Funcionario f = (Funcionario) dataModel.getRowData();
		this.funcionario = f;
	}
	
	/**
	 * Valida o email informado no formulario
	 * 
	 * @param context
	 * @param validar
	 * @param valor
	 */
	public void validaEmail(FacesContext context, UIComponent validar, Object valor) {
		String email = (String) valor;
		if (!email.contains("@")) {
			((UIInput) validar).setValid(false);
			FacesMessage message = new FacesMessage("Email invalido");
			context.addMessage(validar.getClientId(context), message);
		}
	}
	
}
