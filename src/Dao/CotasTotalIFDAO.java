package Dao;

import Conection.Conexao;
import Model.Cotas;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CotasTotalIFDAO {
    
    /*
    public class CotasDAO {
    private Connection conexao;

    public CotasDAO() {
        this.conexao = new Conexao().getConexao();
    }
    
    //Calculo de cotas.
    
    //Cadastrar cotas
    public void cadastrarCotasTotalIf(CotasTotalIf cotas) {
            
            try 
            {
                String sql = "INSERT INTO Usuario (login, senha,tentativasLogin, bloqueado)VALUES (?,?,?,?)";

                PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 
                
                ps.setString(1, user.getLogin());                     //Paramentros   
                ps.setString(2, user.getSenha());
                ps.setInt(3, user.getTentativasLogin());
                ps.setBoolean(4, user.verificaUsuarioBloqueado());
                
                ps.executeUpdate();                                       //Executa sql
                ps.close();
                
                JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso");
            } catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"erro ao salvar, "+e);
            }finally
            {
                Conexao.closeConexao();
            }
    }
    
    public Usuario ConsultarCotasTotalIf(String user) {

        try {
            String sql = "SELECT * FROM Usuario WHERE login= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, user);                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Usuario usuario = new Usuario();                     //Cria Usuario a retornar
            if (rs.next()) {

                usuario.setLogin(rs.getString("login"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNome(rs.getString("nome"));
                JOptionPane.showMessageDialog(null,usuario.getLogin()+" senha: "+usuario.getSenha());
                return usuario;
                
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public void Alterar(CotasTotalIf cotas) {

        try {
            String sql = "UPDATE Usuario SET  login=?, senha=?, tentativasLogin=?, bloqueado=? WHERE idusuario=?";

            PreparedStatement ps = conexao.prepareStatement(sql);   //objeto Stament 

            ps.setString(1, user.getLogin());                     //Paramentros          
            ps.setString(2, user.getSenha());
            ps.setInt(3, user.getTentativasLogin());
            ps.setBoolean(4, user.verificaUsuarioBloqueado());
            ps.setInt(5, user.getId());
            
            JOptionPane.showMessageDialog(null, ps.toString());
            ps.executeUpdate();                                       //Executa sql
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Cadastro Atualazado");
        }  catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"erro ao salvar, "+e);
            }finally
            {
                Conexao.closeConexao();
            }
    }


    public void Excluir(CotasTotalIf cotas) {

        try {
            String sql = "DELETE from Usuario WHERE login= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament              
            ps.setString(1, user.getLogin());          //Paramentros   
            ps.execute();                                      //Executa sql
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
}
