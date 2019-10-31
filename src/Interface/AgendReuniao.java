package Interface;

import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class AgendReuniao extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private int Linha = 0;
	private int Coluna = 1;
	GridBagConstraints gbl = null;
	
	JTextField dtAgendamento = new JTextField(15);
	JTextField dtReuniao = new JTextField(15);
	JTextField TAssunto = new JTextField(30);
	@SuppressWarnings("rawtypes")
	JComboBox SetorR = new JComboBox();
	JTextArea AP = new JTextArea(); 
	
	@SuppressWarnings("unchecked")
	public AgendReuniao(){
		
		setTitle("E-Meeting Agendar Reunião");
		setLayout(new GridBagLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		gbl = new GridBagConstraints();
		gbl.anchor = GridBagConstraints.WEST;
		gbl.insets = new Insets(10,10,10,10);
		
		//Data de Agendamento
		ConfigT(Linha,1);
		add(newDiscricao("Data de Agendamento"),gbl);
		ConfigT(Coluna,1);
		add(dtAgendamento);
		
		//Data da Reunião
		ConfigT(Linha,1);
		add(newDiscricao("Data da Reunião"),gbl);
		ConfigT(Coluna,1);
		add(dtReuniao);
		
		//Assunto da Reunião
		ConfigT(Linha,1);
		add(newDiscricao("Assunto da Reunião"),gbl);
		ConfigT(Coluna,1);
		add(TAssunto);
		
		//Setor que será reunido
		ConfigT(Linha,1);
		add(newDiscricao("A reunião vai ser para qual Setor?"),gbl);
		SetorR.addItem("Financeiro");
		ConfigT(Coluna,1);
		add(SetorR);
		
		//Palta / Ata
		ConfigT(Linha,1);
		add(newDiscricao("A reunião vai ser para qual Setor?"),gbl);
		ConfigT(Coluna,1);
		add(AP);
		
	}
	
	public JLabel newDiscricao(String disc) {
		JLabel Discricao = new JLabel(disc);
		return Discricao;
	}
	
	public void Run() {	}
	
	/*O ConfigT é responsável por configurar o layout da JFrame
	 * como uma planilha, separando os componentes por linhas
	 * e colunas.
	 */
	public void ConfigT(int posicao, int qtdeL) {
		if (posicao == Linha) {
			gbl.gridx = gbl.gridx + 1;
			gbl.gridy = 0;
		}
		else {
			gbl.gridy = gbl.gridy + 1;
		}
		gbl.gridwidth = qtdeL;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
