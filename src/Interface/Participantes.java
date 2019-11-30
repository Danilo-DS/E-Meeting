package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Dados.Participante;
import Dados.PerfilUser;

public class Participantes extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//Jlabels
	JLabel LengR = new JLabel("Reuni�es");
	JLabel LengVr = new JLabel("Vizializar Reuni�o");
	JLabel Usuario = new JLabel("Usu�rios");
	
	
	//Jlists
	JList<String> Reunioes = new JList<String>(CarregarR());
	JList<String> Usuarios = new JList<String>(CarregarU());
	JScrollPane barraReu = new JScrollPane(Reunioes);
	JScrollPane barraUser = new JScrollPane(Usuarios);
	
	
	//Botão
	JButton Adicionar = new JButton("Adicionar Particiapante");
	JButton Perfil = new JButton("Ver Perfil");
	
	//JTextArea
	JTextArea verR = new JTextArea();
	JScrollPane barra = new JScrollPane(verR);
	
	JTextArea Partic = new JTextArea();
	JScrollPane barraPtc = new JScrollPane(Partic);
	
	
	public Participantes() {
		//Legandas
		LengR.setBounds(50, 55, 80, 30);
		LengVr.setBounds(240, 55, 150, 30);
		Usuario.setBounds(485, 55, 80, 30);
		
		//Jlists
		barraReu.setBounds(30, 80, 100, 175);
		barraUser.setBounds(455, 80, 100, 175);
				
		//Botão
		Adicionar.setBounds(30, 280, 180, 30);
		Perfil.setBounds(30, 340, 100, 30);
		
		//JTextArea/Scrollpane
		barra.setBounds(160, 80, 260, 175);
		barraPtc.setBounds(290, 280, 270, 155);
		
		
		setTitle("Adicionar Participantes");
		setLayout(null);
		setResizable(false);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Jlists
		add(barraReu);
		add(barraUser);
		Reunioes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Reunioes.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {	
				VisualizarR();
				CarregarPartc();
			}
		});
		add(barraPtc);
		Usuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Jlabels
		add(LengR);
		add(LengVr);
		add(Usuario);
		
		//Botão
		add(Adicionar);
		Adicionar.addActionListener(this);
		
		Perfil.addActionListener(this);
		add(Perfil);
		
		//JTextArea
		add(barra);
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) {
				dispose();
				Home h = new Home();
				h.Run();
			}
		});
		
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
	
	public String[] CarregarU() {
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
	
	public void CarregarPartc() {
		Partic.setText("");
		try {
			String Particip;
			BufferedReader ler = new BufferedReader(new FileReader("./Dados/Participantes/"+ Reunioes.getSelectedValue() + ".txt"));
			
			Particip = "";
			
			while (Particip != null) {
				Partic.append("	" + Particip + "\n");
				Particip = ler.readLine();		
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
			p.setNome(Usuarios.getSelectedValue());
			p.setDataR(Reunioes.getSelectedValue());
			
			p.gravarParticipantes();
			
			Partic.setText("");
			CarregarPartc();
		}
		else if(e.getSource()==Perfil) {
			
			PerfilUser pu = new PerfilUser();
			pu.setLogin(Usuarios.getSelectedValue());
			System.out.println(pu.getLogin());
			
			Perfil p = new Perfil();
			p.CarregarPerfil(pu.getLogin());
			
		}
	}
}
