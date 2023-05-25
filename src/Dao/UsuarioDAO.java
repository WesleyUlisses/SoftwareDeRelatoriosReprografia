package Dao;

import Conection.Conexao;
import Model.Pessoa;
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
                String sql = "INSERT INTO usuario_pessoa (login, senha,tentativasLogin, bloqueado, adm, cotas_idcotas)VALUES (?,?,?,?,?,?)";
                CotasDAO cota = new CotasDAO();
                cota.cadastrarCota(); //Criando a cota que será registrada no usuario
                
                PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 
                
                ps.setString(1, user.getLogin());                     //Paramentros   
                ps.setString(2, user.getSenha());
                ps.setInt(3, user.getTentativasLogin());
                ps.setBoolean(4, user.verificaUsuarioBloqueado());
                ps.setBoolean(5, user.getAdm());
                ps.setInt(6, cota.ultimaCota());
                
                
                
                
                
                ps.executeUpdate();                                       //Executa sql
                ps.close();
                
                JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso");
            } catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"erro ao cadastrar, "+e);
            }finally
            {
                Conexao.closeConexao();
            }
        }

    }

    public void cadastrarPessoa(Pessoa pessoa) {
        
       
            try {
                String sql = "INSERT INTO usuario_pessoa (nome, matricula, ocupacao, cotas_idcotas)VALUES (?,?,?,?)";
                CotasDAO cota = new CotasDAO();
                cota.cadastrarCota(); //Criando a cota que será registrada no usuario
                
                PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 

                ps.setString(1, pessoa.getNome());                     //Paramentros   
                ps.setString(2, pessoa.getMatricula());
                ps.setString(3, pessoa.getOcupacao());
                ps.setInt(4, cota.ultimaCota());
                
                ps.executeUpdate();                                       //Executa sql
                ps.close();
                
                JOptionPane.showMessageDialog(null,"Pessoa cadastrada com sucesso");
            } catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"erro ao cadastrar, "+e);
            }finally
            {
                Conexao.closeConexao();
            }
  

    }
    
    //DEU RUIM NO UPDATE, VERIFICAR...
    public void bloqueiaUsuario(Usuario user) {

        
        try {
            String sql = "UPDATE usuario_pessoa SET bloqueado=?"
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
            String sql = "SELECT * FROM usuario_pessoa WHERE login= ?";
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
            String sql = "SELECT * FROM usuario_pessoa WHERE bloqueado= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            
            ps.setBoolean(1, user.verificaUsuarioBloqueado());                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

                        
            if (rs.next())
            {   
                Usuario aux = new Usuario();
                aux.setBloquear(rs.getBoolean("bloqueado"));
                
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
            
            String sql = "SELECT * FROM usuario_pessoa WHERE senha= ?";
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
            String sql = "UPDATE usuario_pessoa SET  login=?, senha=?, tentativasLogin=?, bloqueado=? WHERE idusuario=?";

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
            String sql = "DELETE from usuario_pessoa WHERE login= ?";

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
    public Usuario ConsultarUsuarioPorMatricula(String matricula) {

        try {
            String sql = "SELECT * FROM usuario_pessoa WHERE matricula= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, matricula);                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Usuario usuario = new Usuario();                     //Cria Usuario a retornar
            if (rs.next()) {

                usuario.setLogin(rs.getString("login"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNome(rs.getString("nome"));
                usuario.setAdm(rs.getBoolean("adm"));
                usuario.setBloquear(rs.getBoolean("bloqueado"));
                usuario.setIdCotas(rs.getInt("cotas_idcotas"));
                usuario.setIdPessoa(rs.getInt("idusuario_pessoa"));
                
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pessoa ConsultarPessoaPorMatricula(String matricula) {

        try {
            String sql = "SELECT * FROM usuario_pessoa WHERE matricula= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, matricula);                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Pessoa pessoa = new Pessoa();                     //Cria Usuario a retornar
            if (rs.next()) {

                pessoa.setNome(rs.getString("nome"));
                pessoa.setOcupacao(rs.getString("ocupacao"));
                pessoa.setMatricula(rs.getString("matricula"));
                pessoa.setIdPessoa(rs.getInt("idusuario_pessoa"));
                
                return pessoa;
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
            String sql = "SELECT * FROM usuario_pessoa WHERE login= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, user);                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Usuario usuario = new Usuario();                     //Cria Usuario a retornar
            if (rs.next()) {

                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNome(rs.getString("nome"));
                usuario.setAdm(rs.getBoolean("adm"));
                usuario.setBloquear(rs.getBoolean("bloqueado"));
                usuario.setIdCotas(rs.getInt("cotas_idcotas"));
                
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
  
    public List<Usuario> ConsultarTodos() {

        try {
            String sql = "SELECT * FROM usuario_pessoa";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament         
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Usuario> listaUsuario = new ArrayList<Usuario>();  // Criar lista a retornar

            while (rs.next()) {

                Usuario usuario = new Usuario();                 //Cria novo produto 
                usuario.setLogin(rs.getString("login"));
                usuario.setOcupacao(rs.getString("ocupacao"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNome(rs.getString("nome"));
                usuario.setAdm(rs.getBoolean("adm"));
                usuario.setBloquear(rs.getBoolean("bloqueado"));
                usuario.setIdCotas(rs.getInt("cotas_idcotas"));
                
                listaUsuario.add(usuario);                          // add Usuario na lista 
            }

            return listaUsuario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pessoa> ConsultarPessoas() {

        try {
            String sql = "SELECT * FROM usuario_pessoa";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament         
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Pessoa> listaPessoa = new ArrayList<Pessoa>();  // Criar lista a retornar

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();                 //Cria novo produto 
                
                pessoa.setNome(rs.getString("nome"));
                pessoa.setMatricula(rs.getString("matricula"));
                pessoa.setOcupacao(rs.getString("ocupacao"));
                pessoa.setIdPessoa(rs.getInt("idusuario_pessoa"));
                pessoa.setIdCotas(rs.getInt("cotas_idcotas"));
                
                listaPessoa.add(pessoa);                          // add Usuario na lista 
            }

            return listaPessoa;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
