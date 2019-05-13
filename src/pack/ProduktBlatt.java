package pack;

/**
 * @author BingelJ Produktblatt erbt von der abstrakten Klasse Produkt und ist
 *         Teil des Kompositum-Entwurfmusters und bildet die Blaetter.
 */
public class ProduktBlatt extends Produkt {

	/**
	 * ProduktBlatt-Konstruktor, der analog zum Produkt-Konstruktor ist und ihn
	 * aufruft.
	 * 
	 * @param name   Name des Produkts
	 * @param ebene  Hierarchiestufe des Produkts
	 * @param anzahl Anzahl wie oft das jeweilige Produkt benoetigt wird
	 */
	public ProduktBlatt(String name, int ebene, int anzahl) {
		super(name, ebene, anzahl);
	}

	@Override
	public String getKlassenBezeichnung() {
		return "Produktblatt: ";
	}
}
