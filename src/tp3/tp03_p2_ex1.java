package tp3;

import java.io.*;

class StringListe 
{
	String contenu1;
	String contenu2;
	StringListe suivant;

	public StringListe(String val1,String val2,StringListe li) 
	{
		contenu1=val1;
		contenu2=val2;
		suivant=li;
	}
}

public class tp03_p2_ex1 
{
	static String ligne;
	static int curseur;

	static RandomAccessFile lecteurFichier(String chemin_fichier) throws IOException 
	{
		ligne="";
		curseur=0;
		return new RandomAccessFile(chemin_fichier,"r");
	}

	static String lireMot(RandomAccessFile lecteur) throws IOException 
	{
	    String mot;
	    int i;
	    while((curseur<ligne.length()) && ((ligne.charAt(curseur)==' ') || (ligne.charAt(curseur)=='\t'))) 
	    	curseur++;
	    if(curseur==ligne.length()) 
	    {
	      ligne=lecteur.readLine();
	      curseur=0;
	    }
	    if(ligne!=null) 
	    {
	    	for(i=curseur ; (i<ligne.length()) && (ligne.charAt(i)!=' ') && (ligne.charAt(i)!='\t') ; i++);
	    		mot=ligne.substring(curseur,i);
	      curseur=i;
	      return mot;
	    } 
	    else
	    	throw new EOFException();
	}

	static void afficheStringListe(StringListe liste) 
	{
		while(liste!=null) //Si on a au moins un element 
		{
			System.out.println("Nom : "+ liste.contenu1 + ", numéro : " + liste.contenu2);
			liste=liste.suivant;
		}
	}

	static String saisieMot() throws IOException 
	{
		BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));
		return lecteur.readLine();      
	}

	static int hash(String mot) 
  	{
		int res=0; //Resultat du hachage
	    for(int i=0 ; i<mot.length(); i++) //Parcours du mot
	    	res=(65536*res+mot.charAt(i))%65543; //Hachage
	    return res;
  	}

	static void insere(String mot,String val,StringListe[] hash_tb) 
	{
		StringListe newElem = new StringListe(mot, val, null); //Nouvel element de la table
		int posNewElem = 0;
		StringListe temp = hash_tb[0];
		while(temp.suivant != null) //Recherche du dernier element
		{
			temp=temp.suivant;
			posNewElem++;
		}
		hash_tb[posNewElem].suivant=newElem; //Ajout du nouvel element a la fin de la liste
	}

	static String recherche(String mot,StringListe[] hash_tb) 
	{
		int i=0;
		while(hash_tb[i] != null) //Tant qu'il nous reste des elements a afficher
		{
			if(hash_tb[i].contenu1==mot)
				return hash_tb[i].contenu2;
			i++;
		}
		return null;
	}

	static void afficheHashTb(StringListe[] hash_tb) 
  	{
		StringListe[] temp = hash_tb;
		int i=0;
		while(temp[i] != null) //Tant qu'il nous reste des elements a afficher
		{
			afficheStringListe(temp[i]); //Affichage d'un element
			i++;
		}
  	}

	public static void main(String[] argv) throws IOException 
	{
		StringListe[] hash_tb=new StringListe[23];
		RandomAccessFile lecteur;
		int h;
		String mot,val;
		boolean encore;
		for(h=0;h<23;h++) 
			hash_tb[h]=null;
		lecteur=lecteurFichier(argv[0]);
		try
		{
			while(true) 
			{
				mot=lireMot(lecteur);
				val=lireMot(lecteur);
				insere(mot,val,hash_tb);
			}
		} catch(EOFException e) {}
		afficheHashTb(hash_tb);
		System.out.println("(Taper q pour finir)");
		for(encore=true; encore; ) 
		{
			System.out.print("Rechercher ");
			mot=saisieMot();
			if(mot.equals("q")) encore=false;
			else 
			{
				val=recherche(mot,hash_tb);
				if(val!=null) 
					System.out.println(mot+" "+val);
				else 
					System.out.println(mot+" non trouve");
			}
		}
	}
}

