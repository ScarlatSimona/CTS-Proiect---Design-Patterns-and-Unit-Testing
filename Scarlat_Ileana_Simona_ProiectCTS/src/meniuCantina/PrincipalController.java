package meniuCantina;

import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;
import ro.ase.cts.composite.Preparat;
import ro.ase.cts.factory.SimpleFactoryPrelucrareMeniu;
import ro.ase.cts.factory.TipPrelucrare;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;
import ro.ase.cts.singletonfacadefactorybuilder.Facade;
import ro.ase.cts.singletonfacadefactorybuilder.TipInterogare;
import ro.ase.cts.strategy.PrelucrareMeniu;
import ro.ase.cts.strategy.VizualizareMeniuListView;
import ro.ase.cts.strategy.VizualizareMeniuTreeView;

public class PrincipalController implements Initializable{
     
	public static String tipEvenimentDeclansat="";
	@FXML
	private Button vizualizareMeniuButton;
	
	@FXML
	private Button comenziButtonPrincipal;
	
	@FXML
	private Button prelucrareMeniuButton;
	

	
	
	public ComponentaMeniu listaMeniuri;
	
	public Meniu meniuDisponibil;
	
	public Control controlJavaFX;
	
	
	
	
	public ComponentaMeniu citireFisierMeniuri(String numeFisier) throws Exception
	{
		
		listaMeniuri=new CategorieMeniu("Meniu");
		
		try(BufferedReader in=new BufferedReader(new FileReader(numeFisier)))
		{
			
			String linie;
			int nrLinie=0;
			while((linie=in.readLine())!= null)
				
			{
				nrLinie++;
				String[] t=linie.split(",");
				if(t.length!=3)
				{
					throw new Exception("Linia "+nrLinie+" invalida");
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
					ComponentaMeniu preparat=new Preparat(informatiiPreparat[0].trim(), Double.parseDouble(informatiiPreparat[1].trim()));
					categorieMeniu.adauga(preparat);
				}
				
				listaMeniuri.adauga(categorieMeniu);
				
			}
		}catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
	return listaMeniuri;
	}
	public void setareStrategie(TipPrelucrare tip) throws Exception
	{
		PrelucrareMeniu strategie=SimpleFactoryPrelucrareMeniu.getPrelucrare(tip);
		meniuDisponibil.setStrategiePrelucrareMeniu(strategie);
		meniuDisponibil.prelucrareGenerica();
		

	}
	
	@FXML
	public void handleButtonAction(MouseEvent event) throws Exception
	{
		
		TipPrelucrare tip=null;
		((Node)event.getSource()).getScene().getWindow().hide();
		
		if(event.getSource()==vizualizareMeniuButton)
		{
			tip=TipPrelucrare.VizualizareMeniuListView;
			
		}
		else if(event.getSource()==prelucrareMeniuButton)
		{
			tip=TipPrelucrare.VizualizareMeniuTreeView;
			
		}
		setareStrategie(tip);
		
	}
	@FXML
	public void comenziButtonActionPrincipal(MouseEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
		Facade.executieInterogare(TipInterogare.VIZUALIZARE, null);
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			listaMeniuri=citireFisierMeniuri("meniuriDisponibile.txt");
			meniuDisponibil=new Meniu(listaMeniuri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
