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
	}
}
