package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class CadastroU {
	
	private String Nome;
	private String dtContrato;
	//private String Cargo;
	private String Telefone;
	private String Login;
	private String Password;
	public CadastroU(String nome, String dtContrato, String telefone, String login, String password) {
		Nome = nome;
		this.dtContrato = dtContrato;
		Telefone = telefone;
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
	//@Override
	//public String toString() {
	//	return "Nome " + Nome + "%n" + "Data de Contratação " + dtContrato +
	//			"%n" + /*"Cargo " + Cargo + "%n" +*/ "Telefone " + Telefone +
	//			"%n" + "Login " + Login + "%nPassword" + Password + "%n";
	//}
	
	public void gravarDadosU() {
		try {						
			String NmArq = "Usuario: " + Login;
			
			FileWriter caminho = new FileWriter("/home/ds/Documents/C Users/"+NmArq+".txt");
			PrintWriter armazenar = new PrintWriter(caminho);
			
			armazenar.println("Nome: " + this.Nome);
			armazenar.println("Data de Contratação: " + this.dtContrato);
			armazenar.println("Telefone: " + this.Telefone);
			armazenar.println("Login: " + this.Login);
			armazenar.println("Password: " + this.Password);
			armazenar.flush(); //perda de dados
			armazenar.close();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Sucesso", JOptionPane.OK_OPTION);
			
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	

}
