package testareAplicatie;

import java.io.BufferedReader;
import java.io.FileReader;

import junit.framework.TestCase;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;
import ro.ase.cts.composite.Preparat;

     
public class TestCitireFisierMeniu extends TestCase {
	FileReader reader;
	BufferedReader bf;
	ComponentaMeniu meniu;
	String linie="";
    public static final String numeFisier="meniuriDisponibile.txt";
	
	public TestCitireFisierMeniu(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("Pregatire test");
		reader = new FileReader(numeFisier);
		bf = new BufferedReader(reader);
		meniu=new CategorieMeniu("meniu");
	}
	
	
	public void testCitireFisierPathCorect()
	{
		try{
			linie=bf.readLine();
			
		}catch(Exception ex)
		{
			
		}
	assertEquals("Testare corectudine path pentru citire din fisier","meniuriDisponibile.txt",numeFisier);
	}
	
	
	public void testCitireFisierPathGresit()
	{

		try
		{
			FileReader read=new FileReader("meniuri.txt");
			bf=new BufferedReader(read);
			linie=bf.readLine();
			fail("Metoda nu arunca o exceptie pentru path gresit");
			
		}catch(Exception ex)
		{
			
		}
	}
	
	public void testValiditateLinie()
	{
		try
		{
			int nrLinie=0;
			while((linie=bf.readLine())!=null)
			{
				nrLinie++;
				String[] t=linie.split(",");
				if(t.length!=3)
				{
					throw new Exception("Linia "+nrLinie+"invalida");
				}
				System.out.println("Linia "+nrLinie+" valida");
				assertEquals("Linie valida ", 3,t.length);
			}
			
			
		}catch(Exception ex)
		{
			
		}
	}
	
	public void testCorespondentaNrPreparate()
	{
		try
		{
			int nrLinie=0;
			while((linie=bf.readLine())!=null)
			{
				nrLinie++;
				String[] t=linie.split(",");
				if(t.length!=3)
				{
					throw new Exception("Linia "+nrLinie+"invalida");
				}
				ComponentaMeniu categorieMeniu=new CategorieMeniu(t[0].trim());
				int nrPreparateCategorieMeniu=Integer.parseInt(t[1].trim());
				
				String[] preparate=t[2].split(":");
				if(preparate.length!=nrPreparateCategorieMeniu)
				{
					throw new Exception("Necorespondenta numar preparate cu cel indicat");
				}
				System.out.println(nrPreparateCategorieMeniu);
				assertEquals("Numar preparate corespondent cu cel indicat", nrPreparateCategorieMeniu,preparate.length);
				
			}
			
			
		}catch(Exception ex)
		{
			
		}
	}
	
	public void testNumarCorectInformatiiPreparat()
	{
		try
		{
			int nrLinie=0;
			while((linie=bf.readLine())!=null)
			{
				nrLinie++;
				String[] t=linie.split(",");
				if(t.length!=3)
				{
					throw new Exception("Linia "+nrLinie+"invalida");
				}
				ComponentaMeniu categorieMeniu=new CategorieMeniu(t[0].trim());
				int nrPreparateCategorieMeniu=Integer.parseInt(t[1].trim());
				
				String[] preparate=t[2].split(":");
				if(preparate.length!=nrPreparateCategorieMeniu)
				{
					throw new Exception("Necorespondenta numar preparate cu cel indicat");
				}
				for(int i=0;i<nrPreparateCategorieMeniu;i++)
				{
					String[] informatiiPreparat=preparate[i].split(";");
					if(informatiiPreparat.length!=2)
					{
						throw new Exception("Nr informatii redundant");
					}
					assertEquals("Nr corect informatii preparate", 2,informatiiPreparat.length);
				}
			
			}
			
			
		}catch(Exception ex)
		{
			
		}
	}
	
	public void testPreluareCorectaInformatii()
	{
		try
		{
			int nrLinie=0;
			while((linie=bf.readLine())!=null)
			{
				nrLinie++;
				String[] t=linie.split(",");
				if(t.length!=3)
				{
					throw new Exception("Linia "+nrLinie+"invalida");
				}
				ComponentaMeniu categorieMeniu=new CategorieMeniu(t[0].trim());
				int nrPreparateCategorieMeniu=Integer.parseInt(t[1].trim());
				
				String[] preparate=t[2].split(":");
				if(preparate.length!=nrPreparateCategorieMeniu)
				{
					throw new Exception("Necorespondenta numar preparate cu cel indicat");
				}
				for(int i=0;i<nrPreparateCategorieMeniu;i++)
				{
					String[] informatiiPreparat=preparate[i].split(";");
					if(informatiiPreparat.length!=2)
					{
						throw new Exception("Nr informatii redundant");
					}
					
						ComponentaMeniu preparat=new Preparat(informatiiPreparat[0].trim(), Double.parseDouble(informatiiPreparat[1].trim()));
						categorieMeniu.adauga(preparat);
					    
					
					meniu.adauga(categorieMeniu);
				}
				
				
			
			}
			
			
		}catch(Exception ex)
		{
			
		}
	}
	
	

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Terminare test");
		reader.close();
		bf.close();
	}

}
