package testareAplicatie;

import junit.framework.TestCase;
import ro.ase.cts.singletonfacadefactorybuilder.BuilderComanda;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;

  

public class TestBuilderComanda extends TestCase {

	Comanda comanda;
	public static final String cod = "1256";
	public static final String preparateComandate="Ciorba de vacuta, Prajituri";
	public static final double pretTotal=35.4;
	public static final int nrMasa=25;
	
	
	public TestBuilderComanda(String name) throws Exception {
		super(name);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("Pregatire test");
		comanda=new BuilderComanda(cod)
				.setMasa(nrMasa)
				.setPreparateComandate(preparateComandate)
				.setPretTotal(pretTotal)
				.build();
	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Terminare test");
		this.comanda=null;
	}
	
	public void testBuilderComandaCodGresit()
	{
		String codGresit="K456";
		try
		{
		comanda=new BuilderComanda(codGresit)
				.setMasa(nrMasa)
				.setPreparateComandate(preparateComandate)
				.setPretTotal(pretTotal)
				.build();
		fail("Metoda nu arunca exceptie pentru un cod gresit");
		}catch(Exception ex)
		{
			
		}	
	}
	
	

}
