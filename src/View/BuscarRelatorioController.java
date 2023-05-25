/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package View;

import Arquivos.Arquivo;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mafxr
 */
public class BuscarRelatorioController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private BorderPane BorderPane;

    @FXML
    private Button exitbutton;

    @FXML
    private TextField getNome;

    @FXML
    private Button menuButton;

    @FXML
    private ChoiceBox<String> ocupacaoBox;

    @FXML
    private TextField pesTextfield;

    @FXML
    private Button pesquisa;

    @FXML
    private Button proximo;
    
    private String[] ocupacoes = {"Aluno", "Professor", "Servidor"};

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
    void getpesquisa(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SearchBar.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void irMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void irProximo(ActionEvent event) throws IOException {
        
        String getOcupacao = ocupacaoBox.getValue();
        String pegaNome = getNome.getText();

        
        if(getOcupacao.equals("Aluno")){
            //adicionar parametro de quantidade de cotas
                
                Parent root = FXMLLoader.load(getClass().getResource("ImpreAlunoVerde.fxml"));

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            
        } 
        else if(getOcupacao.equals("Professor")){
            //adicionar parametros de cotas
                
                Parent root = FXMLLoader.load(getClass().getResource("ImpreProfVerde.fxml"));

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
          
            
        } 
        else{
            // adicionar parametro de cotas
                
                Parent root = FXMLLoader.load(getClass().getResource("ServidorVerde.fxml"));

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
          
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ocupacaoBox.getItems().addAll(ocupacoes);
        // TODO
    }    
    
}
