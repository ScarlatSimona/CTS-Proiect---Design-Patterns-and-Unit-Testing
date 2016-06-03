package ro.ase.cts.state;

public class StareComandaNepreluata implements Notificare{

	@Override
	public void notifica() {
		System.out.println("Comanda nepreluata");
		
	}

}
