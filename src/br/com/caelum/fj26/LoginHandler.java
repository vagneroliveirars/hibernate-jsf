package br.com.caelum.fj26;

/**
 * MBean que gerencia o login do usuario
 * 
 * @author vagner
 *
 */
public class LoginHandler {

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		System.out.println("Mudando login para: " + login);
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Valida o login e a senha do usuario
	 * 
	 * @return "success" se login com sucesso ou "failure" se login falhou
	 */
	public String logar() {
		// codigo de teste, daos serao utilizados depois
		if (login.equals("caelum") && senha.equals("123")) {
			System.out.println("login com sucesso");
			return "success";
		} else {
			System.out.println("login falhou");
			return "failure";
		}
	}

}
