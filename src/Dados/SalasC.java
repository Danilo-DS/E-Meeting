package Dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SalasC {
	private String NomeSala;
	private String NumeroSala;
	
	public SalasC(String nomeSala, String numeroSala) {
		NomeSala = nomeSala;
		NumeroSala = numeroSala;
	}
	
	public SalasC() {}
	
	public String getNomeSala() {
		return NomeSala;
	}
	public void setNomeSala(String nomeSala) {
		NomeSala = nomeSala;
	}
	public String getNumeroSala() {
		return NumeroSala;
	}
	public void setNumeroSala(String numeroSala) {
		NumeroSala = numeroSala;
	}
	
	public void gravarSalas() {
		try {
			
			int contS = 0;
			String sala = null;
			String NmSala = NomeSala +" "+ NumeroSala;
			
			File caminho = new File("./Dados/Salas Gerais.txt");
			BufferedReader ler = new BufferedReader(new FileReader(caminho));
			sala = ler.readLine();
			
			while (sala != null) {
				if (sala.equals(NmSala)) {
					contS = contS +1;
				}
				sala = ler.readLine();
			}
			
			if (contS > 0) {
				JOptionPane.showMessageDialog(null, "A sala já existe!", "Aviso", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				SCadastras();
				JOptionPane.showMessageDialog(null, "Sala Cadastrada com Sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
			}
			ler.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error: Erro ao Cadastrar Sala","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void SCadastras() {
		try {
			File SalasGerais = new File("./Dados/Salas Gerais.txt");
			FileWriter f = new FileWriter(SalasGerais, true);
			PrintWriter armazenar = new PrintWriter(f);
			armazenar.println(NomeSala + " " + NumeroSala);
			armazenar.flush();
			armazenar.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error: Erro Inesperado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
