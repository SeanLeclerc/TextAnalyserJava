import java.io.*;
public class Analyseur {
	//variable
	private String fichier;
	private int[] f = new int[26];
	private int nbCaracteres = 0;
	private int nbAlpha = 0;
	
	//Constructeur
	public Analyseur( String fichier ) {
		this.fichier = fichier;
		String chaine = lireFichier(fichier);
		nbCaracteres = chaine.length();
		String s1 = chaine.toLowerCase();		
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
			if( c>='a' && c<='z' ) {
				nbAlpha++;
				f[ c-'a' ]++;
			}
		}//Fin du for
		
	}//Fin du constructeur
	//Méthodes
		public String toString() {
			String s = "";
			s += new String(new char[41]).replace('\0', '=') + "\n";
			s += "Fichier analyse : " + fichier + "\n";
			s += "Nombre total de caracteres : " + nbCaracteres + "\n";
			s += "Nombre de caractere alphabetique : " + nbAlpha + "\n";
			s += new String(new char[41]).replace('\0', '=') + "\n";
			for (int i = 0; i < f.length; i++) {
				s += String.format((char)('A' + i) + "%1$5.1f%%   ", 100.0*f[i]/nbAlpha);
				if( (i+1)%4==0) s += "\n";				
			}
			
			s += "\n" + new String(new char[41]).replace('\0', '=') + "\n";
			return s;
		}
		
		public int getFrequence( char c ) {
			if( c<'a' || c>'z' ) return -1;
			return f[c-'a'];
		}
		public double getFrequenceRelative( char c ) {
			if( c<'a' || c>'z' ) return -1;
			return 100.0*f[c-'a']/nbAlpha;
		}
		
		public int getnbAlpha() {
			return nbAlpha;
		}
		/*
		 * Cette méthode lit le contenu d'un fichier qui se trouve
		 * directement dans le dossier du projet et dont le nom est 
		 * reçu en paramètre.
		 * Le contenu complet du fichier est renvoyé sous la form d'une 
		 * longue chaîne. */
		//------------------------------------------------------------------------
		private static String lireFichier( String fichier ) 
		//------------------------------------------------------------------------
		{
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
		
		/* Cette méthode renvoie une chaîne formée de caractère
		 * spécifié qui répété n fois. */
		//------------------------------------------------------------------------
		private static String getLigne( int n , char c ) 
		//------------------------------------------------------------------------
		{
			return new String( new char[n] ).replace('\0', c);
		}


}
