package Interface;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Dados.CadastroC;
import Dados.CadastroU;

public class CadUsuario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int Linha = 0;
	private int Coluna = 1;
	GridBagConstraints gbl = null;
	
	JTextField Nome = new JTextField(30);
	JTextField dtContratacao = new JTextField(10);
	JTextField Tel = new JTextField(15);
	JTextField Login = new JTextField(30);
	JTextField Password = new JTextField(30);
	JButton Cadastrar = new JButton("Cadastrar");		
	JButton Limpar = new JButton("Limpar");
	
	@SuppressWarnings("rawtypes")
	JComboBox cat = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox setor = new JComboBox();
	
	@SuppressWarnings({ "unchecked" })
	public CadUsuario() {
				
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
		add(dtContratacao,gbl);
		
		//Telefone
		ConfigT(Linha,1);
		add(newDiscricao("*Telefone"),gbl);
		ConfigT(Coluna,1);
		add(Tel,gbl);
		
		//Categoria
		ConfigT(Linha,1);
		add(newDiscricao("Catergoria"),gbl);
		ConfigT(Coluna,1);
		cat.addItem("Usuário");
		cat.addItem("Coordenador");
		cat.addItem("Gestor de Recursos");
		add(cat,gbl);
		cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cat.getSelectedIndex() == 1) {
					setor.setEnabled(true);
				}
				else if(cat.getSelectedIndex() == 2) {
					JOptionPane.showMessageDialog(null, "Em Desenvolvimento");
					setor.setEnabled(false);
					Cadastrar.setEnabled(false);
				}
				else {
					setor.setEnabled(false);
				}
			}
		});
		
		//Setor
		ConfigT(Linha, 1);
		add(newDiscricao("Setor"),gbl);
		ConfigT(Coluna,1);
		setor.addItem("Financeiro");
		setor.addItem("Logistico");
		setor.addItem("Recuros Humanos");
		setor.addItem("Manutenção");
		setor.addItem("Limpeza");
		setor.addItem("Administrativo");
		setor.setEnabled(false);
		add(setor,gbl);
		
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
		
			if (cat.getSelectedIndex() == 1) {
								
				CadastroC c = new CadastroC();		
				c.setNome(Nome.getText());
				c.setDtContrato(dtContratacao.getText());
				c.setTelefone(Tel.getText());
				c.setSetor(String.valueOf(setor.getSelectedItem()));
				c.setLogin(Login.getText());
				c.setPassword(Password.getText());
						
				c.gravarDadosC();
				
				Nome.setText("");
				dtContratacao.setText("");
				Tel.setText("");
				Login.setText("");
				Password.setText("");
				
			}else if (cat.getSelectedIndex() == 2) {
				//
			}
			else{
				CadastroU u = new CadastroU();
				u.setNome(Nome.getText());
				u.setDtContrato(dtContratacao.getText());
				u.setTelefone(Tel.getText());
				u.setLogin(Login.getText());
				u.setPassword(Password.getText());
						
				u.gravarDadosU();
				
				Nome.setText("");
				dtContratacao.setText("");
				Tel.setText("");
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
		/*setDefaultCloseOperation(EXIT_ON_CLOSE);
		WinLogin wl = new WinLogin();
		wl.setVisible(true);*/
		}
}
