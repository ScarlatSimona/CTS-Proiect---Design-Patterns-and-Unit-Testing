package comenzi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import meniuCantina.PrelucrareMeniuController;
import meniuCantina.PrincipalController;
import ro.ase.cts.factory.TipPrelucrare;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;
import ro.ase.cts.singletonfacadefactorybuilder.Facade;
import ro.ase.cts.singletonfacadefactorybuilder.TipInterogare;
import ro.ase.cts.state.ModificareStareComanda;
import ro.ase.cts.state.StareComanda;

public class ComenziController implements Initializable{

	@FXML
	private Button adaugaComandaButton;
	
	@FXML
	private ListView<String> comenziListView;
	
	@FXML
	private Button backButtonComenzi;
	
	public static TipInterogare tipInterogare=null;
	
	@FXML
	private Button anuleazaComandaButton;
	
	public Comanda comandaN;
	
	@FXML
	private ListView<String> comenziPreluateListView;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		comenziListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	    
	}
	
	public void setComandaPrimita(Comanda comandaNoua)
	{
		this.comandaN=comandaNoua;
		
		Facade.executieInterogare(tipInterogare, comandaN);
	}
	
	public ListView<String> getListView()
	{
		return this.comenziListView;
	}
	
	@FXML
	public void backButtonActionComenzi(MouseEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
    	AnchorPane principal_page_parrent;
		try {
			principal_page_parrent = FXMLLoader.load(getClass().getResource("/meniuCantina/Principal.fxml"));
			Scene principal_page_scene=new Scene(principal_page_parrent);
	        Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            
	        app_stage.setScene(principal_page_scene);
	        app_stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void preluareInformatiiComandaNoua(MouseEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
    	AnchorPane principal_page_parrent;
		try {
			principal_page_parrent = FXMLLoader.load(getClass().getResource("/comandaNoua/ComandaNoua.fxml"));
			Scene principal_page_scene=new Scene(principal_page_parrent);
	        Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            
	        app_stage.setScene(principal_page_scene);
	        app_stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	ObservableList<String> lista=FXCollections.observableArrayList();
	
	@FXML
	public void preluareComandaButtonAction(MouseEvent event)
	{
		ModificareStareComanda modificare=new ModificareStareComanda();
		modificare.setStare(StareComanda.PRELUATA);
		
		lista.add(comenziListView.getSelectionModel().getSelectedItem());
		comenziPreluateListView.setItems(lista);
		comenziListView.getItems().remove(comenziListView.getSelectionModel().getSelectedIndex());
		modificare.afisare();
	}
	
	@FXML
	public void executieInterogareButtonAction(MouseEvent event) throws Exception
	{
		
		
		if(event.getSource()==adaugaComandaButton)
		{
			tipInterogare=TipInterogare.ADAUGARE;
			
			preluareInformatiiComandaNoua(event);
			
		}
		else if(event.getSource()==anuleazaComandaButton)
		{
			tipInterogare=TipInterogare.STERGERE;	
			String itemSelectat = comenziListView.getSelectionModel().getSelectedItem();
			System.out.println(itemSelectat);
			
			String sb=itemSelectat.substring(0, 4);
			System.out.println(sb);
			Comanda com=new Comanda();
			com.setCod(sb);
			System.out.println(com.getCod());
			Facade.executieInterogare(tipInterogare, com);
			PrincipalController p=new PrincipalController();
			p.comenziButtonActionPrincipal(event);
		}
		
		
		
	}

}
