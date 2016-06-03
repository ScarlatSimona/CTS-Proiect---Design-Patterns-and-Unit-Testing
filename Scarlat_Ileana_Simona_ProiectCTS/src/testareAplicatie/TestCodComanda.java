package testareAplicatie;

import junit.framework.TestCase;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;

public class TestCodComanda extends TestCase {
	
    public void testSetCodRespectareNumarImpusLitere()
    {
    	Comanda comanda=new Comanda();
    	String codIncorect="01256";
    	try{
    		comanda.setCod(codIncorect);
    		fail("Metoda nu arunca exceptie pentru un cod cu numar mai mare de 4 cifre");
    	}catch(Exception ex)
    	{
    	   
    	}   	
    }
    
    public void testSetCodValoriNule()
    {
    	Comanda comanda=new Comanda();
    	String codNull=null;
    	try{
    		comanda.setCod(codNull);
    		fail("Metoda nu arunca exceptie pentru un cod null");
    		
    	}catch(Exception ex)
    	{
    		
    	}
    }
    
    public void testSetCodIntroducereLitere()
    {
    	Comanda comanda=new Comanda();
    	String codFormatIncorect="G45O";
    	try{
    		comanda.setCod(codFormatIncorect);
    		fail("Metoda nu arunca exceptie pentru un cod care contine litere");
    	}catch(Exception ex)
    	{
    		
    	}
    }
    
    public void testSetCodValoriNormale()
    {
    	Comanda comanda=new Comanda();
    	String codCorect="1256";
    	try
    	{
    		comanda.setCod(codCorect);
    		assertEquals("Cod corect", "1256",comanda.getCod());
    	}catch(Exception e)
    	{
    		
    	}
    }
    
    
}
