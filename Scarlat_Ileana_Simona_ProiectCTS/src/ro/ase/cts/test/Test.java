package ro.ase.cts.test;

import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;
import ro.ase.cts.composite.Preparat;
import ro.ase.cts.state.ModificareStareComanda;
import ro.ase.cts.state.Notificare;
import ro.ase.cts.state.StareComanda;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//test COMPOSITE
		ComponentaMeniu ciorbe=new CategorieMeniu("Ciorbe");
		ComponentaMeniu vegetarian=new CategorieMeniu("Vegetarian");
		
		ComponentaMeniu listaMeniuri=new CategorieMeniu("Meniu");
		listaMeniuri.adauga(ciorbe);
		 ComponentaMeniu preparat=new Preparat("Ciorba de vacuta", 4.5);
		ciorbe.adauga(preparat);
		listaMeniuri.adauga(vegetarian);
		
		ciorbe.sterge(preparat);
		
		//listaMeniuri.sterge(ciorbe);
		Meniu meniuDisponibil=new Meniu(listaMeniuri);
		meniuDisponibil.afiseazaComponente();
		
		
		
	}

}
