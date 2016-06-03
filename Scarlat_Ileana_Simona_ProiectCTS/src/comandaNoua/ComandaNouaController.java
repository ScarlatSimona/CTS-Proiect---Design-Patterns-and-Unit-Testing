package comandaNoua;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import comenzi.ComenziController;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import meniuCantina.PrincipalController;
import ro.ase.cts.composite.CategorieMeniu;
import ro.ase.cts.composite.ComponentaMeniu;
import ro.ase.cts.composite.Meniu;
import ro.ase.cts.composite.Preparat;
import ro.ase.cts.singletonfacadefactorybuilder.BuilderComanda;
import ro.ase.cts.singletonfacadefactorybuilder.Comanda;
import ro.ase.cts.state.ModificareStareComanda;
import ro.ase.cts.state.StareComanda;

public class ComandaNouaController implements Initializable {

	List<Preparat> listaPreparate = new ArrayList<>();

	@FXML
	private ListView<Item> preparateListView;

	@FXML
	private Button adaugaComandaNouaButton;

	@FXML
	private TextField codInput;

	public static String lista;
	public static float pretTotal = 0;
	
	@FXML
	private TextField masaInput;

	StringBuilder sb = new StringBuilder();

	public List<Preparat> citireFisierPreparate(String numeFisier, List<Preparat> lista) {

		try (BufferedReader in = new BufferedReader(new FileReader(numeFisier))) {
			String linie;
			while ((linie = in.readLine()) != null) {
				String[] t = linie.split(",");
				ComponentaMeniu preparat = new Preparat(t[0].trim(), Float.parseFloat(t[1].trim()));
				lista.add((Preparat) preparat);
			}
		} catch (Exception ex) {
			System.err.append(ex.toString());
		}
		return lista;
	}

	ObservableList<String> valori = FXCollections.observableArrayList();
	public ListView<String> listView;

	@FXML
	public void adaugaComandaNouaButtonAction(MouseEvent event) throws Exception {
		// BUILDER
		Comanda comanda = new BuilderComanda(codInput.getText())
				.setMasa(Integer.parseInt(masaInput.getText()))
				.setPreparateComandate(sb.toString())
				.setPretTotal(pretTotal)
				.setStareComanda("nepreluata")
				.build();
		ModificareStareComanda modificare=new ModificareStareComanda();
		modificare.setStare(StareComanda.NEPRELUATA);
		
		((Node) event.getSource()).getScene().getWindow().hide();
		ComenziController comenziController = new ComenziController();
		comenziController.setComandaPrimita(comanda);
		PrincipalController p = new PrincipalController();
		p.comenziButtonActionPrincipal(event);

		System.out.println(comanda.getPreparateComandate() + " " + comanda.getPretTotal());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listaPreparate = citireFisierPreparate("preparate.txt", listaPreparate);
		for (int i = 0; i < listaPreparate.size(); i++) {
			Item item = new Item(listaPreparate.get(i).getDenumirePreparat(), false);
			item.onProperty().addListener((isNowOn) -> {
			sb.append(item.getName().toString() + ", ");
            int index = preparateListView.getSelectionModel().getSelectedIndex();
			Preparat preparat = listaPreparate.get(index);
			pretTotal = pretTotal + preparat.getPretPreparat();
            System.out.println(sb);
			System.out.println(pretTotal);
			});
			preparateListView.getItems().add(item);
		}
		preparateListView.setCellFactory(CheckBoxListCell.forListView(item -> item.onProperty()));
	}

}
