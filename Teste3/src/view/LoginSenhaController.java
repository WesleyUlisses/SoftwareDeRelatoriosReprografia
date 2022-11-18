/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

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
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mafxr
 */
public class LoginSenhaController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    private Button entrarButton;

    @FXML
    private PasswordField getSenha;
    
    String entrarSenha;

    @FXML
    void entrarSenha(ActionEvent event) throws IOException {
        entrarSenha = getSenha.getText();
       
       boolean sSenha = Boolean.parseBoolean(entrarSenha);
            
            
            if(sSenha == true){
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Senha Incorreta");
                alert.setContentText("favor, confira se sua senha está escrita corretamente");

                if(alert.showAndWait().get() == ButtonType.OK){
                    stage = (Stage) AnchorPane.getScene().getWindow();
                }
            }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
