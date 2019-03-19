package pack;

/**
 * @author BingelJ ZustandFreigegeben erbt von der abstrakten Klasse Zustand und
 *         ist ein konkreter Zustand des Zustand-Entwurfmusters.
 *
 */
public class ZustandFreigegeben extends Zustand {

	/**
	 * Der Konstruktor setzt den Zustand des übergebenen Produkts auf die erstellte
	 * Instanz und weist das Produkt dem Kontext zu.
	 * 
	 * @param p Produkt, das in Kontext gespeicheret wird und dessen Zustand auf
	 *          this gesetzt wird.
	 */
	public ZustandFreigegeben(Produkt p) {
		super(p);
		p.setZustand(this);
		System.out.println("Neuer Zustand: Freigegeben");

	}

	@Override
	public void produktBearbeiten() {
		new ZustandInArbeit(this.getKontext());
	}

	@Override
	/**
	 * Zustand kann nicht gepumpt werden laut Uebergangsdiagramm.
	 */
	public void produktFreigeben() {
		System.out.println("Funktioniert nicht: Doppelte Freigabe");

	}

}
