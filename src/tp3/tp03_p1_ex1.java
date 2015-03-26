package tp3;

import java.io.*;

class Pile 
{
	int contenu;
	Pile suivant;
	public Pile(int val,Pile st) 
	{
		contenu=val;
    	suivant=st;
	}
}

class StringPasReconnue extends Exception 
{
	StringPasReconnue() 
	{
		super();
	}
}

public class tp03_p1_ex1 
{

	static Pile empile(int val,Pile st) 
	{
		Pile tmp = new Pile(val,st); //Creation d'une pile avec val en premier element, et st en suite
		return tmp;
	}

	static void affichePile(Pile st) 
	{
		if(st != null)
		{
			while(st.suivant!=null) //Tant qu'il y a des elements restant
			{
				System.out.println(st.contenu); //Affichage du contenu
				st = st.suivant; //PAssage a l'element suivant
			}
			System.out.println(st.contenu); //Affichage du dernier element
		}
	}

	static Pile funAdd(Pile st) 
	{
		if(st.suivant == null) //Si on a qu'un seul element
			return st; //On sort de la fonction
		int nb1 = st.contenu; //Recuperation du premier element
		st=st.suivant; //Element suivant
		int nb2 = st.contenu; //Recuperation du deuxieme element
		st=st.suivant; //Element suivant
		st=empile(nb1+nb2, st); //Empile le nouvel element en additionnant nb1 et nb2
		return st;
	}

	static Pile funSUB(Pile st) 
	{
		if(st.suivant == null) //Si on a qu'un seul element
			return st; //On sort de la fonction
		int nb1 = st.contenu; //Recuperation du premier element
		st=st.suivant; //Element suivant
		int nb2 = st.contenu; //Recuperation du deuxieme element
		st=st.suivant; //Element suivant
		st=empile(nb2-nb1, st); //Empile le nouvel element en soustrayant nb1 et nb2
		return st;
	}

	static Pile funMUL(Pile st) 
	{
		if(st.suivant == null) //Si on a qu'un seul element
			return st; //On sort de la fonction
		int nb1 = st.contenu; //Recuperation du premier element
		st=st.suivant; //Element suivant
		int nb2 = st.contenu; //Recuperation du deuxieme element
		st=st.suivant; //Element suivant
		st=empile(nb1*nb2, st); //Empile le nouvel element en multipliant nb1 et nb2
		return st;
	}

	static Pile funDIV(Pile st) 
	{
		if(st.suivant == null) //Si on a qu'un seul element
			return st; //On sort de la fonction
		int nb1 = st.contenu; //Recuperation du premier element
		st=st.suivant; //Element suivant
		int nb2 = st.contenu; //Recuperation du deuxieme element
		st=st.suivant; //Element suivant
		st=empile(nb2/nb1, st); //Empile le nouvel element en divisant nb1 et nb2
		return st;
	}

	static Pile funDSP(Pile st) 
	{
		affichePile(st);
		System.out.println();
		return st;
	}

	public static void main(String[] argv) throws StringPasReconnue 
	{
		Pile st=null;
		int i;
		String[] tmp =  {"1","2","ADD","4","MUL","6","DIV","2","SUB"};
		argv=tmp;
		for(i=0; i<argv.length; i++) 
		{
			try 
			{
				st=empile(Integer.parseInt(argv[i]),st);
			} 
			catch (NumberFormatException e) 
			{
				if(argv[i].equalsIgnoreCase("ADD")) st=funAdd(st);
				else if(argv[i].equalsIgnoreCase("SUB")) st=funSUB(st);
				else if(argv[i].equalsIgnoreCase("MUL")) st=funMUL(st);
				else if(argv[i].equalsIgnoreCase("DIV")) st=funDIV(st);
				else if(argv[i].equalsIgnoreCase("DSP")) st=funDSP(st);
				else throw new StringPasReconnue();
			}
		}
		affichePile(st);
	}
}
