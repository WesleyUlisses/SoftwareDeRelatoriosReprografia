package Conection;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Falta criarmos o banco de dados pra colocar o localhost dele e talz
public class Conexao {

    public Connection ConexaoBd() {
        Connection conn = null;
        try {
            //Estabelece conexao
           String url = "jdbc:mysql://localhost:3306/reprografia";
            String usuario = "root";
            String senha ="2002";
            conn =  DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException erro) {
            //Erro conexao
            System.out.println("Erro ao conectar " + erro.getMessage());

        }
        return conn;
    }
}
