package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class AgendaReuniao {
	private String dtAgentamento;
	private String dtReuniao;
	private String Assunto;
	private String Setor;
	private String AP;
	public AgendaReuniao(String dtAgendaR, String DtReuniao, String assunto, String setor, String aP) {
		dtAgentamento = dtAgendaR;
		dtReuniao = DtReuniao;
		Assunto = assunto;
		Setor = setor;
		AP = aP;
	}
	
	public AgendaReuniao() {}

	public String getDtAgentamento() {
		return dtAgentamento;
	}
	public void setDtAgentamento(String dtAgenda) {
		this.dtAgentamento = dtAgenda;
	}
	public String getDtReuniao() {
		return dtReuniao;
	}
	public void setDtReuniao(String DtReuniao) {
		this.dtReuniao = DtReuniao;
	}
	public String getAssunto() {
		return Assunto;
	}
	public void setAssunto(String assunto) {
		Assunto = assunto;
	}
	public String getSetor() {
		return Setor;
	}
	public void setSetor(String setor) {
		Setor = setor;
	}
	public String getAP() {
		return AP;
	}
	public void setAP(String aP) {
		AP = aP;
	}
	
	public void gravarDadosR() {
				
		try {
			String NmR = Assunto + " " + dtReuniao;
			
			FileWriter caminho = new FileWriter("/home/ds/Documents/C Reuniões/"+ NmR +".txt");
			PrintWriter armazenar = new PrintWriter(caminho);
			armazenar.println("Data de Agendamento: " + dtAgentamento);
			armazenar.println("Data de Reunião: " + dtReuniao);
			armazenar.println("Assunto: " + Assunto);
			armazenar.println("Setor: " + Setor);
			armazenar.println("Atas / Pautas:");
			armazenar.println(AP);
			armazenar.flush();
			armazenar.close();
			
			JOptionPane.showMessageDialog(null, "Reunião Agendada" , "Sucesso" , JOptionPane.INFORMATION_MESSAGE);
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado" , "Error" , JOptionPane.ERROR_MESSAGE);
		}
		
	}
		
}
