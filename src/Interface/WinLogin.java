package Interface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;

public class WinLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	
	public void BackGround(String Caminho) {
		JLabel bg = new JLabel(new ImageIcon(Caminho));
		bg.setLayout(null);
		setContentPane(bg);
	}
	
	//Label
	JLabel LDisc = new JLabel("Bem Vindo ao e-Meeting");
	JLabel LUsuario = new JLabel("Usuário");
	JLabel LPass = new JLabel("Senha");
	
	//TextField
	JTextField tLogin = new JTextField(15);
	JPasswordField tPass = new JPasswordField(15);
	
	//Button
	JButton bLogin = new JButton("Login");
	JButton bEsqueci = new JButton("Esqueci a senha");
	JButton bCadastro = new JButton("Cadastrar-se");
	
	
	public WinLogin(){
		
		//Label
		LDisc.setBounds(165, 20, 250, 20);		
		LUsuario.setBounds(140, 110, 90,20);
		LPass.setBounds(140, 150, 90,20);
		
		//TextField
		tLogin.setBounds(200, 110, 170,25);		
		tPass.setBounds(200, 150, 170,25);
		
		//Button
		bLogin.setBounds(140, 195, 80, 25);
		bLogin.addActionListener(this);
		bEsqueci.setBounds(175, 235, 155, 25);
		bEsqueci.addActionListener(this);
		bCadastro.setBounds(240, 195, 130, 25);
		bCadastro.addActionListener(this);
		
		//JFrame
		setTitle("e-Meeting Login");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		BackGround("./Dados/Image/Login.jpg");
		setSize(500,450);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Label
		add(LDisc);
		add(LUsuario);
		add(LPass);
		
		//TextField
		add(tLogin);
		add(tPass);
		
		//Button
		add(bLogin);
		add(bEsqueci);
		add(bCadastro);
	}
	public void Run() {	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bLogin) {

			Validador v = new Validador();
			v.setLogin(tLogin.getText());
			v.setPassword(tPass.getPassword());
			
			v.CriarPerfil();
			v.VLogin();
			
			tPass.setText("");
			dispose();
		}
		else if (e.getSource() == bEsqueci) {
			JOptionPane.showMessageDialog(null, "Keep Calm","Wait" , JOptionPane.PLAIN_MESSAGE);
		}
		else {
			try {
				CadUsuario cad = new CadUsuario();
				cad.Run();
				cad.Cat.setEnabled(false);
			}
			catch (ParseException exp) {
				JOptionPane.showMessageDialog(null, "Preencha as Datas Corretamente DD/MM/YYYY", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
