package pack;

public class ZustandFreigegeben extends Zustand {

	public ZustandFreigegeben(Produkt p) {

	}
	@Override
	public void produktBearbeiten(final Produkt p) {
		p.setZustand(new ZustandInArbeit(p));
		System.out.println("Neuer Zustand: In Arbeit");

	}
	@Override
	public void produktFreigeben(final Produkt p) {
		System.out.println("Funktioniert nicht: Doppelte Freigabe");

	}

}
