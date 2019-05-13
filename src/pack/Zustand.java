package pack;

/**
 * @author BingelJ Abstrakte Klasse Zustand, die Teil des Zustand-Entwurfmusters
 *         ist und die Methoden für die konkreten Zustände vorgibt.
 */
public abstract class Zustand {
	private Produkt kontext;

	/**
	 * Uebergabe eines Produkts p, das dem Kontext zugewiesen wird.
	 * 
	 * @param p: Produkt, das im Attribut Kontext verwaltet wird.
	 */
	public Zustand(Produkt p) {
		kontext = p;
	}

	/**
	 * Zustand wird geaendert in ZustandFreigegeben durch Aufruf des Konstruktors
	 * des konkreten Zustands.
	 */
	public abstract void produktFreigeben();

	/**
	 * Zustand wird geaendert in ZustandInArbeit durch Aufruf des Konstruktors des
	 * konkreten Zustands.
	 */
	public abstract void produktBearbeiten();

	public Produkt getKontext() {
		return kontext;
	}

}
