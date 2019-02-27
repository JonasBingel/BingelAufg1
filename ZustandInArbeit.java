package pack;

public class ZustandInArbeit extends Zustand {
	public ZustandInArbeit(Produkt P) {

	}
	@Override
	public void produktBearbeiten(final Produkt p) {
		System.out.println("Funktioniert: In Arbeit bleibt");

	}

	public void produktFreigeben(final Produkt p) {
		p.setZustand(new ZustandFreigegeben(p));
		System.out.println("Neuer Zustand: Freigegeben");

	}

}
