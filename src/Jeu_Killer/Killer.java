package Jeu_Killer;
/**
 * 
 */

/**
 * @author Maxime ROUX
 * @author Dylan JACQUIN
 *
 */
public class Killer 
{

	static Tueur listTueur;
	static int nombre = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		
		listTueur = null;
		add("maxime");
		add("maelios");
		add("doudou");
		add("martin");
		if(!isEmpty()){
			afficher(listTueur);
		}
		else{
			System.out.println("aucun tueur");
		}
		
		/*Tueur listTueur;
		
		listTueur=null;
		listTueur.add("maxime");
		afficher(listTueur);
		/*if (!listTueur.isEmpty()){
			afficher(listTueur);
		}
		else{
			System.out.println("aucun tueur");
		}*/
		
		/*Tueur tueur1 = new Tueur("Vincent");
		Tueur tueur2 = new Tueur("Cedric");
		Tueur tueur3 = new Tueur("Fanch", tueur1);
		
		tueur1.setContrat(tueur2);
		tueur2.setContrat(tueur3);
		
		afficher(tueur1);*/
		//Tueur listTueur = new Tueur("Jo");
		//nombre++;
		//listTueur.add(new Tueur("martin"));
		//System.out.println(nombre);
		/*Inserer("Pascal", tueur, nombre);
		nombre++;
		for(int i=0; i<nombre; i++){
			afficher(tueur);
		}*/
		
	}
	
	public static boolean isEmpty(){
		return listTueur == null;
	}
	
	public static void add(String nom){
		if(isEmpty()){
			listTueur = new Tueur(nom);
		}
		else{
			listTueur = new Tueur(nom, listTueur);
		}
		nombre++;
	}
	
	//Affiche le nom du tueur et son contrat, prend en parametre un tueur
	public static void afficher(Tueur t)
	{
		Tueur pTueur = t;
		Tueur tmp=t.contrat;
		/*do{
			
		}while(!(pTueur.equals(t)));*/
		for(int i=0; i<nombre; i++){
			System.out.println(t.nom+" doit killer "+t.contrat.nom);
			t=tmp;
			tmp=t.contrat;
		}
	}
	
	//Insere un tueur dans la liste
	public static void Inserer(String nom, Tueur t, int n)
	{
		/*int alea = (int) Math.floor(Math.random()*n);
		alea = 0;
		if(alea==0)
		{
			t = new Tueur(nom,t);
			//Tueur newT = new Tueur(nom,t);
		}
		else
		{
			Tueur tmp;
			while(alea!=n-1)
			{
				tmp=t.contrat; //Positionnement dans la liste
			}
		}*/
		Tueur tmp = t;
		t.nom=nom;
		t.contrat=tmp;
	}
	

}
