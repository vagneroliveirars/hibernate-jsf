package br.com.caelum.fj26;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import br.com.caelum.fj26.modelo.Funcionario;

public class FuncionarioHandler {

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private ListDataModel<Funcionario> dataModel = new ListDataModel<Funcionario>();
	private long count = 0;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public ListDataModel<Funcionario> getFuncionarios() {
		this.dataModel.setWrappedData(funcionarios);
		return dataModel;
	}

	public long getCount() {
		return count;
	}

	/*
	public void salva() {
		System.out.println("Adicionando: " + funcionario.getNome());
		if (funcionario.getId() == null) {
			this.funcionario.setId(++count);
			this.funcionarios.add(funcionario);
		}
		this.funcionario = new Funcionario();
	}
	*/
	
	public void salva() {
		System.out.println("Adicionando: " + funcionario.getNome());
		if (funcionario.getId() == null) {
			this.funcionario.setId(++count);
			this.funcionarios.add(funcionario);			
		}
		this.funcionario = new Funcionario();
	}
	
	/*
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
	*/
	
	/**
	 * Pega o Funcionario selecionado atraves da classe FacesContext
	 */
	public void escolheFuncionario() {
		System.out.println("Escolhe um funcionario para visualizacao");		
		FacesContext fc = FacesContext.getCurrentInstance();
		Funcionario f = (Funcionario) fc.getExternalContext().getRequestMap().get("f");
		this.funcionario = f;
	}
	
	public void selecionaFuncionario() {
		System.out.println("Seleciona um funcionario para visualizacao");
		Funcionario f = (Funcionario) dataModel.getRowData();
		this.funcionario = f;
	}
	
}
