package Conection;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {

    public static Connection getConexao() {
    Connection conn = null;
        try {
            //Estabelece conexao
            String url = "jdbc:mysql://localhost:3306/print_counter";
            String usuario = "root";
            String senha ="2002";
            conn =  DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null,"conectado ao banco");
        } catch (SQLException erro) {
            //Erro conexao
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar " + erro.getMessage());
            System.out.println("Erro ao conectar " + erro.getMessage());

        }
        return conn;
  }
  
  //Método que fecha sua conexão//
    public static boolean closeConexao() {
        try {
            getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
