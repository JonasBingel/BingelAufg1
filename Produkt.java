package pack;

/**
 * @author BingelJ Die abstrakte Produkt-Klasse ist Teil des
 *         Kompositum-Entwurfmusters.
 *
 */
public abstract class Produkt {
	private String name;
	private int ebene;
	private int anzahl;
	private Zustand zustand;

	/**
	 * Produkt-Konstruktor, jedes Produkt hat vier Attribute, von denen drei
	 * angegeben werden muessen. Nur der Gesamt-Produktstuecklist, d.h. Ebene 0 wird
	 * ZustandInArbeit zugewiesen.
	 * 
	 * @param name   Name des Produkts
	 * @param ebene  Hierarchiestufe des Produkts
	 * @param anzahl Anzahl wie oft das jeweilige Produkt benoetigt wird
	 *
	 */
	public Produkt(String name, int ebene, int anzahl) {
		this.name = name;
		this.ebene = ebene;
		this.anzahl = anzahl;
		if (this.ebene == 0) {
			zustand = new ZustandInArbeit(this);
		}

	}

	/**
	 * Standard-Implementierung der Speichern-Methode, die das Produkt eingerueckt
	 * in die von SingletonDatei verwaltete Datei schreibt. Exception-Handling, da
	 * IO verwendet wird.
	 */
	public void speichern() {
		try {
			SingletonDatei.getInstance().println(this.berechneTabs() + this.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Standard-Implementierung der entfernen-Methode, die eine Exception wirft, da
	 * nur Produktstuecklisten diese Methode verwenden können sollen.
	 * 
	 * @param produktMussWeg Name des Produkts, das entfernt werden soll.
	 */
	public void entfernen(String produktMussWeg) {
		try {
			throw new Exception("Kann nur auf Produkt-Stuecklisten angewendet werden.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Standard-Implementierung der hinzufuegen-Methode, die zunaechst nicht weiter
	 * implementiert ist.
	 * 
	 * @param p Produkt, das hinzugefuegt werden soll.
	 */
	public void hinzufuegen(Produkt p) {
	}

	/**
	 * produktFreigeben aendert den Zustand des Produkts in ZustandFreigegeben.
	 */
	public void produktFreigeben() {
		this.zustand.produktFreigeben();
	}

	/**
	 * produktBearbeiten aendert den Zustand des Produkts in ZustandInArbeit.
	 */
	public void produktBearbeiten() {
		this.zustand.produktBearbeiten();
	}

	/**
	 * Methode gibt die geforderten Informationen eingerueckt auf der Konsole auf.
	 * Die getKlassenBezeichnung() wird verwendet, um Redundanz zu vermeiden.
	 */
	public void drucken() {
		System.out.println(this.berechneTabs() + this.getKlassenBezeichnung() + this.toString());
	}

	/**
	 * Methode liefert eine Klassenbezeichnung, die bspw. in toString verwendet
	 * wird.
	 * 
	 * @return String Klassenbezeichnung
	 */
	public abstract String getKlassenBezeichnung();

	/**
	 * Methode liefert das Padding für ein Produkt, das anhand der Ebene berechnet
	 * wird.
	 * 
	 * @return Padding, d.h. String mit bestimmter Anzahl von Blanks entsprechend
	 *         der Hierarchiestufe
	 */
	public String berechneTabs() {
		if (ebene > 0) {
			return String.format("%" + (ebene * 4) + "s", " ");
		}
		return "";
	}

	@Override
	/**
	 * Methode liefert einen String, der anzahl und Name des Produkts enthaelt.
	 * 
	 * @return String mit noetigen Informationen, nach Arbeitsauftrag formatiert.
	 */
	public String toString() {
		return (anzahl + " x " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEbene() {
		return ebene;
	}

	public void setEbene(int ebene) {
		this.ebene = ebene;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public void setZustand(Zustand zustand) {
		this.zustand = zustand;
	}

}
