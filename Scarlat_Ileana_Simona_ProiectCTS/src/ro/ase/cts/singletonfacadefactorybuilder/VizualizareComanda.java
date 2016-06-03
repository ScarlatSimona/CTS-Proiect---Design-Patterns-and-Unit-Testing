package ro.ase.cts.singletonfacadefactorybuilder;

import java.awt.Rectangle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comenzi.ComenziController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import meniuCantina.MeniuController;

public class VizualizareComanda implements InterogareSQL{

	PreparedStatement pst=null;
    ResultSet rs=null;
    ObservableList<String> valori=FXCollections.observableArrayList();
    
	@Override
	public boolean executaInterogareSQL(Connection conexiune, Comanda comanda) {
		boolean executieReusita=false;
		try {

		 String query="select * from comenziTabel";
			        
		pst=conexiune.prepareStatement(query);
			             
		rs=pst.executeQuery();
		while(rs.next())
		{
		valori.add(rs.getString("cod")+"||"+rs.getString("preparateComandate")+"||"+rs.getString("pretTotal")+"||"+rs.getString("masa"));
			              
		 }
			            
			            
			            pst.close();
			            rs.close();
			            executieReusita=true;
			          
				        FXMLLoader loader=new FXMLLoader();
				        loader.setLocation(getClass().getResource("/comenzi/Comenzi.fxml"));
						loader.load();
						AnchorPane parent=loader.getRoot();
				        Stage stage=new Stage();
				        stage.setScene(new Scene(parent));

				        ComenziController comenziController=loader.getController();
				        comenziController.getListView().setItems(valori);
				      
				        stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  
		   return executieReusita;
	}

}
