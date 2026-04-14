package personnages;

public class Yakuza extends Humain 
{
	String clan;
	int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}
	
	public int getReputation()
	{
		return reputation;
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
	
	public int perdre()
	{
		reputation -= 1;
		int montant = argent;
		argent = 0;
		parler("J'ai perdu mon duel et mes "  + montant + " sous, snif... J'ai déshonoré le clan de " + clan);
		return montant;
	}
	
	public void gagner(int gain)
	{
		argent += gain;
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
}
