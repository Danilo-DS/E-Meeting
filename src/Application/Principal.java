package Application;

import javax.swing.JOptionPane;

import Interface.WinLogin;

//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Scanner;

public class Principal {
	public static void main(String[] args)  {
		JOptionPane.showMessageDialog(null, "Cadastre-se para pode logar (Se cadastre como usuario)");
		JOptionPane.showMessageDialog(null, "As Logicas para os outros tipos ainda não estão prontas.");
		JOptionPane.showMessageDialog(null, "Devido o uso do Linux, os diretorios de salvemento não irá funcionar "
				+ "em Windows");
		
		WinLogin login = new WinLogin();
		login.Run();		 
	}
		 
	
}


