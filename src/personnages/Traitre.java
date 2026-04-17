package personnages;

import java.util.Random;

public class Traitre extends Samourai
{
	private int traitrise;
	
	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
		this.traitrise = 0;
	}
	
	@Override
	public void direBonjour()
	{
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est de " + traitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant)
	{
		if(traitrise < 3)
		{
			int argentRanconner = commercant.getArgent() * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			traitrise++;
			this.parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + this.getNom() + ".");
		}
		else
		{
			parler("Mince je ne peux plus ranconner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil()
	{
		if(nbConnaissance < 1)
		{
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
		else
		{
			Random random = new Random();
			Humain ami = memoire[random.nextInt(nbConnaissance)];
			int don = argent * 1 / 20;
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			this.perdreArgent(don);
			ami.parler("Merci " + this.getNom() + ". Vous êtes quelqu'un de bien.");
			
			if(traitrise > 1)
			{
				traitrise--;
			}
		}
	}
	
	@Override
	public String toString() {
		return "traitre";
	}
}
