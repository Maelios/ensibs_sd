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
	/**
	 * fonction principale du programme
	 * le main est le programme qui sera exécuter lorsque la compilation du programme sera OK
	 * @param args
	 */
	public static void main(String[] args){
		/*//Création de deux tueurs, pour cela on se sert du constructeur de la class tueur
		Tueur tueur1 = new Tueur("Maxou");
		Tueur tueur2 = new Tueur("Dydy");
		//on assigne comme contrat au tueur1 le tueur 2
		tueur1.setContrat(tueur2);
		//on créé un nouveau tueur avec le deuxième constructeur
		Tueur tueur3 = new Tueur("Doudou", tueur1);
		//enfin on assigne au tueur 2 le tueur 3 afin de créer une boucle fermée
		tueur2.setContrat(tueur3);
		affiche(tueur2);*/
		
		//on créé une liste T1 de tueur
		//on ajoute aléatoirement les nouveaux tueurs 
		//on oublie pas d'incrémenter le nombre d'élément
		//à l'origine il "s'autoincrémenté" mais problème de static quand il y a plus d'une liste de tueur
		Tueur T1 = new Tueur("Maxou");
		T1.setContrat(T1);
		int nb1=1;
		inserer("Doudou", T1, nb1);
		nb1++;
		inserer("Fanfan", T1, nb1);
		nb1++;
		inserer("Vincent", T1, nb1);
		nb1++;
		inserer("Didou", T1, nb1);
		nb1++;
		/*System.out.println("T1---------------------");
		affiche(T1);*/
		//System.out.println(nb1);
		//Création de la deuxième liste de Tueur
		Tueur T2 = new Tueur("Dydy");
		T2.setContrat(T2);
		int nb2=1;
		inserer("Benjamin", T2, nb2);
		nb2++;
		inserer("Fanch", T2, nb2);
		nb2++;
		inserer("Aaa", T2, nb2);
		nb2++;
		inserer("Brahim", T2, nb2);
		nb2++;
		/*System.out.println("T2-------------------");
		affiche(T2);
		System.out.println(nb2);
		System.out.println("_________________________");*/
		insererListe(T1, nb2, T2, nb2);
		nb1=nb1+nb2;
		nb2=nb1;
		/*System.out.println("T1 dans T2");
		System.out.println("T1");
		affiche(T1);
		System.out.println("---------------------");
		System.out.println("T2");
		affiche(T2);*/
		affiche(T1);
		System.out.println("_________________________");
		partie(T1);

		
		
	}
	
	/**
	 * Méthode affiche qui permet d'afficher la liste des tueurs et leur contrat
	 * @param t un tueur
	 */
	public static void affiche(Tueur t){
		System.out.println(t.nom+" doit kill "+t.contrat.nom);
		Tueur ctra = t.contrat;
		while(ctra!=t){
			System.out.println(ctra.nom+" doit kill "+ctra.contrat.nom);
			ctra=ctra.contrat;
		}
	}
	
	public static void inserer(String nom, Tueur T1, int nombre){
		//on génère un nombre aléatoire 
		int alea = (int)Math.floor(Math.random()*nombre);
		/*Débug
		 * System.out.println(alea);
		affiche(T1);
		System.out.println("tueur a inséré : "+nom);
		System.out.println("---------------------------------");*/
		//on garde garde en mémoire la tête de la liste
		Tueur tmpTueur = T1;
		Tueur tmpCtra = T1.contrat;
		//on parcours notre liste jusqu'a atteindre notre position
		for(int i=0;i<=alea;i++){
			//Si on est arrivé à la position aléatoire on insère notre nouveau tueur
			if(i==alea){
				tmpTueur.setContrat(new Tueur(nom, tmpCtra));
			}
			//sinon on prend le tueur suivant
			else{
				tmpTueur = tmpCtra;
				tmpCtra = tmpCtra.contrat;
			}
		}
		/*Débug
		 * affiche(T1);
		System.out.println("_________________________________");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static void insererListe(Tueur T1, int nb1, Tueur T2, int nb2){
		//System.out.println("nb2 : "+nb1);
		int alea = (int)Math.floor(Math.random()*nb1);
		//on sauvegarde les deux têtes de liste
		Tueur tmpTueur = T1;
		Tueur tmpCtra = T1.contrat;
		Tueur tmp2Tueur = T2;
		Tueur tmp2Ctra = T2.contrat;
		//on parcours notre liste jusqu'a atteindre notre position
		for(int i=0;i<=alea;i++){
			//Si on est arrivé à la position aléatoire on insère notre liste de tueur
			if(i==alea){
				//le tueur de la Liste 1 prend comme contrat la tête de la Liste 2
				tmpTueur.setContrat(tmp2Tueur);
				//on parcours toutes la liste 2 pour atteindre le dernier tueur
				for(int j=1;j<nb2-1;j++){
					tmp2Tueur=tmp2Ctra;
					tmp2Ctra=tmp2Ctra.contrat;
				}
				//on affecter au dernier tueur de la liste 2 le contrat du tueur de la liste 1
				tmp2Ctra.setContrat(tmpCtra);
			}
			//sinon on prend le tueur suivant de la Liste 1
			else{
				tmpTueur = tmpCtra;
				tmpCtra = tmpCtra.contrat;
			}
		}
	}
	
	public static void partie(Tueur T1){
		Tueur lastKiller=T1;
		int nbJ = 1;
		Tueur ctra = T1.contrat;
		while(ctra!=T1){
			nbJ++;
			ctra=ctra.contrat;
		}
		int nbJtotal=nbJ;
		String tab[]=new String[nbJtotal];
		int tab2[]=new int[nbJtotal];
		int indice = 0;
		int alea = 0;
		while(nbJ!=1){
			alea = (int)Math.floor(Math.random()*nbJ);
			Tueur tmpTueur = T1;
			Tueur tmpCtra = T1.contrat;
			for(int i=0;i<=alea;i++){
				//Si on est arrivé à la position aléatoire on insère notre nouveau tueur
				if(i==alea){
					if(tmpTueur.nom!=tmpCtra.nom){
						//si la tête se fait tuer
						if(T1==tmpCtra){
							
							T1=tmpTueur;
						}
						System.out.println(tmpTueur.nom+" a tué "+tmpTueur.contrat.nom);
						//avant de mourrir on stock dans un tableau le nom du joueur et son nombre de kill
						tab[indice]=tmpTueur.contrat.nom;
						tab2[indice]=tmpTueur.contrat.nbKill;
						indice++;
						tmpCtra = tmpTueur.contrat;
						tmpTueur.contrat=tmpCtra.contrat;
						tmpTueur.nbKill++;
						nbJ--;
						
						
					}
				}
				//sinon on prend le tueur suivant
				else{
					tmpTueur = tmpCtra;
					tmpCtra = tmpCtra.contrat;
				}
			}
			tab[indice]=tmpTueur.nom;
			tab2[indice]=tmpTueur.nbKill;
			lastKiller=tmpTueur;
			
		}
		System.out.println("le survivant est : "+lastKiller.nom+", son nombre de kill est de "+lastKiller.nbKill);
		Tueur bestKiller=T1;
		//on compare tous les kill de chaque joueur et on garde a chaque fois celui qui a le plus grand nombre de kill
		for(int z=0; z<nbJtotal; z++){
			//System.out.println("nom : "+tab[z]+" nb kill:"+tab2[z]);
			if(bestKiller.nbKill<tab2[z]){
				bestKiller.nom=tab[z];
				bestKiller.nbKill=tab2[z];
				bestKiller.contrat=null;	
			}
		}
		
		System.out.println("Le meilleur killer est "+bestKiller.nom+", avec "+bestKiller.nbKill+" kill!");
		
	}
	
}
class Tueur{
	//Déclaration de deux variables
	//la première permet de stocker le nom du tueur
	//la deuxième contient l'objet tueur, le tueur que ce dernier doit tuer
	public String nom;
	public Tueur contrat;
	public int nbKill;
	//public static int nombre = 0;
	
	/**
	 * constructeur Tueur qui permet de créer un nouveau constructeur
	 * @param nomT le nom du tueur
	 */
	public Tueur(String nomT){
		this.nom = nomT;
		this.contrat = null;
		//this.nombre++;
		this.nbKill=0;
	}
	
	/**
	 * constructeur qui permet de créer un nouveau Tueur avec un nom et un contrat
	 * @param nomT nom du nouveau tueur
	 * @param aTuer contrat du tueur
	 */
	public Tueur(String nomT, Tueur aTuer){
		this.nom = nomT;
		this.contrat = aTuer;
		//this.nombre++;
		this.nbKill=0;
	}
	
	/**
	 * méthode setContrat qui prends en paramètre un tueur à tuer et qui permet
	 * de définir le contrat du tueur
	 * @param t
	 */
	public void setContrat(Tueur t){
		this.contrat = t;
	}
	
}
