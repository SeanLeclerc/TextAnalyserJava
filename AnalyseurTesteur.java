//============================================================================
// Programmeur: Sean
// Date: 30 nov. 2016
// Fichier: AnalyseurTesteur.java
// Description: 
//============================================================================

public class AnalyseurTesteur 
{

	public static void main(String[] args) {
		Analyseur a = new Analyseur( "texte.txt" );
		System.out.println( a.getFrequenceRelative('e') );
	}

}
