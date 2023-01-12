package Control;

import Conection.Conexao;
import Model.Usuario;
import Dao.UsuarioDAO;
import Model.Pessoa;
import Model.Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author mafxr
 */
public class Main extends Application {
    
    @Override
     public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginUsuario.fxml")); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
       
        launch(args);
    }
    
}
