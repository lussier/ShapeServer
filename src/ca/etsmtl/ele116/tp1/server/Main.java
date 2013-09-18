package ca.etsmtl.ele116.tp1.server;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

/**
 * Classe de point d'entrée au programme et d'affichage graphique.
 * 
 * @author Gregory A. Lussier <lussier@ieee.org>
 *
 */
public class Main {
	
	JFrame jf;
	JTextArea jta;
	JScrollPane jsp;
	
	public Main() {
		jf = new JFrame();
		jf.setPreferredSize(new Dimension(700,400));
		jta = new JTextArea();
		jta.setEditable(false);
		jsp = new JScrollPane(jta);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jf.add(jsp);
		jf.pack();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		try {
		ComSocket s = new ComSocket(m);
		} catch (IOException e) {
			System.err.println("IOException dans le constructeur de ComSocket.");
		}
	}
	
}
