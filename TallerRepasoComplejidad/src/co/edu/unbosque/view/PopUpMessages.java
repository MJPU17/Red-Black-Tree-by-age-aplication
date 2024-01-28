package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopUpMessages {
	
	public PopUpMessages() {}
	
	public static void errorMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void infoMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message);
	}

}
