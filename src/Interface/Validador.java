package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Dados.CadastroC;
import Dados.CadastroGR;
import Dados.CadastroU;

public class Validador{
	
	private String Login;
	private char[] Password;
	
	public Validador(String login, char[] password) {
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

	public char[] getPassword() {
		return Password;
	}

	public void setPassword(char[] password) {
		Password = password;
	}
	
	public String ConvPass() {
		String senha = "";
		for (int i = 0; i < Password.length; i++) {
			senha+=Password[i];
			
		}
		return senha;
	}
	
	public void VLogin() {
		
		int cont = 0;
		int tipo = 0;
		String lerP = null;
		String lerT = null;
		
		String L = Login;
		String P = "Password: " + ConvPass();
		
		try {
			File caminho = new File("./Dados/C Users/" + L +".txt");
			BufferedReader senha = new BufferedReader(new FileReader(caminho));
			BufferedReader tipoUser = new BufferedReader(new FileReader(caminho));
			lerP = senha.readLine();
			lerT = tipoUser.readLine();
			
			if (caminho.exists()) {
				while (lerP != null && cont != 5 ) {
					lerP = senha.readLine();
					cont ++;
				}
				
				lerT = tipoUser.readLine();
				while (lerT != null && tipo != 2) {
					lerT = tipoUser.readLine();
					tipo ++;
				}
				senha.close();
				tipoUser.close();
			}
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido", "Ops!", JOptionPane.ERROR_MESSAGE);
			
		}
		if (cont == 5) { 
			if (P.equals(lerP)) {
				if (lerT.equals("Tipo: Usuário")){
										
					JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso");
					//WinLogin w = new WinLogin();
					//w.dispose();
					Home h = new Home();
					h.CadastroU.setEnabled(false);
					h.CadastroS.setEnabled(false);
					h.CadastroP.setEnabled(false);
					h.Run();
				}
				else if (lerT.equals("Tipo: Gestor de Recursos")) {
					//WinLogin w = new WinLogin();
					//w.dispose();
					
					JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso");
					Home h = new Home();
					h.CadastroU.setEnabled(false);
					h.CadastroR.setEnabled(false);
					h.PesquisarR.setEnabled(false);
					h.CadastroP.setEnabled(false);
					h.Run();
				}
				else {
					//WinLogin w = new WinLogin();
					//w.dispose();
					
					JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso");
					Home h = new Home();
					h.Run();
				}
			}
			else {
				ChamaLogin();
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido", "Ops!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			return;
		}
	}
	
	public void ChamaLogin() {
		WinLogin w = new WinLogin();
		w.tLogin.setText(Login);
		w.Run();
	}
	
	public void CriarPerfil() {
		String l = Login;
		int cont = 0;
		
		try {
			String leitura = null;
			
			File perfil = new File("./Dados/C Users/Perfil/"+l+".txt");
			File usuario = new File("./Dados/C Users/"+l+".txt");
			
			
			
			BufferedReader ler = new BufferedReader(new FileReader(usuario));
			leitura = ler.readLine();
			
			if (perfil.exists()) {
				ler.close();
			}
			else {
				if(usuario.exists()) {
					PrintWriter armazenar = new PrintWriter(new FileWriter(perfil));
					while(leitura != null && cont < 4) {
						System.out.println(leitura);
						armazenar.println(leitura);;
						leitura = ler.readLine();
						cont++;
					}
					armazenar.flush();
					armazenar.close();
				}
				
				ler.close();
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//Problemas Verificar
	public void ValidarL(String tipo) {
		
		String l = Login;
		
		File f = new File("./Dados/C Users/"+l+".txt");
		
		if (f.exists()) {
			JOptionPane.showMessageDialog(null, "Login já Existente", "Ops!", JOptionPane.WARNING_MESSAGE);
		}
		else {
			if (tipo.equals("Usuário")) {
				CadastroU c = new CadastroU();
				c.gravarDadosU();
			}
			else if (tipo.equals("Coordenador")) {
				CadastroC cc = new CadastroC();
				cc.gravarDadosC();
			}
			else {
				CadastroGR gr = new CadastroGR();
				gr.gravarDadosGR();
			}
			
		}
	}
}
