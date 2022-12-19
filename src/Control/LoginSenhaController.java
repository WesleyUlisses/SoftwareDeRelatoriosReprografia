package Control;

import Dao.UsuarioDAO;
import Model.Pessoa;
import Model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

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
    
    private String entrarSenha;
    private int tentativasLogin = 0;
    private static String auxiliar;
    
    public static void displayName(String usuarioP){
        auxiliar = usuarioP;
    }
    
    @FXML
    void entrarSenha(ActionEvent event) throws IOException {
            
            String campoDeTexto = getSenha.getText();
            Usuario user = new Usuario();

            
            user.setLogin(auxiliar);
            user.setSenha(campoDeTexto);
            
            UsuarioDAO usuarioConexao = new UsuarioDAO();            
            List<Usuario> lista = usuarioConexao.ConsultarPorLogin(user);       //Encontrar usuaria em lista, no banco
            
            Usuario retornado = lista.get(0);       //estanciar o usuario encontrado


            //Se senha valide e usuario não exceder a quantidade de tentativas
            if((user.getSenha().equals(retornado.getSenha())) && !(retornado.verificaUsuarioBloqueado()))
            {
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else if(retornado.verificaUsuarioBloqueado()){
                
                JOptionPane.showMessageDialog(null,"Esse usuario está bloqueado, favor entre em contato com o tecnico");
                
            }
            else{
                tentativasLogin ++;
                //Contagem para tentativas de senha
                
                retornado.setTentativasLogin(tentativasLogin);
                //Verifica se o usuario excedeu a quantidade de tentativas de acesso
                if(retornado.getTentativasLogin() >= 3)
                {
                    //Bloqueia o usuario
                    retornado.setBloquear(true);
                    usuarioConexao.bloqueiaUsuario(retornado);       //Atualiza no Banco
                    JOptionPane.showMessageDialog(null,"Ele bloqueou");
                }
                
                if(usuarioConexao.verificaUsuarioBloqueado(retornado)){
                    
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Senha Incorreta");
                    alert.setContentText("favor, confira se sua senha está escrita corretamente");

                    if(alert.showAndWait().get() == ButtonType.OK){
                        stage = (Stage) AnchorPane.getScene().getWindow();
                    }
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
