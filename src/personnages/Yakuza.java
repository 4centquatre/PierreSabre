package personnages;

public class Yakuza extends Humain 
{
	String clan;
	int reputation;
	
	public Yakuza(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.clan = "";
		this.reputation = 0;
	}
	
	public void extorquer(Commercant victime)
	{
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int montant = victime.seFaireExtorquer();
		gagnerArgent(montant);
		reputation += 1;
		parler("J'ai piqué les " + montant + " sous de " + victime.getNom() + ", ce qui me fait " + argent + " sous dans ma poche. Hi ! Hi !");
	}
}
