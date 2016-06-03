package ro.ase.cts.composite;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;

public abstract class ComponentaMeniu {
	
     public void adauga(ComponentaMeniu preparatNou)
     {
    	 throw new UnsupportedOperationException();
     }
     public void sterge(ComponentaMeniu preparatExistent)
     {
    	 throw new UnsupportedOperationException();
     }
     public ComponentaMeniu getComponenta(int indexComponenta)
     {
    	 throw new UnsupportedOperationException();
     }
     
     public String getDenumirePreparat()
     {
    	 throw new UnsupportedOperationException();
     }
     
     public String getDescrierePreparat()
     {
    	 throw new UnsupportedOperationException();
     }
     
     public float getPretPreparat()
     {
    	 throw new UnsupportedOperationException();
     }
     
     public void vizualizeazaInformatiiComponenta()
     {
    	 throw new UnsupportedOperationException();
     }
     
     public ObservableList<String> vizualizareInformatiiListView(ObservableList<String> lista)
     {
    	 throw new UnsupportedOperationException();
     }
     
     public void construireTreeView(TreeItem<String> parinte)
     {
  	   
    	 throw new UnsupportedOperationException();
     }
    
     
}
