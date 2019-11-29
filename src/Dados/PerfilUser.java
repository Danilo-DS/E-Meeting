package Dados;

public class PerfilUser {
	private String Login;
		
	public PerfilUser(String login) {
		Login = login;
	}
	
	public PerfilUser() { }
	
	
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	
}
