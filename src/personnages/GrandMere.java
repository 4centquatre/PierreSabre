package personnages;

import java.util.Random;

public class GrandMere extends Humain
{
	Random random = new Random();
	
	public GrandMere(String nom, int argent) 
	{
		super(nom, "tisane", argent);
		this.memoire = new Humain[5]; 
	}
	
	private enum TypeHumain
	{
		HUMAIN("un habitant"),
		COMMERCANT("un commercant"),
		RONIN("un ronin"),
		SAMOURAI("un samourai"),
		YAKUZA("un yakuza"),
		GRANDMERE("une grand-mère");
		
		private String nom;
		
		TypeHumain(String nom)
		{
			this.nom = nom;
		}
		
		public String getNom()
		{
			return this.nom;
		}
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
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}
	
	private String humainHasard()
	{
		TypeHumain[] types = TypeHumain.values();
		int indice = random.nextInt(types.length);
		return types[indice].getNom();
	}
	
	public void ragoter()
	{
		for(int i = 0; i < nbConnaissance; i++)
		{
			Humain humain = this.memoire[i];
			if(humain instanceof Traitre)
			{
				parler("Je sais que " + humain.getNom() + " est un traître. Petit chenapan !");
			}
			else
			{
				String typeHumain = humainHasard();
				parler("Je crois que " + humain.getNom() + " est " + typeHumain);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Grand-Mere";
	}
}
