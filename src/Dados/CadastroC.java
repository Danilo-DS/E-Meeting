package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class CadastroC extends CadastroU {
	private String setor;

	public CadastroC(String nome, String dtContrato, String telefone, String TUsuario, String login, char[] password, String setor) {
		super(nome, dtContrato, telefone, TUsuario, login, password);
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
			String NmArq = getLogin();
			
			FileWriter caminho = new FileWriter("./Dados/C Users/"+NmArq+".txt");
			PrintWriter armazenar = new PrintWriter(caminho);
			
			armazenar.println("Nome: " + getNome());
			armazenar.println("Data de Contratação: " + getDtContrato());
			armazenar.println("Telefone: " + getTelefone());
			armazenar.println("Tipo: " + getTipoUsuario());
			armazenar.println("Login: " + getLogin());
			armazenar.println("Password: " + ConvPass());
			armazenar.println("Setor: " + setor);
			armazenar.flush();//perda de dados
			armazenar.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
