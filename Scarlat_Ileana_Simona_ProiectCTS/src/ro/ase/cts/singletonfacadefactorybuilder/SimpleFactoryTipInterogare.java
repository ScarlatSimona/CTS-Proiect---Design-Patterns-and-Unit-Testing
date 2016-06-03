package ro.ase.cts.singletonfacadefactorybuilder;

import ro.ase.cts.factory.TipPrelucrare;
import ro.ase.cts.strategy.PrelucrareMeniu;
import ro.ase.cts.strategy.VizualizareMeniuListView;
import ro.ase.cts.strategy.VizualizareMeniuTreeView;

public class SimpleFactoryTipInterogare {
	 public static InterogareSQL getPrelucrare(TipInterogare tipInterogare)throws Exception
	    {
	    	switch(tipInterogare)
	    	{
	    	case ADAUGARE:
	    		return new AdaugaComanda();
	    	case STERGERE:
	    		return new AnulareComanda();
	    	case VIZUALIZARE:
	    		return new VizualizareComanda();
	       default: 
	    	   throw new Exception("Tip netratat");
	    	}
	    }
}
