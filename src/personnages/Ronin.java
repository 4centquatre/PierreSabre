package personnages;

public class Ronin extends Humain
{
	private int honneur;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.honneur = 1;
	}
	
	public void donner(Commercant beneficiaire)
	{
		int montant = argent / 10;
		parler(beneficiaire.getNom() + " prend ces " + montant + " sous");
		beneficiaire.recevoir(montant);
		perdreArgent(montant);
	}
	
	public void provoquer(Yakuza adversaire)
	{
		int force = honneur * 2;
		if(force >= adversaire.getReputation())
		{
			gagnerArgent(adversaire.getArgent());
			honneur += 1;
			parler("Je t'ai eu petit yakuza !");
			adversaire.perdre();
		}
		else
		{
			honneur -= 1;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
		}
	}
}
