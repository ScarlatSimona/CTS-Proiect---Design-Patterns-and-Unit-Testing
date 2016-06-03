package ro.ase.cts.strategy;

import javafx.scene.control.Control;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;

public interface PrelucrareMeniu {
   
	public abstract void prelucrare(ComponentaMeniu listaComponente);
}
