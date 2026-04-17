package personnages;

public class Commercant extends Humain
{
	public Commercant(String nom, int argent) 
	{
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer()
	{
		int montant = super.argent;
		argent = 0;
		parler("J'ai tout perdu ! Le monde est vraiment injuste...");
		return montant;
	}
	
	public void recevoir(int argent)
	{
		parler(argent + " sous ! Je te remercie généreux donateur !");
		gagnerArgent(argent);
	}
	
	@Override
	public String toString() {
		return "commercant";
	}
}
