package pack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduktStueckliste fahrrad = new ProduktStueckliste("Fahrrad", 0, 1);
		ProduktStueckliste rad = new ProduktStueckliste("Rad", 1, 2);
		ProduktBlatt rahmen = new ProduktBlatt("Rahmen", 1, 1);
		ProduktBlatt schraubeEbene1 = new ProduktBlatt("Schraube", 1, 8);
		ProduktBlatt schraubeRad = new ProduktBlatt("Schraube", 2, 2);
		ProduktBlatt felge = new ProduktBlatt("Felge", 2, 1);

		// Baumstruktur aufbauen
		fahrrad.hinzufuegen(rad);
		fahrrad.hinzufuegen(rahmen);
		fahrrad.hinzufuegen(schraubeEbene1);
		rad.hinzufuegen(schraubeRad);
		rad.hinzufuegen(felge);

		// Drucken-Methode aufrufen
		fahrrad.drucken();
		System.out.println();

		// Liste speichern
		fahrrad.speichern();
		SingletonDatei.closeInstance();

		// Zustaende pruefen
		fahrrad.produktFreigeben();
		fahrrad.produktFreigeben();
		fahrrad.produktBearbeiten();
		fahrrad.produktBearbeiten();
		System.out.println();

		// Alle Schrauben entfernen und Drucken erneut aufrufen.
		fahrrad.entfernen("Schraube");
		fahrrad.drucken();

		// Liste speichern
		fahrrad.speichern();
		SingletonDatei.closeInstance();
	}

}
