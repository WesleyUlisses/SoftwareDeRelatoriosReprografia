/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mafxr
 */
public class BuscaController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private BorderPane BorderPane;

    @FXML
    private Button aluno;

    @FXML
    private Button exitbutton;

    @FXML
    private Button menubutton;

    @FXML
    private Button pesquisa;

    @FXML
    private TextField pesquisatext;

    @FXML
    private Button professor;

    @FXML
    private Button servidor;

    @FXML
    void exitapp(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fechar Aplicação");
        alert.setContentText("Tem certeza que deseja fechar o App?");
        
        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) BorderPane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void getPesquisa(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SearchBar.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void iraluno(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BuscarRelatorio.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void irprofessor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BuscarRelatorio.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void irservidor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BuscarRelatorio.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
