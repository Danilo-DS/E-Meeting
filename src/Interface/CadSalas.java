package Interface;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Dados.SalasC;

public class CadSalas extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	//Campos
	JTextField NomeSala = new JTextField(15);
	JTextField Numero = new JTextField(15);
	
	
	//Legendas
	JLabel NomeS = new JLabel("Nome da Sala");
	JLabel NumeroS = new JLabel("Número da Sala");
	
	//Botões
	JButton SalvarS = new JButton("Salvar");
	JButton Limpar = new JButton("Limpar");
	
	public CadSalas(){
		
		//Legendas
		NomeS.setBounds(90, 80, 95, 30);
		NumeroS.setBounds(90, 115, 115, 30);
		
		//Campos
		NomeSala.setBounds(210, 80, 100, 25);
		Numero.setBounds(210, 115, 100, 25);
		
		//Botoes
		SalvarS.setBounds(105, 165, 85, 25);
		SalvarS.addActionListener(this);
		Limpar.setBounds(210, 165, 85, 25);
		Limpar.addActionListener(this);
		
		setTitle("Cadastrar Sala");
		setLayout(null);
		setResizable(false);
		setSize(400,370);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Legendas
		add(NomeS);
		add(NumeroS);
		
		//Campos
		add(NomeSala);
		add(Numero);
		
		//Botões
		add(SalvarS);
		add(Limpar);
	}
	
	public void Run() { }
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == SalvarS) {
			
			SalasC sala = new SalasC();
			
			sala.setNomeSala(NomeSala.getText());
			sala.setNumeroSala(Numero.getText());
			sala.gravarSalas();
			
			NomeSala.setText("");
			Numero.setText("");
		}
		else if (e.getSource() == Limpar) {
			
			NomeSala.setText("");
			Numero.setText("");
		}
		
	}

}
