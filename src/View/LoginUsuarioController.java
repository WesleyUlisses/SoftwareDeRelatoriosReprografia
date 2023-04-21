/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package View;

import Dao.UsuarioDAO;
import Model.Usuario;
import javafx.scene.layout.StackPane;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author mafxr
 */


public class LoginUsuarioController implements Initializable {
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private StackPane StackPane;
    
    @FXML
    private TextField getUsuario;

    @FXML
    private Button proximoButton;

    private String entraUsuario;
    
    
    
    
    
    @FXML
    void irProxima(ActionEvent event) throws IOException {
            
            String campoDeTexto = getUsuario.getText();
            Usuario user = new Usuario();
            user.setLogin(campoDeTexto);
            UsuarioDAO usuarioConexao = new UsuarioDAO();
            
            String usuarioP = campoDeTexto;
            //usuarioConexao.verificaUsuarioValido(user
            
            if(true){
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSenha.fxml"));
                Parent newRoot = loader.load();
                
                LoginSenhaController loginSenha = loader.getController();
                LoginSenhaController.displayName(usuarioP);
                
                Parent root;
                root = FXMLLoader.load(getClass().getResource("LoginSenha.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Usuário não encontrado");
                alert.setContentText("Confira se seu email ou matrícula está escrito corretamente");

                if(alert.showAndWait().get() == ButtonType.OK){
                    stage = (Stage) StackPane.getScene().getWindow();
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
