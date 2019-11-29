package Interface;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Perfil extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/*Metodo Resposavel por adicionar um icone de Perfil
	 * na JFrame atráves de uma JLabel, esse metedo faz com
	 * que eu tenha total controle do tamanho e dá resolução da imagem. 
	*/
	public ImageIcon BackgroudP(String Caminho) {
		
		ImageIcon image = new ImageIcon(Caminho);
		image.setImage(image.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),100));
		
		return image;
	}
	JLabel bg = new JLabel();
		
	//TxArea
	public JTextArea load = new JTextArea();
	
		
	public Perfil() {
		
		//Imagem Perfil
		bg.setBounds(15, 25, 120, 120);
		bg.setIcon(BackgroudP("./Dados/Image/Perfil.png"));
		bg.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		//TxArea
		load.setBounds(285, 25, 200, 150);
		load.setBackground(Color.lightGray);
		load.setEditable(false);
		load.setLineWrap(true);

				
		setTitle("E-Meeting - Perfil");
		setLayout(null);
		setResizable(false);	
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(bg);
		CarregarPerfil();
		add(load);
	}
	
	public String CarregarPerfil() {
		WinLogin w = new WinLogin();
		String user = w.tLogin.getText();

		load.setText("");
		String Infor = "";

		System.out.println(user);
		try {
			BufferedReader lerInfor = new BufferedReader(new FileReader("./Dados/C Users/Perfil/" + user + ".txt"));
			Infor = lerInfor.readLine();
			
			
			while(Infor!=null) {
				System.out.println(Infor);
				load.append(Infor + "\n" );
				Infor = lerInfor.readLine();				
			}
			
			lerInfor.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error: Carregamento do Perfil Falhou", "Error",JOptionPane.ERROR_MESSAGE);
		}
		return Infor;
	}
	
	public void Run() {
		
	}
	
}
