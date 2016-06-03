package testareAplicatie;

import junit.framework.TestCase;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;
import ro.ase.cts.composite.Preparat;

public class TestGetListaComponenteMeniu extends TestCase {

	public void testGetListaComponente() throws Exception
	{
		
		ComponentaMeniu listaMeniuri=new CategorieMeniu("meniu");
		ComponentaMeniu ciorbe=new CategorieMeniu("Ciorbe");
		ComponentaMeniu preparat=new Preparat("Ciorba de vacuta", 4.5);
		ciorbe.adauga(preparat);
		
		ComponentaMeniu vegetarian=new CategorieMeniu("Vegetarian");
		
		listaMeniuri.adauga(ciorbe);
		listaMeniuri.adauga(vegetarian);
		
		Meniu meniu=new Meniu(listaMeniuri);
		assertEquals(listaMeniuri, meniu.getListaComponente());
	}
	
	
}
