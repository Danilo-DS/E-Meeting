package Interface;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Dados.CadastroC;
import Dados.CadastroGR;
import Dados.CadastroU;

public class CadUsuario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int Linha = 0;
	private int Coluna = 1;
	GridBagConstraints gbl = null;
	
	//Campos
	JTextField Nome = new JTextField(30);
	JFormattedTextField dtContratacao = new JFormattedTextField(new MaskFormatter("##/##/####"));
	JFormattedTextField Tel = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
	JTextField Login = new JTextField(30);
	JPasswordField Password = new JPasswordField(30);
	JButton Cadastrar = new JButton("Cadastrar");		
	JButton Limpar = new JButton("Limpar");
	
	//Categoria(Cat)/Setores
	JComboBox<String> Cat = new JComboBox<String>();
	JComboBox<String> Setor = new JComboBox<String>();
	JComboBox<String> Turno = new JComboBox<String>();
	
	public CadUsuario() throws ParseException{
				
		setTitle("E-Meeting Cadastro");
		setLayout(new GridBagLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		gbl = new GridBagConstraints();
		gbl.insets = new Insets(10,10,10,10);
		gbl.anchor = GridBagConstraints.WEST;
		
		//Nome
		ConfigT(Linha,1);
		add(newDiscricao("*Nome"),gbl);
		ConfigT(Coluna,1);
		add(Nome,gbl);

		//Data de Contratação
		ConfigT(Linha,1);
		add(newDiscricao("*Data de Contratação"),gbl);
		ConfigT(Coluna,1);
		dtContratacao.setPreferredSize(new Dimension(80, 25));
		add(dtContratacao,gbl);
		
		//Telefone
		ConfigT(Linha,1);
		add(newDiscricao("*Telefone"),gbl);
		ConfigT(Coluna,1);
		Tel.setPreferredSize(new Dimension(80, 25));
		add(Tel,gbl);
		
		//Categoria
		ConfigT(Linha,1);
		add(newDiscricao("Catergoria"),gbl);
		ConfigT(Coluna,1);
		Cat.addItem("Usuário");
		Cat.addItem("Coordenador");
		Cat.addItem("Gestor de Recursos");
		add(Cat,gbl);
		Cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Cat.getSelectedIndex() == 1) {
					Setor.setEnabled(true);
					Turno.setEnabled(false);
				}
				else if(Cat.getSelectedIndex() == 2) {
					Setor.setEnabled(false);
					Turno.setEnabled(true);					
				}
				else {
					Setor.setEnabled(false);
					Turno.setEnabled(false);
				}
			}
		});
		
		//Setor
		ConfigT(Linha, 1);
		add(newDiscricao("Setor"),gbl);
		ConfigT(Coluna,1);
		Setor.addItem("Financeiro");
		Setor.addItem("Logistico");
		Setor.addItem("Recuros Humanos");
		Setor.addItem("Manutenção");
		Setor.addItem("Limpeza");
		Setor.addItem("Administrativo");
		Setor.setEnabled(false);
		add(Setor,gbl);
		
		//Turno
		ConfigT(Linha,1);
		add(newDiscricao("Turno"),gbl);
		ConfigT(Coluna,1);
		Turno.addItem("Manhã");
		Turno.addItem("Tarde");
		Turno.setEnabled(false);
		add(Turno, gbl);
		
		//Login
		ConfigT(Linha,1);
		add(newDiscricao("*Usuário de Acesso"),gbl);
		ConfigT(Coluna,1);
		add(Login,gbl);
		
		//Password
		ConfigT(Linha,1);
		add(newDiscricao("*Senha de Acesso"),gbl);
		ConfigT(Coluna,1);
		add(Password,gbl);
		
		//BotãoCadastrar
		ConfigT(Linha, 1);
		Cadastrar.addActionListener(this);
		add(Cadastrar,gbl);
		ConfigT(Coluna, 1);
		Limpar.addActionListener(this);
		add(Limpar,gbl);
		
	}
	
	public JLabel newDiscricao(String DiscL) {
		JLabel label = new JLabel(DiscL);
		return label;
	}
		
	public void Run() {	}
	
	/*O ConfigT é responsável por configurar o layout da JFrame
	 * como uma planilha, separando os componentes por linhas
	 * e colunas.
	 */
	public void ConfigT(int posicao, int QtdeL) {
		if (posicao == Linha) {
			gbl.gridy = gbl.gridy+1;
			gbl.gridx = 0;
		}
		else {
			gbl.gridx = gbl.gridx+1;
		}
		gbl.gridwidth = QtdeL;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Cadastrar) {
						
			if (Cat.getSelectedIndex() == 1) {
												
				CadastroC c = new CadastroC();		
				c.setNome(Nome.getText());
				c.setDtContrato(dtContratacao.getText());
				c.setTelefone(Tel.getText());
				c.setTipoUsuario(String.valueOf(Cat.getSelectedItem()));
				c.setSetor(String.valueOf(Setor.getSelectedItem()));
				c.setLogin(Login.getText());
				c.setPassword(Password.getPassword());
						
				c.gravarDadosC();
				
				Nome.setText("");
				dtContratacao.setText("");
				Tel.setText("");
				Cat.setSelectedIndex(0);
				Setor.setSelectedIndex(0);
				Turno.setSelectedIndex(0);
				Login.setText("");
				Password.setText("");
				
			}
			else if (Cat.getSelectedIndex() == 2) {
				
				CadastroGR gr = new CadastroGR();
				
				gr.setNome(Nome.getText());
				gr.setDtContrato(dtContratacao.getText());
				gr.setTelefone(Tel.getText());
				gr.setTipoUsuario(String.valueOf(Cat.getSelectedItem()));
				gr.setLogin(Login.getText());
				gr.setPassword(Password.getPassword());
				gr.setTurno(String.valueOf(Turno.getSelectedItem()));
				
				gr.gravarDadosGR();
				
				Nome.setText("");
				dtContratacao.setText("");
				Tel.setText("");
				Cat.setSelectedIndex(0);
				Setor.setSelectedIndex(0);
				Turno.setSelectedIndex(0);
				Login.setText("");
				Password.setText("");
				
			}
			else{
				CadastroU u = new CadastroU();
				u.setNome(Nome.getText());
				u.setDtContrato(dtContratacao.getText());
				u.setTelefone(Tel.getText());
				u.setTipoUsuario(String.valueOf(Cat.getSelectedItem()));
				u.setLogin(Login.getText());
				u.setPassword(Password.getPassword());
						
				u.gravarDadosU();
				//Validador v = new Validador();
				//v.ValidarL(String.valueOf(Cat.getSelectedItem()));
				
				
				Nome.setText("");
				dtContratacao.setText("");
				Tel.setText("");
				Cat.setSelectedIndex(0);
				Setor.setSelectedIndex(0);
				Turno.setSelectedIndex(0);
				Login.setText("");
				Password.setText("");
			}
		}
		else {
			Nome.setText("");
			dtContratacao.setText("");
			Tel.setText("");
			Login.setText("");
			Password.setText("");
					
		}
	}
}

