package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Home extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
		
	JMenuBar Menu = new JMenuBar();
	
	//Menu(Perfil)
	JMenu M = new JMenu("Menu");
	//JMenuItem MeuPerfil = new JMenuItem("Ver");
	JMenuItem Logoff = new JMenuItem("Logoff");
	JMenuItem Sair = new JMenuItem("Sair");
	
	//Menu(Cadastro)
	JMenu DiscMenuCad = new JMenu("Cadastro");
	JMenuItem CadastroU = new JMenuItem("Cadastrar Usuário");
	JMenuItem CadastroR = new JMenuItem("Cadastrar Reunião");
	JMenuItem CadastroS = new JMenuItem("Cadastrar Salas");
	JMenuItem CadastroP = new JMenuItem("Adiconar Participantes");
	
	//Menu(Consulta)
	JMenu DiscMenuCon = new JMenu("Pesquisar");
	JMenuItem PesquisarR = new JMenuItem("Buscar Reunião");
	//JMenuItem PesquisarU;
	
	//lista / Scroll Pane
	JList<String> RList = new JList<String>(carregarFeed());
	JScrollPane barraL = new JScrollPane(RList);
	
	//TextArea / Scroll Pane
	JTextArea feed = new JTextArea();
	JScrollPane barraT = new JScrollPane(feed);
	
	//Botão
	JButton Participar = new JButton("Participar");

	public Home() {
		
		//JList
		barraL.setBounds(280, 90, 200, 450);
		
		//TxArea
		feed.setEditable(false);
		feed.setLineWrap(true);
		barraT.setBounds(490,90,600,450);
		
		//Botão
		Participar.setBounds(980, 550, 110, 25);
		
			
		setTitle("E-Meeting Home");
		setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setJMenuBar(Menu);
		setVisible(true);
		
		//Menu (Perfil)
		//M.add(MeuPerfil);
		//MeuPerfil.addActionListener(this);
		M.add(Logoff);
		Logoff.addActionListener(this);
		M.add(Sair);
		Sair.addActionListener(this);
		
		//Menu (Cadastro)
		DiscMenuCad.add(CadastroU);
		CadastroU.addActionListener(this);
		DiscMenuCad.add(CadastroR);
		CadastroR.addActionListener(this);
		DiscMenuCad.add(CadastroP);
		CadastroP.addActionListener(this);
		DiscMenuCad.add(CadastroS);
		CadastroS.addActionListener(this);
		
		
		//Menu (Consulta)
		DiscMenuCon.add(PesquisarR);
		PesquisarR.addActionListener(this);
		//DiscMenuCon.add(PesquisarU);
		
		//Adionando os Menu a Frame
		Menu.add(M);
		Menu.add(DiscMenuCad);
		Menu.add(DiscMenuCon);
		
		//lista
		add(barraL);
		RList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		RList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				VerFeed();				
			}
		});
		
		//TxArea
		add(barraT);
		
		//Botão
		add(Participar);
		
		//Evento de Fechamento de Tela
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
				WinLogin w = new WinLogin();
				w.Run();
			}
		});
	}
	
	public String[] carregarFeed() {
		
		File[] Arquivos;
		File f = new File("./Dados/C Reunioes/");
		Arquivos = f.listFiles();
		String[] lista = new String[Arquivos.length]; 
		
		for (int i = 0; i < Arquivos.length; i++) {
			File arq = Arquivos[i];
			if(arq.isFile()) {
				lista[i]= arq.getName().replace(".txt","");
			}
		}
		return lista;
	}
	
	public void VerFeed() {
		feed.setText("");
		try {
		String reuniao;
		BufferedReader ler = new BufferedReader(new FileReader("./Dados/C Reunioes/"+ RList.getSelectedValue() + ".txt"));
		
		reuniao = "";
		
		while (reuniao != null) {
			feed.append("	" + reuniao + "\n");
			reuniao = ler.readLine();		
		}
		ler.close();
		
	}
	catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Error: Carregamento Falhou", "Error", JOptionPane.ERROR_MESSAGE);
	}
	}
	
	public String CaptP(String n) {
		String login;
		login = n;
		return login;
	}
	
	public void Run() {	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CadastroU) {
			try {
			CadUsuario cad = new CadUsuario();
			cad.Run();
			}
			catch (ParseException exp) {
				JOptionPane.showMessageDialog(null, "Preencha a Data Corretamente DD/MM/YYYY", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (e.getSource() == CadastroR) {
			dispose();
			try {
				AgendReuniao agend = new AgendReuniao();
				agend.Run();
			}
			catch(ParseException exp) {
				JOptionPane.showMessageDialog(null, "Preencha as Datas Corretamente DD/MM/YYYY", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (e.getSource() == CadastroS) {
			CadSalas cadS = new CadSalas();
			cadS.Run();
		}
		else if (e.getSource() == PesquisarR) {
			dispose();
			try {
				ConsultaR c = new ConsultaR();
				c.Run();
			}
			catch (ParseException exp) {
				JOptionPane.showMessageDialog(null, "Preencha as Datas Corretamente DD/MM/YYYY", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (e.getSource() == Participar) {
			JOptionPane.showMessageDialog(null, "Keep Calm","Wait" , JOptionPane.PLAIN_MESSAGE);
		}
		else if (e.getSource() == Logoff) {
			dispose();
			try {
				CadUsuario c = new CadUsuario();
				CadSalas cs = new CadSalas();
				c.dispose();
				cs.dispose();				
			}
			catch (ParseException exp) {
				JOptionPane.showMessageDialog(null, "Preencha a Data Corretamente DD/MM/YYYY", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			WinLogin w = new  WinLogin();
			w.Run();
		}
		else if(e.getSource()==CadastroP) {
			dispose();
			Participantes p = new Participantes();
			p.Run();
		}
		else {
			System.exit(EXIT_ON_CLOSE);
		}
	}

}


