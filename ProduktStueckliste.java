package pack;

import java.util.*;

public class ProduktStueckliste extends Produkt {

	private ArrayList<Produkt> stueckliste;

	public ProduktStueckliste(String name, int ebene, int anzahl) {
		super(name, ebene, anzahl);
		this.stueckliste = new ArrayList<>();
	}

	public void hinzufuegen(Produkt p) {
		this.stueckliste.add(p);
	}

	public void entfernen(String produktMussWeg) {
		ListIterator<Produkt> stuecklisteIterator = stueckliste.listIterator();
		while (stuecklisteIterator.hasNext()) {
			Produkt nextElement = stuecklisteIterator.next();
			nextElement.entfernen(produktMussWeg);
			if (nextElement.getName().equals(produktMussWeg)) {
				stuecklisteIterator.remove();
			}
		}
	}

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

	public void speichern() {
		try {
			SingletonDatei.getInstance().println(this.berechneTabs() + this.toString());
			// System.out.println(this.berechneTabs() + this.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Produkt p : this.stueckliste) {
			p.speichern();
		}

	}
}
