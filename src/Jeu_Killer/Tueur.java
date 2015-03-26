package Jeu_Killer;

/**
 * @author Maxime ROUX
 * @author Dylan JACQUIN
 *
 */
public class Tueur 
{
	public String nom;
	public Tueur contrat;
	
	//Constructeur de la classe, prend en parametre le nom du la personne a tuer
	Tueur(String n)
	{
		nom=n;
		contrat=this;
	}
	
	//Constructeur de la classe, prend en parametre le et le nouveau tueur a tuer
	Tueur(String n, Tueur t)
	{
		nom=n;
		setContrat(t);
	}
		
	//Donne un contrat, prend en paramètre le nouveau tueur a tuer
	public void setContrat(Tueur t)
	{
		contrat=t;
	}
}
