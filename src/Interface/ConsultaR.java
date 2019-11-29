package Interface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;



public class ConsultaR extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private int linha = 0;
	private int Coluna = 1;
	private GridBagConstraints gbl;
	
	//Descrição
	JLabel disc = new JLabel("Buscar Reunião");
	
	//Campo de Busca
	JFormattedTextField Busca = new JFormattedTextField(new MaskFormatter("##-##-####"));
	
	//TxArea/Scroll Exibr
	JTextArea Exibir = new JTextArea();
	JScrollPane barra = new JScrollPane(Exibir);
	
	//Botões
	JButton Pesquisar = new JButton("Pesquisar");
	JButton Limpar = new JButton("Limpar");
	JButton Editar = new JButton("Editar Reunião");
	JButton Participar = new JButton("Participar");
	
	public ConsultaR() throws ParseException{
		//JFT Busca
		Busca.setPreferredSize(new Dimension(90,25));
		
		//TxArea
		Exibir.setLineWrap(true);
		Exibir.setEditable(false);
		barra.setPreferredSize(new Dimension(600,300));
		
		
		setTitle("E-Meeting Beta - Consultar Reunião");
		setLayout(new GridBagLayout());
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
		gbl = new GridBagConstraints();
		gbl.insets = new Insets(10, 10, 10, 10);
		gbl.anchor = GridBagConstraints.CENTER;
		
		ConfigT(linha, 1);
		add(disc,gbl);
		ConfigT(Coluna, 1);
		add(Busca,gbl);
		ConfigT(Coluna, 1);
		Pesquisar.addActionListener(this);
		add(Pesquisar,gbl);		
		
		ConfigT(linha, 3);
		add(barra,gbl);
		ConfigT(linha, 1);
		add(Participar,gbl);
		ConfigT(Coluna, 1);
		add(Editar,gbl);
		ConfigT(Coluna, 1);
		Limpar.addActionListener(this);
		add(Limpar,gbl);
		
		//Evento de Fechamento de Tela
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				Home h = new Home();
				h.Run();
			}
		});
		
	}
	
	public void Run() {	}
	
	public void BuscarReuniao(String reuniao) {
		String leitura = "";
		try {
			
			File caminho = new File("./Dados/C Reunioes/"+reuniao+".txt");
			BufferedReader ler = new BufferedReader(new FileReader(caminho));
			leitura = ler.readLine();
			if (caminho.exists()) {
				while (leitura != null) {
					Exibir.append(leitura + "\n");
					leitura = ler.readLine();
				}
			}
			ler.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: Reunião não Encontrada", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void ConfigT(int P, int qtdeLinha) {
		if (P == linha) {
			gbl.gridy = gbl.gridy + 1;
			gbl.gridx = 0;
		}
		else {
			gbl.gridx = gbl.gridx + 1;
		}
		gbl.gridwidth = qtdeLinha;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== Pesquisar) {
			BuscarReuniao(Busca.getText());
		}
		else if(e.getSource()== Limpar){
			Busca.setText("");
			Exibir.setText("");
		}
	}
	
}
