package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class CadastroC extends CadastroU {
	private String setor;

	public CadastroC(String nome, String dtContrato, String telefone, String login, String password, String setor) {
		super(nome, dtContrato, telefone, login, password);
		this.setor = setor;
	}

	public CadastroC() {}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String Setor() {
		return "Setor " + setor;
	}
	
	public void gravarDadosC() {
		try {						
			String NmArq = "Coordenador" + getLogin();
			
			FileWriter caminho = new FileWriter("/home/ds/Documents/C Users/"+NmArq+".txt");
			PrintWriter armazenar = new PrintWriter(caminho);
			
			armazenar.println("Password: " + getNome());
			armazenar.println("Data de Contratação: " + getDtContrato());
			armazenar.println("Telefone: " + getTelefone());
			armazenar.println("Setor: " + this.setor);
			armazenar.println("Login: " + getLogin());
			armazenar.println("Password: " + getPassword());
			
			armazenar.flush();
			armazenar.close();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Sucesso", JOptionPane.OK_OPTION);
			
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
