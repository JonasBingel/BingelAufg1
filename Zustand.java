package pack;

/**
 * @author BingelJ Abstrakte Klasse Zustand, die Teil des Zustand-Entwurfmusters
 *         ist und die Methoden f�r die konkreten Zust�nde vorgibt.
 */
public abstract class Zustand {

	/**
	 * Zustand wird geaendert in ZustandFreigegeben durch Aufruf des Konstruktors des konkreten Zustands.
	 */
	public abstract void produktFreigeben();

	/**
	 * Zustand wird geaendert in ZustandInArbeit durch Aufruf des Konstruktors des konkreten Zustands.
	 */
	public abstract void produktBearbeiten();

}
