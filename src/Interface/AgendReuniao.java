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
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Dados.AgendaReuniao;

public class AgendReuniao extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private int Linha = 0;
	private int Coluna = 1;
	GridBagConstraints gbl = null;
	
	//Campos
	//SimpleDateFormat mask = new SimpleDateFormat("dd/MM/yyyy");
	JFormattedTextField dtAgendamento = new JFormattedTextField(new MaskFormatter("##-##-####"));
	JFormattedTextField dtReuniao = new JFormattedTextField(new MaskFormatter("##-##-####"));
	JTextField dtAgendamento1 = new JTextField(15);
	JTextField dtReuniao1 = new JTextField(15);
	JTextField TAssunto = new JTextField(30);
	
	//Seletores
	JComboBox<String> SetorR = new JComboBox<String>();
	JComboBox<String> Salas = new JComboBox<String>();
	
	//Caixa de Texto
	JTextArea AP = new JTextArea();
	JScrollPane barra = new JScrollPane(AP);
	
	//Butões
	JButton Salvar = new JButton("Agendar");
	JButton Limpar = new JButton("Limpar");
	

	public AgendReuniao() throws ParseException{
		
		setTitle("E-Meeting Agendar Reunião");
		setLayout(new GridBagLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		gbl = new GridBagConstraints();
		gbl.insets = new Insets(10,10,10,10);
		gbl.anchor = GridBagConstraints.WEST;
		
		
		//Data de Agendamento
		ConfigT(Linha,1);
		add(newDiscricao("Data de Agendamento"),gbl);
		ConfigT(Coluna,1);
		dtAgendamento.setPreferredSize(new Dimension(80,25));
		add(dtAgendamento, gbl);
		
		//Data da Reunião
		ConfigT(Linha,1);
		add(newDiscricao("Data da Reunião"),gbl);
		ConfigT(Coluna,1);
		dtReuniao.setPreferredSize(new Dimension(80,25));
		add(dtReuniao, gbl);
		
		//Assunto da Reunião
		ConfigT(Linha,1);
		add(newDiscricao("Assunto da Reunião"),gbl);
		ConfigT(Coluna,1);
		add(TAssunto, gbl);
		
		//Setor que será reunido
		ConfigT(Linha,1);
		add(newDiscricao("Qual Setor?"),gbl);
		SetorR.addItem("Financeiro");
		SetorR.addItem("Logistico");
		SetorR.addItem("Recuros Humanos");
		SetorR.addItem("Manutenção");
		SetorR.addItem("Limpeza");
		SetorR.addItem("Administrativo");
		ConfigT(Coluna,1);
		add(SetorR, gbl);
		
		//Sala á ser Usada
		ConfigT(Linha, 1);
		add(newDiscricao("Escolha a Sala: "), gbl);
		Salas.addItem("Sala 1");
		Salas.addItem("Sala 2");
		Salas.addItem("Sala 3");
		Salas.addItem("Sala 4");
		Salas.addItem("Sala 5");
		ConfigT(Coluna, 1);
		CarregarSalas();
		add(Salas, gbl);
		
		
		//Palta / Ata
		ConfigT(Linha,1);
		add(newDiscricao("Ata / Pauta da Reunião"),gbl);
		ConfigT(Coluna,1);
		barra.setPreferredSize(new Dimension(500,100));
		add(barra, gbl);
		
		ConfigT(Linha,1);
		Salvar.addActionListener(this);
		add(Salvar,gbl);
		ConfigT(Coluna,1);
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
	
	public JLabel newDiscricao(String disc) {
		JLabel Discricao = new JLabel(disc);
		return Discricao;
	}
		
	public void  CarregarSalas() {
		try {
			BufferedReader salas = new BufferedReader(new FileReader("./Salas Gerais.txt"));
			String atualizar = "";
			
			while (atualizar != null) {
				atualizar = salas.readLine();
				Salas.addItem(atualizar);
			}
			salas.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Error: Erro inesperado ao atualizar salas", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void Run() {	}
	
	/*O ConfigT é responsável por configurar o layout da JFrame
	 * como uma planilha, separando os componentes por linhas
	 * e colunas.
	 */
	public void ConfigT(int posicao, int qtdeL) {
		if (posicao == Linha) {
			gbl.gridy = gbl.gridy + 1;
			gbl.gridx = 0;
		}
		else {
			gbl.gridx = gbl.gridx + 1;
		}
		gbl.gridwidth = qtdeL;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Salvar) {
						
			AgendaReuniao ar = new AgendaReuniao();
			ar.setDtAgentamento(dtAgendamento.getText());
			ar.setDtReuniao(dtReuniao.getText());
			ar.setAssunto(TAssunto.getText());
			ar.setSetor(String.valueOf(SetorR.getSelectedItem()));
			ar.setSala(String.valueOf(Salas.getSelectedItem()));
			ar.setAP(AP.getText());
			
			ar.gravarDadosR();
			
			dtAgendamento1.setText("");
			dtReuniao1.setText("");
			TAssunto.setText("");
			SetorR.setSelectedItem(0);
			AP.setText("");
		}
		else {
			dtAgendamento1.setText("");
			dtReuniao1.setText("");
			TAssunto.setText("");
			SetorR.setSelectedItem(0);
			AP.setText("");
		}
	}
	
}
