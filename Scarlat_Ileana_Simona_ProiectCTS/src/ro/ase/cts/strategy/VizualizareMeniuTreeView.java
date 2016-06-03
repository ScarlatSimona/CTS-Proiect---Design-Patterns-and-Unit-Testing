package ro.ase.cts.strategy;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import meniuCantina.PrelucrareMeniuController;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;

public class VizualizareMeniuTreeView implements PrelucrareMeniu{
	
	
	
	
	@Override
	public void prelucrare(ComponentaMeniu listaComponente) {
		TreeItem<String> root,componenta;
		
		root=new TreeItem<String>();
		root.setExpanded(true);
		
		listaComponente.construireTreeView(root);
		
		try {
        	
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/meniuCantina/PrelucrareMeniu.fxml"));
			loader.load();
			AnchorPane parent=loader.getRoot();
	        Stage stage=new Stage();
	        stage.setScene(new Scene(parent));

	        PrelucrareMeniuController prelucrareController=loader.getController();
	        (prelucrareController.getTreeView()).setRoot(root);
			(prelucrareController.getTreeView()).setShowRoot(false);
	        
	        stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	
}
