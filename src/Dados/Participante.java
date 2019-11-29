package Dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Participante {
	private String Nome;
	private String dataR;
	
	public Participante(String nome, String dataR) {
		Nome = nome;
		this.dataR = dataR;
	}
	
	public Participante() {	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataR() {
		return dataR;
	}
	public void setDataR(String dataR) {
		this.dataR = dataR;
	}
	
	public void gravarParticipantes() {
		try {						
			String NmArq = dataR;
			
			File caminho = new File("./Dados/Participantes/"+NmArq+".txt");
			FileWriter f = new FileWriter(caminho);
			PrintWriter armazenar = new PrintWriter(f);
			
				armazenar.println("Nome: " + this.Nome + " " + dataR);
				armazenar.flush(); //perda de dados
				armazenar.close();
				JOptionPane.showMessageDialog(null, "Participante Adicionado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
