package ro.ase.cts.strategy;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import meniuCantina.MeniuController;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;

public class VizualizareMeniuListView implements PrelucrareMeniu{
	
	
	 
	@Override
	public void prelucrare(ComponentaMeniu listaComponente) {
		ObservableList<String> lista=FXCollections.observableArrayList();
		   lista=listaComponente.vizualizareInformatiiListView(lista);
		  
		   
		   try {
	        	//((Node)event.getSource()).getScene().getWindow().hide();
	            FXMLLoader loader=new FXMLLoader();
	            loader.setLocation(getClass().getResource("/meniuCantina/Meniu.fxml"));
				loader.load();
				AnchorPane parent=loader.getRoot();
		        Stage stage=new Stage();
		        stage.setScene(new Scene(parent));

		        MeniuController meniuController=loader.getController();
		        meniuController.getListView().setItems(lista);
		        stage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		//((ListView<String>) controlJavaFX).setItems(lista);
		  
		
	}
	
	


}
