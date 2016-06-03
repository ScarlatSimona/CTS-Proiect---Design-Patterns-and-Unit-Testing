package meniuCantina;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrelucrareMeniuController implements Initializable{

	@FXML
	private Button backButtonPrelucrareMeniu;
	
	
	@FXML
	private TreeView<String> meniuTreeView;
	
	public TreeView<String> getTreeView()
	{
		return this.meniuTreeView;
	}
	
	@FXML
	public void backButtonActionPrelucrareMeniu(MouseEvent event)
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
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
