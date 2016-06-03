package ro.ase.cts.state;

public class StareComandaPreluata implements Notificare{

	@Override
	public void notifica() {
		System.out.println("Comanda preluata");
		
	}

}
