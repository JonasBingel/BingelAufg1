package pack;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author BingelJ Die Klasse ist Teil der Abgabeaufgabe 1 von Prog2 und
 *         implementiert das Singleton-Lazy-Entwurfsmuster für ein
 *         PrintWriter-Objekt. Die Klasse ist final, um Vererbung zu verhindern.
 */
public final class SingletonDatei {
	// Die Klassenvariable ist die Referenzvariable für das PrintWriter-Objekt.
	private static PrintWriter writer;
	// Diese Konstante gibt den Pfad und Namen der Datei an.
	private final String FILE_NAME = "C:\\Java\\stueckliste.txt";

	/**
	 * Privater Konstruktor, sodass er nur innerhalb dieser Klasse aufgerufen werden
	 * kann. Ein neuer PrintWriter wird angelegt.
	 */
	private SingletonDatei() {
		try {
			FileWriter fw = new FileWriter(FILE_NAME);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueft, ob das PrintWriter-Objekt bereits existiert und ruft sonst den
	 * Konstruktor auf, bevor es den PrintWriter returned.
	 * 
	 * @return PrintWriter-Instanz
	 */
	public static synchronized PrintWriter getInstance() {
		if (writer == null) {
			new SingletonDatei();
		}
		return writer;
	}

	/**
	 * Die PrintWriter-Instanz wird geschlossen und der Referenzvarialbe null
	 * zugewiesen.
	 */
	public static synchronized void closeInstance() {
		writer.close();
		writer = null;
	}
}
