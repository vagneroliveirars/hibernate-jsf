package br.com.caelum.fj26.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe que representa uma instancia da entidade Fornecedor
 * 
 * @author vagner
 *
 */
@Entity
public class Fornecedor {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome, descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
