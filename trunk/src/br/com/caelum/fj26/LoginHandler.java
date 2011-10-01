package br.com.caelum.fj26;

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
	
	public void logar() {
		// codigo de teste, daos serao utilizados depois
		if (login.equals("caelum") && senha.equals("123")) {
			System.out.println("login com sucesso");
		} else {
			System.out.println("login falhou");
		}
	}

}
