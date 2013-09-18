package ca.etsmtl.ele116.tp1.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Classe gestionnaire de l'ensemble des sockets ouverts.
 * 
 * @author Gregory A. Lussier <lussier@ieee.org>
 *
 */
public class ComSocket {
	public ComSocket(Main m) throws IOException {
		ServerSocket ss = null;
		boolean listening = true;
		try {
			ss = new ServerSocket(10000);
		} catch (IOException e) {
			System.err.println("Error creating the socket on port 10000");
		}
		while (listening) {
			new ComThread(m, ss.accept()).start();
		}
		ss.close();
	}
}