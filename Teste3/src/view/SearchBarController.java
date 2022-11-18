/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mafxr
 */
public class SearchBarController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    private Button exitButton;

    @FXML
    private TextField getPesquisa;
    
    @FXML
    private TableColumn<pessoas, String> matricula;

    @FXML
    private TableColumn<pessoas, String> nome;

    @FXML
    private TableColumn<pessoas, String> ocupacao;
    
    @FXML
    private TableView<pessoas> tableview;

    @FXML
    private Button pesquisaButton;

    @FXML
    void exitApp(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fechar Aplicação");
        alert.setContentText("Tem certeza que deseja fechar o App?");
        
        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) AnchorPane.getScene().getWindow();
            stage.close();
        }
    }

    private final ObservableList<pessoas> dataList = FXCollections.observableArrayList();
    
    @FXML
    void irPesquisar(ActionEvent event) {

        matricula.setCellValueFactory(new PropertyValueFactory<>("firstName"));        
        nome.setCellValueFactory(new PropertyValueFactory<>("email"));        
        ocupacao.setCellValueFactory(new PropertyValueFactory<>("department"));              
        
        
        pessoas per1 = new pessoas("MATRI000001", "a", "Professor");
        pessoas per2 = new pessoas("MATRI000002", "b", "Aluno");
        pessoas per3 = new pessoas("MATRI000003", "c", "Servidor");
        pessoas per4 = new pessoas("MATRI000004", "d", "aluno");                   
           
        dataList.addAll(per1,per2, per3, per4);
        
        FilteredList<pessoas> filteredData = new FilteredList<>(dataList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		getPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(pessoas -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (pessoas.getMatricula().toLowerCase().contains(lowerCaseFilter) ) {
					return true; // Filter matches first name.
				} else if (pessoas.getNome().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				else if (pessoas.getOcupacao().toLowerCase().contains(lowerCaseFilter))
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<pessoas> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableview.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableview.setItems(sortedData);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
