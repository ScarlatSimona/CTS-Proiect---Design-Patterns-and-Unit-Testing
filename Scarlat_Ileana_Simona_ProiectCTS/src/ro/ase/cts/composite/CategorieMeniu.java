package ro.ase.cts.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;

public class CategorieMeniu extends ComponentaMeniu{
    
	ArrayList listaPreparate=new ArrayList<>();
	
	private String denumireCategorie;
	
	public CategorieMeniu(String denumireCategorie) throws Exception
	{
		if(denumireCategorie==null)
		{
			throw new Exception("Categoria trebuie sa aiba o denumire");
		}
		else
		this.denumireCategorie=denumireCategorie;
	}
	
	public String getDenumireCategorie()
	{
		return this.denumireCategorie;
	}
	
	public void adauga(ComponentaMeniu preparatNou)
	{
	  if(preparatNou==null)
	  {
		  throw new UnsupportedOperationException();
	  }
	  else
	  listaPreparate.add(preparatNou);
	 
	  
	}
	public void sterge(ComponentaMeniu preparatExistent)
	{
		if(preparatExistent==null)
		{
			throw new UnsupportedOperationException();
		}
		else
		listaPreparate.remove(preparatExistent);
		
	}
	
	public ComponentaMeniu getComponenta(int indexPreparat)
	{
		return (ComponentaMeniu) listaPreparate.get(indexPreparat);
	}
	
	public void vizualizeazaInformatiiComponenta()
	{
		System.out.println(getDenumireCategorie()+":\n");
		Iterator preparatIterator=listaPreparate.iterator();
		while(preparatIterator.hasNext())
		{
			ComponentaMeniu preparat=((ComponentaMeniu)preparatIterator.next());
			preparat.vizualizeazaInformatiiComponenta();
		}
	}
	
	
	
	public ObservableList<String> vizualizareInformatiiListView(ObservableList<String> lista)
	{
		lista.add("                    -"+getDenumireCategorie()+"-                        ");
		Iterator preparatIterator=listaPreparate.iterator();
		while(preparatIterator.hasNext())
		{
			ComponentaMeniu preparat=((ComponentaMeniu)preparatIterator.next());
			preparat.vizualizareInformatiiListView(lista);
		}
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
		TreeItem<String> item=construireIerarhie(getDenumireCategorie(), parinte);
		Iterator preparatIterator=listaPreparate.iterator();
		while(preparatIterator.hasNext())
		{
			ComponentaMeniu preparat=((ComponentaMeniu)preparatIterator.next());
			preparat.construireTreeView(item);
			
		}
		
		
	 }
	 
	
}
