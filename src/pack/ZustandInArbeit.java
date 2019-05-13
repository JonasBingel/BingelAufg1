package pack;

/**
 * @author BingelJ ZustandInArbeit erbt von der abstrakten Klasse Zustand und
 *         ist ein konkreter Zustand des Zustand-Entwurfmusters.
 */
public class ZustandInArbeit extends Zustand {

	/**
	 * Der Konstruktor setzt den Zustand des übergebenen Produkts auf die erstellte
	 * Instanz und weist das Produkt dem Kontext zu.
	 * 
	 * @param p Produkt, dessen Zustand angepasst werden soll.
	 */
	public ZustandInArbeit(Produkt p) {
		super(p);
		p.setZustand(this);
		System.out.println("Neuer Zustand: In Arbeit");

	}

	@Override
	/**
	 * Zustand wird gepumpt, d.h. bleibt in ZustandInArbeit und erzeugt eine
	 * Konsolenausgaben.
	 */
	public void produktBearbeiten() {
		System.out.println("Funktioniert: In Arbeit bleibt");

	}

	@Override
	/**
	 * Zustand wird geaendert in ZustandFreigegeben durch Aufruf des Konstruktors
	 * des konkreten Zustands.
	 */
	public void produktFreigeben() {
		new ZustandFreigegeben(this.getKontext());
	}

}
