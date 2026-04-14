package histoire;

import personnages.*;

public class HistoireTP4 
{
	public static void main(String[] args) 
	{
		System.out.println("Test Humain");
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("boisson", 12);
		prof.boire();
		prof.acheter("jeu", 2);
		prof.acheter("kimono", 50);
		
		System.out.println("Test Commercant");
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		
		System.out.println("Test Yakuza");
		Yakuza yakulenoir = new Yakuza("Yaku Le Noir", "whisky", 30);
		yakulenoir.direBonjour();
		yakulenoir.extorquer(marco);
		
		System.out.println("Test Ronin");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		roro.donner(marco);
	}
}
