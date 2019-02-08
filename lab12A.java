//============================================================================
// Programmeur: Daniel
// Date: 28 nov. 2016
// Fichier: Switcheur4.java
// Description: 
//============================================================================
import java.io.*;
import javax.swing.*;

public class lab12A {

	public static void main(String[] args) {
		String chaine = lireFichier("germinal.txt");
		//String chaine = JOptionPane.showInputDialog("Entrez une chaîne: ","J'ai reçu un éléphant pour Noël");
		String s1 = chaine.toLowerCase();
		int nbAlpha = 0; // nb Caratere alphabetique
		int[] f = new int[26];
		char c;
		for (int i = 0; i < chaine.length(); i++) {
			switch( c = s1.charAt(i) ) {
			case 'à' : 
			case 'â' :	
			case 'ä' :	
				c = 'a';
				break;
			case 'é' : 
			case 'è' :	
			case 'ë' :	
			case 'ê' :
				c = 'e';
				break;
			case 'ì' : 
			case 'î' :	
			case 'ï' :	
				c = 'i';
				break;
			case 'ò' : 
			case 'ô' :	
			case 'ö' :	
				c = 'o';
				break;
			case 'ù' : 
			case 'û' :	
			case 'ü' :	
				c = 'u';
				break;
			case 'ç' :	
				c = 'c';
				break;
			}//Fin du switch
			if( c>='a' && c<='z') {
				nbAlpha++;
				f[c-'a']++;
			}
		}
		//Affichage des resultats
		System.out.println("===============================================================================");
		//System.out.println("La chaine saisie : " +chaine);
		System.out.println( "Longueur de la chaine : " + chaine.length() );
		System.out.println( "Nombre de charatere alpahbetique : " + nbAlpha );
		System.out.println("===============================================================================");
		for (int i = 0; i < 26; i++) {
			System.out.printf((char)('A'+i)+":%1$4d/%2$1d = %3$4.1f%%   ",f[i],nbAlpha,100.0*f[i]/nbAlpha);
			if((i+1)%4==0) System.out.println();
		}
		System.out.println("\n===============================================================================");
		
	}//Fin du main
	private static String lireFichier(String fichier) {
		//Cette variable contiendra tout le texte du fichier
		StringBuffer tampon = new StringBuffer();  
		try {
		  FileReader fr = new FileReader( fichier );
		  BufferedReader br = new BufferedReader( fr );
		  String chaine = "";
		  while( (chaine = br.readLine()) != null ) {
		    tampon.append( chaine + "\n" );
		  }
		  br.close();
		}
		catch( IOException ioe ) {
		  System.err.println( "Erreur à la lecture du fichier..." );
		}
		//On extrait ici le texte qui se trouve dans le StringBuffer.
		return tampon.toString();


	}

}
