package ro.ase.cts.composite;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;
import ro.ase.cts.strategy.PrelucrareMeniu;

public class Meniu {
   public ComponentaMeniu listaComponente;
   
   PrelucrareMeniu strategiePrelucrareMeniu;
   
   public Meniu(ComponentaMeniu listaComponente) throws Exception
   {
	   if(listaComponente==null)
	   {
		   throw new Exception("Meniul trebuie sa primeasca o lista nevida de componente");
	   }
	   this.listaComponente=listaComponente;
   }
   
   public void setStrategiePrelucrareMeniu(PrelucrareMeniu strategieNoua)
   {
	   this.strategiePrelucrareMeniu=strategieNoua;
   }
   
   
   
   public void afiseazaComponente()
   {
	   listaComponente.vizualizeazaInformatiiComponenta();
   }
   
   public ComponentaMeniu getListaComponente()
   {
	   return this.listaComponente;
   }
   
  
   public void prelucrareGenerica()
   {
	   if(this.strategiePrelucrareMeniu!=null)
	   {
		   this.strategiePrelucrareMeniu.prelucrare(this.listaComponente);
	   }
	   
   }
   
}
