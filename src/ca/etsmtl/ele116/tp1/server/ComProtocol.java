package ca.etsmtl.ele116.tp1.server;

import java.util.Random;

/**
 * Contrôleur des communications.
 * 
 * @author Gregory A. Lussier <lussier@ieee.org>
 *
 */
public class ComProtocol {
	static final ComProtocol cp = new ComProtocol();
	public ComProtocol() {}
	static public ComProtocol getInstance() {
		return cp;
	}
	public String process(String s) {
		
		String[] couleurs = {"BLEU", "JAUNE", "VERT", "BRUN", "NOIR", "BLANC", "MAUVE", "ROSE"};
		Random r = new Random();
		
		String out = "DEFAULT";
		if (s == null) {
			s = "";
		}
		if (s.equals("")) {
			out = "commande>";
		}
		else if (s.equals("GET")) {
			String shape;
			int[] params = { -1, -1, -1, -1 };
			switch (r.nextInt(5)) {
				case 0: // CARRE
					shape = "CARRE";
					params[0] = r.nextInt(250);
					params[1] = r.nextInt(250);
					params[2] = (int) (params[0] + r.nextFloat() * (500 - params[0]));
					params[3] = params[1] + (params[2] - params[0]);
					break;
				case 1: // RECTANGLE
					shape = "RECTANGLE";
					params[0] = r.nextInt(250);
					params[1] = r.nextInt(250);
					params[2] = (int) (params[0] + r.nextFloat() * (500 - params[0]));
					params[3] = (int) (params[1] + r.nextFloat() * (500 - params[1]));
					break;
				case 2: // CERCLE
					shape = "CERCLE";
					params[0] = r.nextInt(250);
					params[1] = r.nextInt(250);
					params[2] = r.nextInt(400);
					break;
				case 3: // ELLIPSE
					shape = "ELLIPSE";
					params[0] = r.nextInt(250);
					params[1] = r.nextInt(250);
					params[2] = r.nextInt(400);
					params[3] = r.nextInt(400);
					break;
				case 4: // LIGNE
					shape = "LIGNE";
					params[0] = r.nextInt(250);
					params[1] = r.nextInt(250);
					params[2] = params[0] + r.nextInt(500-params[0]);
					params[3] = params[1] + r.nextInt(500-params[1]);
					break;
				default:
					shape = "";
					break;
			}
			
			out = "1 <" + shape + "> ";
			for (int param : params)
				if (param >= 0)
					out += (param + " ");
			out += couleurs[r.nextInt(couleurs.length)];
			out += " </" + shape + ">";
		}
		else if (s.equals("END")) {
			out = "GOODBYE";
		}
		return out;
	}
}
