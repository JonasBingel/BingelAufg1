package pack;

// TODO getKlasse implementieren für Drucken-Methode, Zustand noch implementieren, schauen, ob speichern so richtig ist, entfernen der closeInstance. aufrufe
// TODO implement java try with resources?
import java.io.*;

public abstract class Produkt {
	private String name;
	private int ebene;
	private int anzahl;
	private Zustand zustand;

	public Produkt(String name, int ebene, int anzahl) {
		this.name = name;
		this.ebene = ebene;
		this.anzahl = anzahl;
		if (this.ebene == 0) {
			this.zustand = new ZustandInArbeit(this);
		}

		// Zustand initialisieren?
		// laut F4 nur ZustandINArbeit(this) an Klasse übergeben
	}

	public void speichern() {
		try {
			SingletonDatei.getInstance().println(this.berechneTabs() + this.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void entfernen(String produktMussWeg) {
		// eventuell abstrakt

	}

	public void produktFreigeben() {
		this.zustand.produktFreigeben(this);
	}

	public void produktBearbeiten() {
		this.zustand.produktBearbeiten(this);
		zustand = new ZustandInArbeit(this);
	}

	public void drucken() {
		System.out.println(this.berechneTabs() + this.getKlassenBezeichnung() + this.toString());
	}

	public abstract String getKlassenBezeichnung();

	public String berechneTabs() {
		if (ebene > 0) {
			return String.format("%" + (ebene * 4) + "s", " ");
		}
		return "";
	}

	@Override
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
