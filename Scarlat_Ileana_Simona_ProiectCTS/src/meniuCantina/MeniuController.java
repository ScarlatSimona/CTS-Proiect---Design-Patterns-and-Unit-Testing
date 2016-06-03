package meniuCantina;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;
import ro.ase.cts.composite.Preparat;



public class MeniuController implements Initializable{

	@FXML
	private Button backButtonMeniu;
	
	private Meniu meniuNou;
	
	@FXML
	private ListView<String> meniuListView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		meniuListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
	}
	
	public ListView<String> getListView()
	{
		return this.meniuListView;
	}
	

    @FXML
    private void backButtonActionMeniu(MouseEvent event)
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
    
    
    
    
}
