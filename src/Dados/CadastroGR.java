package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;

//import javax.swing.JOptionPane;

public class CadastroGR extends CadastroU{
	
	private String Turno;

	public CadastroGR(String nome, String dtContrato, String TUsuario, String telefone, String login, String password,
			String turno) {
		super(nome, dtContrato, TUsuario, telefone, login, password);
		Turno = turno;
	}
	
	public CadastroGR() {}

	public String getTurno() {
		return Turno;
	}

	public void setTurno(String turno) {
		Turno = turno;
	}
	
	public void gravarDadosGR() {
				
		try {
			String L = getLogin();
			
			FileWriter caminho = new FileWriter("/home/ds/Documents/C Users" + L + ".txt");
			PrintWriter armazenar = new PrintWriter(caminho);
			
			armazenar.println("Nome: " + getNome());
			armazenar.println("Data de Contratação : " + getDtContrato());
			armazenar.println("Telefone: " + getTelefone());
			armazenar.println("Login: " + getLogin());
			armazenar.println("Password: " + getPassword());
			armazenar.println("Tipo: " + getTipoUsuario());
			armazenar.println("Turno: " + Turno);
			armazenar.flush();//perda de dados
			armazenar.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
