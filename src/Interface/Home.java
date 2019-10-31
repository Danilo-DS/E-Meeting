package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Home extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JMenuBar Menu = new JMenuBar();
	
	//Menu(Perfil)
	JMenu Perfil = new JMenu("Perfil");
	JMenuItem MeuPerfil = new JMenuItem("Ver Perfil");
	JMenuItem Sair = new JMenuItem("Sair");
	
	//Menu(Cadastro)
	JMenu DiscMenuCad = new JMenu("Cadastro");
	JMenuItem CadastroU = new JMenuItem("Cadastrar Usuário");
	JMenuItem CadastroR = new JMenuItem("Cadastrar Reunião");
	
	//Menu(Consulta)
	JMenu DiscMenuCon = new JMenu("Pesquisar");
	JMenuItem PesquisarR = new JMenuItem("Buscar Reunião");
	//JMenuItem PesquisarU;
	
	public Home() {
			
		setTitle("E-Meeting Home");
		setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setJMenuBar(Menu);
		setVisible(true);
		
		//Menu (Perfil)
		Perfil.add(MeuPerfil);
		MeuPerfil.addActionListener(this);
		Perfil.add(Sair);
		Sair.addActionListener(this);
		
		//Menu (Cadastro)
		DiscMenuCad.add(CadastroU);
		CadastroU.addActionListener(this);
		DiscMenuCad.add(CadastroR);
		CadastroR.addActionListener(this);
		
		
		//Menu (Consulta)
		
		DiscMenuCon.add(PesquisarR);
		PesquisarR.addActionListener(this);
		//DiscMenuCon.add(PesquisarU);
		
		Menu.add(Perfil);
		Menu.add(DiscMenuCad);
		Menu.add(DiscMenuCon);
	}
	
	public void Run() {	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CadastroU) {
			CadUsuario cad = new CadUsuario();
			cad.Run();
		}
		else if (e.getSource() == CadastroR) {
			AgendReuniao agend = new AgendReuniao();
			agend.Run();
		}
		else if (e.getSource() == PesquisarR) {
			JOptionPane.showMessageDialog(null, "Keep Calm, is under Developments ");
		}
		else if (e.getSource() == MeuPerfil) {
			JOptionPane.showMessageDialog(null, "Keep Calm, is under Developments ");
		}
		else {
				JOptionPane.showMessageDialog(null, "Keep Calm, is under Developments ");
		}
	}

	
}


