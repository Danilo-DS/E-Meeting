package Dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class CadastroU {
	
	private String Nome;
	private String dtContrato;
	private String Telefone;
	private String TipoUsuario;
	private String Login;
	private char[] Password;
	public CadastroU(String nome, String dtContrato, String telefone,  String TUsuario, String login, char[] password) {
		Nome = nome;
		this.dtContrato = dtContrato;
		Telefone = telefone;
		TipoUsuario = TUsuario;
		Login = login;
		Password = password;
	}
	public CadastroU() {}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDtContrato() {
		return dtContrato;
	}
	public void setDtContrato(String dtContrato) {
		this.dtContrato = dtContrato;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
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
		for(int i = 0; i < Password.length; i++) {
			senha+=Password[i];
		}
		return senha;
	}
	
	
	public void gravarDadosU() {
				
		try {						
			String NmArq = Login;
			
			File caminho = new File("./Dados/C Users/"+NmArq+".txt");
			FileWriter f = new FileWriter(caminho);
			PrintWriter armazenar = new PrintWriter(f);
			
				armazenar.println("Nome: " + this.Nome);
				armazenar.println("Data de Contratação: " + this.dtContrato);
				armazenar.println("Telefone: " + this.Telefone);
				armazenar.println("Tipo: " + TipoUsuario);
				armazenar.println("Login: " + this.Login);
				armazenar.println("Password: " + ConvPass());
				armazenar.flush(); //perda de dados
				armazenar.close();
				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	

}
