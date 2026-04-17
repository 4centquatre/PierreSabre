package personnages;

public class Humain 
{
	protected String nom;
	protected String boisson;
	protected int argent;
	protected int nbConnaissance;
	protected Humain[] memoire;
	
	public Humain(String nom, String boisson, int argent) 
	{
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
		this.nbConnaissance = 0;
		this.memoire = new Humain[30];
	}

	public String getNom() 
	{
		return nom;
	}
	
	public String getBoisson()
	{
		return boisson;
	}

	public int getArgent() 
	{
		return argent;
	}
	
	public void gagnerArgent(int montant)
	{
		this.argent += montant;
	}
	
	public void perdreArgent(int montant)
	{
		this.argent -= montant;
	}
	
	protected void parler(String texte)
	{
		System.out.println("(" + getNom() + ") - " + texte);
	}
	
	public void direBonjour()
	{
		parler("Bonjour ! Je m'apelle " + getNom() + " et j'aime boire du " + getBoisson());
	}
	
	public void boire()
	{
		parler("Mmmm, un bon verre de " + getBoisson() + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix)
	{
		if(prix < getArgent())
		{
			parler("J'ai " + getArgent() + " sous en poche. Je vais pouvoir m'offrir un(e) " + bien + " à " + prix + " sous.");
			this.perdreArgent(prix);
		}
		else
		{
			parler("Je n'ai plus que " + getArgent() + " sous en poche. Je ne peux même pas m'offrir un(e) " + bien + " à " + prix + " sous.");
		}
	}
	
	@Override
	public String toString() {
		return "habitant";
	}

	protected void memoriser(Humain humain)
	{
		if(nbConnaissance < memoire.length)
		{
			this.memoire[nbConnaissance] = humain;
			nbConnaissance++;
			
		}
		else
		{
			for(int i = 0; i < nbConnaissance - 1; i++)
			{
				this.memoire[i] = this.memoire[i+1];
			}
			this.memoire[nbConnaissance - 1] = humain;
		}
	}
	
	public void faireConnaissanceAvec(Humain humain)
	{
		this.direBonjour();
		humain.direBonjour();
		this.memoriser(humain);
		humain.memoriser(this);
	}
	
	public void listerConnaissance()
	{
		String chaine = "Je connais beaucoup de monde dont : ";
		for(int i = 0; i < nbConnaissance ; i++)
		{
			chaine += memoire[i].getNom() + ", ";
		}
		parler(chaine);
	}
}




















