package ca.etsmtl.ele116.tp1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe gestionnaire d'un socket.
 * 
 * @author Gregory A. Lussier <lussier@ieee.org>
 *
 */
public class ComThread extends Thread {
	private Socket s = null;
	Main m;
	public ComThread(Main m, Socket s) {
		this.m = m;
		this.s = s;
	}
	/**
	 * Ajoute une ligne de texte dans la console
	 * 
	 * Syntaxe de la sortie:
	 * 	 Date, heure, adresse IP, port TCP, type, in
	 * 
	 * @param type	un identificateur du type d'enregistrement
	 * @param in	données à afficher
	 */
	public void appendEntry(String type, String in) {
		String out;
		Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	String remoteAddress = s.getRemoteSocketAddress().toString();
    	out = sdf.format(cal.getTime()) + " " + remoteAddress + " " + type + " " + in;
    	m.jta.append(out + "\n");
    	// Ajuste le scrollbar à la position active
    	m.jta.setCaretPosition(m.jta.getDocument().getLength());
	}
	/**
	 * Thread associée à un socket: envoie et reçoit les données.
	 */
	public void run() {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String inputLine, outputLine;
			outputLine = ComProtocol.getInstance().process(null);
			out.println(outputLine);
			while ((inputLine = in.readLine()) != null) {
				appendEntry("RECEIVED", inputLine);
				outputLine = ComProtocol.getInstance().process(inputLine);
				out.println(outputLine);
				appendEntry("SENT", outputLine);
				if (outputLine.equals("GOODBYE")) {
					break;
				}
			}
			out.close();
			in.close();
			s.close();
		} catch (IOException e) {
			
		}
	}
}
