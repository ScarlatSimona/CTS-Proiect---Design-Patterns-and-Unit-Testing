package ro.ase.cts.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;

public class Preparat extends ComponentaMeniu {

	String denumirePreparat;
	double pretPreparat;
	
	public Preparat(String denumirePreparat,double pretPreparat) throws Exception
	{
		if(denumirePreparat==null || denumirePreparat=="")
		{
			throw new Exception("Preparatul trebuie sa aiba o denumire");
		}
		else this.denumirePreparat=denumirePreparat;
		if(pretPreparat==0 )	
		{
			throw new Exception("Preparatul trebuie sa aiba un pret");
		} 
		else this.pretPreparat=pretPreparat;
		
	}
	
	public String getDenumirePreparat()
	{
		return this.denumirePreparat;
	}

	public float getPretPreparat()
	{
		return (float) this.pretPreparat;
	}
	
	public void vizualizeazaInformatiiComponenta()
	{
		System.out.println(this.denumirePreparat+" "+this.pretPreparat+" Lei");
	}
	
	public ObservableList<String> vizualizareInformatiiListView(ObservableList<String> lista)
    {
	   lista.add(this.denumirePreparat+" - "+this.pretPreparat+" lei");
   	   return lista;
    }
	
	public TreeItem<String> construireIerarhie(String copil,TreeItem<String> parinte)
	{
		TreeItem<String> item=new TreeItem<>(copil);
		item.setExpanded(true);
		parinte.getChildren().add(item);
		
		return item;
	}
	public void construireTreeView(TreeItem<String> parinte)
	 {
		construireIerarhie(getDenumirePreparat()+" - "+getPretPreparat()+" Lei", parinte);
	 }
	
	
	
}
