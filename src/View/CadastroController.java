/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package View;

import Dao.PessoaDAO;
import Model.Pessoa;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mafxr
 */
public class CadastroController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private Button cadastrobutton;

    @FXML
    private Button exitbutton;

    @FXML
    private Button menubutton;

    @FXML
    private TextField matricula;

    @FXML
    private TextField nome;

    @FXML
    private ChoiceBox<String> ocupacao;

    @FXML
    private Button searchbutton;

    private String[] ocupacoes = {"Aluno", "Professor", "Servidor"};

    @FXML
    void cadastrar(ActionEvent event) {

        if (ocupacao.getValue() != null) {
            Pessoa pessoaCadastrada = new Pessoa();
            pessoaCadastrada.setNome(nome.getText());
            pessoaCadastrada.setMatricula(matricula.getText());
            pessoaCadastrada.setOcupacao(ocupacao.getValue());
            
            JOptionPane.showMessageDialog(null, pessoaCadastrada + "\n Sendo cadastrada no banco");
            PessoaDAO cadastroBanco = new PessoaDAO();
            cadastroBanco.Cadastrar(pessoaCadastrada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione valores para todos os campos!");
        }

    }

    @FXML
    void pesquisar(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SearchBar.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saida(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fechar Aplicação");
        alert.setContentText("Tem certeza que deseja fechar o App?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) BorderPane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void voltamenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ocupacao.getItems().addAll(ocupacoes);
    }

}
