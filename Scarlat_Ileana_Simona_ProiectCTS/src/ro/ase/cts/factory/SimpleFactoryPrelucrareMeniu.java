package ro.ase.cts.factory;

import ro.ase.cts.strategy.PrelucrareMeniu;
import ro.ase.cts.strategy.VizualizareMeniuListView;
import ro.ase.cts.strategy.VizualizareMeniuTreeView;

public class SimpleFactoryPrelucrareMeniu {
    public static PrelucrareMeniu getPrelucrare(TipPrelucrare tipPrelucrare)throws Exception
    {
    	switch(tipPrelucrare)
    	{
    	case VizualizareMeniuListView:
    		return new VizualizareMeniuListView();
    	case VizualizareMeniuTreeView:
    		return new VizualizareMeniuTreeView();
       default: 
    	   throw new Exception("Tip netratat");
    	}
    }
}
