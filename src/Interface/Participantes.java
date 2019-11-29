package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Dados.Participante;

public class Participantes extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//Jlists
	JList<String> Reunioes = new JList<String>(CarregarR());
	JList<String> Particip = new JList<String>(CarregarP());
	JScrollPane barraReu = new JScrollPane(Reunioes);
	JScrollPane barraPtc = new JScrollPane(Particip);
	
	//Botão
	JButton Adicionar = new JButton("Adicionar Particiapante");
	
	//JTextArea
	JTextArea verR = new JTextArea();
	JScrollPane barra = new JScrollPane(verR);
		
	public Participantes() {
		//Jlists
		barraReu.setBounds(30, 100, 100, 175);
		barraPtc.setBounds(465, 100, 100, 175);
		
		
		//Botão
		Adicionar.setBounds(205, 300, 220, 30);
		
		//JTextArea/Scrollpane
		barra.setBounds(160, 100, 280, 175);
		
		setTitle("Adicionar Participantes");
		setLayout(null);
		setResizable(false);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Jlists
		add(barraReu);
		add(barraPtc);
		Reunioes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Reunioes.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {	
				VisualizarR();
			}
		});
		
		Particip.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Botão
		add(Adicionar);
		Adicionar.addActionListener(this);
		
		//JTextArea
		add(barra);
		
	}
	public String[] CarregarR() {
		File[] arquivos ;
		File f = new File("./Dados/C Reunioes/");
		arquivos = f.listFiles();
		String[] arq = new String[arquivos.length];
		
		for(int i = 0; i < arquivos.length; i++) {
			File lista = arquivos[i];
			if (lista.isFile()) {
				arq[i]= lista.getName().replace(".txt", "");
			}
		}
		return arq;
	}
	
	public String[] CarregarP() {
		File[] arquivos ;
		File f = new File("./Dados/C Users/");
		arquivos = f.listFiles();
		String[] arq = new String[arquivos.length];
		
		for(int i = 0; i < arquivos.length; i++) {
			File lista = arquivos[i];
			if (lista.isFile()) {
				arq[i]= lista.getName().replace(".txt", "");
			}
		}
		return arq;
	}
	
	public void VisualizarR() {
		verR.setText("");
		try {
		String reuniao;
		BufferedReader ler = new BufferedReader(new FileReader("./Dados/C Reunioes/"+ Reunioes.getSelectedValue() + ".txt"));
		
		reuniao = "";
		
		while (reuniao != null) {
			verR.append("	" + reuniao + "\n");
			reuniao = ler.readLine();		
		}
		ler.close();
		
	}
	catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Error: Carregamento Falhou", "Error", JOptionPane.ERROR_MESSAGE);
	}
	}
	public void Run(){ }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Adicionar) {
			Participante p = new Participante();
			p.setNome(Particip.getSelectedValue());
			p.setDataR(Reunioes.getSelectedValue());
			
			p.gravarParticipantes();
		}
	}
}
