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
		String ler = null;
		
		String L = "Usuario: " + Login;
		String P = "Password: " + Password;
		
		try {
			File caminho = new File("/home/ds/Documents/C Users/" + L +".txt");
			BufferedReader b = new BufferedReader(new FileReader(caminho));
			ler = b.readLine();
			
			if (caminho.exists()) {
				while (ler != null && cont != 4) {
					ler = b.readLine();
					cont ++;
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
			if (P.equals(ler)) {
				
				Home h = new Home();
				h.Run();
			}
			else {
				System.out.println(Password);
				System.out.println(P);
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error não validação");
		}
	}
}
