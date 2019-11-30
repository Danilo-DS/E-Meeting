package Dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class AgendaReuniao {
	private String dtAgentamento;
	private String dtReuniao;
	private String Assunto;
	private String Setor;
	private String Sala;
	private String AP;
	private String Status;
		
	public AgendaReuniao(String dtAgendaR, String DtReuniao, String assunto, String setor, String sala, String aP, String status) {
		dtAgentamento = dtAgendaR;
		dtReuniao = DtReuniao;
		Assunto = assunto;
		Setor = setor;
		Sala = sala;
		AP = aP;
		Status = status;
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
	public String getSala() {
		return Sala;
	}
	public void setSala(String sala) {
		Sala = sala;
	}
	public String getAP() {
		return AP;
	}
	public void setAP(String aP) {
		AP = aP;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	public void gravarDadosR() {	
		
		try {
			String NmR = dtReuniao;
			File caminho = null;
			File diretorio = new File("./Dados/C Reunioes/"+ NmR +".txt");
			File diretorio2 = new File("./Dados/C Reunioes/Privates/"+ NmR +".txt");
			
			if (Status.equals("P�blica")) {
				caminho = diretorio;
			}
			else {
				caminho = diretorio2;
			}
			
			if (diretorio.exists()) {
				
				FileWriter Existe = new FileWriter(caminho,true);
				PrintWriter armazenar = new PrintWriter(Existe);
				armazenar.println("Data de Agendamento: " + dtAgentamento);
				armazenar.println("Data de Reunião: " + dtReuniao);
				armazenar.println("Assunto: " + Assunto);
				armazenar.println("Setor: " + Setor);
				armazenar.println("Sala: " + Sala);
				armazenar.println("Atas / Pautas:");
				armazenar.println(""+AP);
				armazenar.flush();
				armazenar.close();
			
			}
			else {
				
				FileWriter NExiste = new FileWriter(diretorio);
				PrintWriter armazenar2 = new PrintWriter(NExiste);
				armazenar2.println();
				armazenar2.println("	Data de Agendamento: " + dtAgentamento);
				armazenar2.println("	Data de Reunião: " + dtReuniao);
				armazenar2.println("	Assunto: " + Assunto);
				armazenar2.println("	Setor: " + Setor);
				armazenar2.println("	Sala: " + Sala);
				armazenar2.println("	Atas / Pautas:");
				armazenar2.println("	"+ AP);
				armazenar2.println();
				armazenar2.println("-----------------------------------------------------------------------------");
				armazenar2.println();
				armazenar2.flush();
				armazenar2.close();
			}
			JOptionPane.showMessageDialog(null, "Reunião Agendada" , "Sucesso" , JOptionPane.INFORMATION_MESSAGE);
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error: diretorio não localizado" , "Error" , JOptionPane.ERROR_MESSAGE);
		}
	}

}
