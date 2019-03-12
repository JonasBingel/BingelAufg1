package pack;

import java.util.*;

/**
 * @author BingelJ Die Produkt-Stuecklistklasse erbt von der abstrakten Klasse
 *         Produkt und ist Teil des Kompositum-Entwurfmusters und bildet die
 *         Knoten.
 *
 */
public class ProduktStueckliste extends Produkt {

	private List<Produkt> stueckliste;

	/**
	 * ProduktStueckliste-Konstruktor, der drei Attribute erwartet mit denen der
	 * Super Konstruktor aufgerufen wird. Zudem wird eine neue ArrayListe erstellt,
	 * der andere Produkte zugewiesen werden koennen.
	 * 
	 * @param name   Name des Produkts
	 * @param ebene  Hierarchiestufe des Produkts
	 * @param anzahl Anzahl wie oft das jeweilige Produkt benoetigt wird
	 */
	public ProduktStueckliste(String name, int ebene, int anzahl) {
		super(name, ebene, anzahl);
		this.stueckliste = new ArrayList<>();
	}

	@Override
	/**
	 * Ueberschriebene hinzufuegen-Methode. Der ArrayListe wird das uebergebene
	 * Produkt hinzugefuegt.
	 */
	public void hinzufuegen(Produkt p) {
		this.stueckliste.add(p);
	}

	@Override
	/**
	 * Ueberschriebene entfernen-Methode Es wird ein ListIterator der Arraylist
	 * erstellt und durchlaufen, solange noch ein Element im Iterator ist. Das
	 * naechste Iteratorelement wird zwischengespeichert und abhaengig von Typ wird
	 * entfernen rekursiv oder die Array-Methode .remove aufgerufen, um das
	 * jeweilige Produkt zu entfernen.
	 **/
	public void entfernen(String produktMussWeg) {
		ListIterator<Produkt> stuecklisteIterator = stueckliste.listIterator();
		while (stuecklisteIterator.hasNext()) {
			Produkt nextElement = stuecklisteIterator.next();
			// nur um Exception handling zu ermoeglichen, sonst ist hier kein if notwendig
			if (nextElement instanceof ProduktStueckliste) {
				nextElement.entfernen(produktMussWeg);
			}
			if (nextElement.getName().equals(produktMussWeg)) {
				stuecklisteIterator.remove();
			}
		}
	}

	@Override
	/**
	 * Ueberschriebene Drucken-Methode, die zunächst drucken der Oberklasse aufruft
	 * und danach alle Elemente der stueckliste durchlaeuft und rekursiv drucken
	 * aufruft.
	 * 
	 */
	public void drucken() {
		super.drucken();
		for (Produkt p : this.stueckliste) {
			p.drucken();
		}

	}

	@Override
	public String getKlassenBezeichnung() {
		return "Stueckliste: ";
	}

	@Override
	/**
	 * Ueberschriebene Speichern-Methode. Zunaechst wird die Instanz, die die
	 * Methode aufruft in die Datei geschrieben. Danach wird fuer jedes Produkt in
	 * der Stueckliste speichern aufgerufen.
	 */
	public void speichern() {
		try {
			SingletonDatei.getInstance().println(this.berechneTabs() + this.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Produkt p : this.stueckliste) {
			p.speichern();
		}

	}
}
