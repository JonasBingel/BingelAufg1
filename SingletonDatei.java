package pack;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// TOOD Ziel: Es soll immer nur ein Objekt gleichzeitig existieren, d.h. nur eine Methode soll gleichzeitig schreiben können;
// final verhindert, dass die Klasse eine Oberklasse sein kann
// Lazy  threadsafe oder bill pugh approach for files
// Immer nur eine Datei in "C:\\Java\\stueckliste.txt" -> mittels print-Writer speichern
// Ziel: Filelogger!

//  Es darf immer nur eine Instanz, d.h. ein Print Writer vorliegen
public final class SingletonDatei {
	private static PrintWriter writer;
	private final String FILE_NAME = "D:\\stueckliste.txt"; // "C:\\Java\\stueckliste.txt";

	private SingletonDatei() {
		try {
			FileWriter fw = new FileWriter(FILE_NAME);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Lazy threadsafe Approach, um die langsame Performance durch Synchronization
	// Overhead zu minimieren
	// Ziel: Abfrage, ob Instance schon existiert, wenn nein -> Singleton erstellen
	public static synchronized PrintWriter getInstance() {
		if (writer == null) {
			new SingletonDatei();
		}
		return writer;
	}

	public static synchronized void closeInstance() {
		writer.close();
		writer = null;
	}
}
