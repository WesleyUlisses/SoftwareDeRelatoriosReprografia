package Dao;

import Conection.Conexao;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new Conexao().getConexao();
    }

    //Funciona
    //Cadastrar Usuario no banco de dados
    public void cadastrarUsuario(Usuario user) {
        
        if (verificaUsuarioValido(user)) {
            JOptionPane.showMessageDialog(null,"Usuario Já Cadastrado no BD, tente outro login");
        }
        else{
            
            try {
                String sql = "INSERT INTO Usuario (login, senha,tentativasLogin, bloquado)VALUES (?,?,?,?)";

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

    }

    
    //DEU RUIM NO UPDATE, VERIFICAR...
    public void bloqueiaUsuario(Usuario user) {

        
        try {
            String sql = "UPDATE Usuario SET bloquado=?"
                    + "  WHERE idusuario=?";

            PreparedStatement ps = conexao.prepareStatement(sql);   //objeto Stament 

            
            ps.setBoolean(1, user.verificaUsuarioBloqueado());
            ps.setInt(2, user.getId());
            
            JOptionPane.showMessageDialog(null, ps.toString());
            ps.executeUpdate();                                       //Executa sql
            ps.close();

        } catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"erro ao salvar, "+e);
            }finally
            {
                Conexao.closeConexao();
            }

    }
     
    //Funciona
    /* Confere se existe usuario cadastrado com mesmo login*/
    public boolean verificaUsuarioValido(Usuario user) {

        try {
            String sql = "SELECT * FROM Usuario WHERE login= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, user.getLogin());                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql
            
            
            if (rs.next())
            {   
                Usuario aux = new Usuario();
                aux.setLogin(rs.getString("login"));
                
                if(user.getLogin().equalsIgnoreCase(aux.getLogin()));{
                    return true;
                }
            } else
            {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Funciona
    /* Confere se existe usuario cadastrado com mesmo login*/
    public boolean verificaUsuarioBloqueado(Usuario user) {

        try {
            String sql = "SELECT * FROM Usuario WHERE bloquado= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            
            ps.setBoolean(1, user.verificaUsuarioBloqueado());                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

                        
            if (rs.next())
            {   
                Usuario aux = new Usuario();
                aux.setBloquear(rs.getBoolean("bloquado"));
                
                if(user.verificaUsuarioBloqueado());{
                    JOptionPane.showMessageDialog(null,"Usuario Bloqueado");
                    return true;
                }
            } else
            {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Funciona
    /* Confere se existe usuario cadastrado com mesmo login*/
    public boolean verificaSenhaValida(Usuario user) {

        try {
            
            String sql = "SELECT * FROM Usuario WHERE senha= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, user.getSenha());                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql     
            
            if (rs.next())
            {   
                Usuario aux = new Usuario();
                aux.setSenha(rs.getString("senha"));
                
                if(user.getSenha().equalsIgnoreCase(aux.getSenha()));{
                    return true;
                }
                
            } else
            {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Altera um Usuario no banco de dados
     */
    public void Alterar(Usuario user) {

        try {
            String sql = "UPDATE usuario SET  login=?, senha=?, tentativasLogin=?, bloquado=? WHERE idusuario=?";

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

    /**
     * Exclui um produto do banco de dados
     */
    public void Excluir(Usuario user) {

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

    /**
     * Consulta um Usuario pela matricula no Banco
     */
    public Usuario ConsultarPorMatricula(String matricula) {

        try {
            String sql = "SELECT * FROM Usuario WHERE matricula= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, matricula);                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Usuario usuario = new Usuario();                     //Cria Usuario a retornar
            if (rs.next()) {

                usuario.setLogin(rs.getString("login"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNome(rs.getString("nome"));
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta um Usuario pelo login no Banco
     */
    public Usuario ConsultarPorLogin(String user) {

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

    /**
     * Consulta Usuario pelo nome no Banco e retorna uma lista com usuarios
     * compativeis
     */
    public List<Usuario> ConsultarPorLogin(Usuario user) {

        try {
            String sql = "SELECT * FROM Usuario WHERE login like '%" + user.getLogin() + "%'";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament           
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Usuario> listaProd = new ArrayList<Usuario>();  // Criar lista a retornar

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setBloquear(rs.getBoolean("bloquado"));
                usuario.setId(rs.getInt("idusuario"));
                /*
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNome(rs.getString("nome"));*/ //Buscar da tabela pessoa
                listaProd.add(usuario);                          // add Usuario na lista 
            }

            return listaProd;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> ConsultarTodos() {

        try {
            String sql = "SELECT * FROM Usuario";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament         
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Usuario> listaUsuario = new ArrayList<Usuario>();  // Criar lista a retornar

            while (rs.next()) {

                Usuario user = new Usuario();                 //Cria novo produto 
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                /*user.setNome(rs.getString("nome"));
                user.setOcupacao(re.getString("ocupacao")); aguardando implantação das outras classes DAO
                 */
                listaUsuario.add(user);                          // add Usuario na lista 
            }

            return listaUsuario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
