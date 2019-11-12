package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Validador{
	
	private String Login;
	private String Password;
	
	public Validador(String login, String password) {
		Login = login;
		Password = password;
	}
	
	public Validador() {}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	@SuppressWarnings("resource")
	public void VLogin() {
		
		int cont = 0;
		int tipo = 0;
		String lerP = null;
		String lerT = null;
		
		String L = Login;
		String P = "Password: " + Password;
		
		try {
			File caminho = new File("/home/ds/Documents/C Users/" + L +".txt");
			BufferedReader senha = new BufferedReader(new FileReader(caminho));
			BufferedReader tipoUser = new BufferedReader(new FileReader(caminho));
			lerP = senha.readLine();
			lerT = tipoUser.readLine();
			
			if (caminho.exists()) {
				while (lerP != null && cont != 4 ) {
					lerP = senha.readLine();
					cont ++;
				}
				
				lerT = tipoUser.readLine();
				while (lerT != null && tipo != 4) {
					lerT = tipoUser.readLine();
					tipo ++;
				}
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
			}
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if (cont == 4) { 
			if (P.equals(lerP)) {
				
				JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso");
				Home h = new Home();
				h.Run();
			}
			else {
				System.out.println(lerP);
				System.out.println(Password);
				System.out.println(P);
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido");
			}
		}
		else {
			return;
		}
	}
}
