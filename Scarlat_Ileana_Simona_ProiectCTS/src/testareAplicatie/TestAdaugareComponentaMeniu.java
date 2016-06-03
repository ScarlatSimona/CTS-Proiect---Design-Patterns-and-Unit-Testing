package testareAplicatie;

import java.util.ArrayList;

import junit.framework.TestCase;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Preparat;

public class TestAdaugareComponentaMeniu extends TestCase {
	
	ArrayList listaComponente;
	ComponentaMeniu componenta;
	
	public static final String denumireCategorieInitiala="Meniu";

	public TestAdaugareComponentaMeniu(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("Pregatire test");
		listaComponente=new ArrayList<>();
		componenta=new CategorieMeniu(denumireCategorieInitiala);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Terminare test");
		listaComponente=null;
	}
	
	public void testAdaugareCategorieDenumireNula()
	{
		String denumireCategorie=null;
		try{
		    ComponentaMeniu ciorbe=new CategorieMeniu(denumireCategorie);
		    componenta.adauga(ciorbe);
		    fail("Metoda nu arunca exceptie pentru o categorie cu denumire nula");
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void testAdaugareCategorieNula()
	{
		ComponentaMeniu element=null;
		try
		{
			componenta.adauga(element);
			fail("Metoda nu arunca o exceptie pentru o categorie nula");
		}catch(UnsupportedOperationException ex)
		{
			
		}
		
	}
	public void testValoriNormaleAdaugarePreparatInCategorie()
	{
		
		try
		{
			ComponentaMeniu preparat=new Preparat("Ciorba de vacuta", 4.5);
			componenta.adauga(preparat);
			assertTrue(componenta.getDenumirePreparat()=="Ciorba de vacuta");
			assertTrue(componenta.getPretPreparat()==4.5);
		}catch(UnsupportedOperationException ex)
		{
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testValoriNuleAdaugarePreparatInCategorie()
	{
		try
		{
			ComponentaMeniu preparat=new Preparat(null, 0);
			componenta.adauga(preparat);
			fail("Metoda nu arunca o exceptie pentru adaugarea unui preparat cu valori nule");
		}catch(Exception ex)
		{
			
		}
	}

}
