package pack;

public class ProduktBlatt extends Produkt {

	public ProduktBlatt(String name, int ebene, int anzahl) {
		super(name, ebene, anzahl);
	}

	public void drucken() {
		super.drucken();
	}
	@Override
	public String getKlassenBezeichnung() {
		return "Produktblatt: ";
	}
}
