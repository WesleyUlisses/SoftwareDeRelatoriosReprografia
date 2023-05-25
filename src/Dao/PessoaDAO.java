package Dao;

import Conection.Conexao;
import Model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PessoaDAO {

    private Connection conexao;

    public PessoaDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void Cadastrar(Pessoa pessoa) {
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
            
            JOptionPane.showMessageDialog(null,pessoa+ " cadastrado(a) com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Excluir(Pessoa pessoa) {
        try {
            String sql = "DELETE from Pessoa WHERE matricula= ?";
            PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 

            ps.setString(1, pessoa.getMatricula());                  //Paramentros          
            ps.execute();                                      //Executa sql
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Atualizar(Pessoa pessoa) {
        try {
            String sql = "UPDATE Pessoa SET  nome=?, ocupacao=?, cotas=? "
                    + "WHERE matricula= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 

            ps.setString(1, pessoa.getNome());                     //Paramentros          
            ps.setString(2, pessoa.getOcupacao());
            //ps.setInt(3, pessoa.getCotas()); Falta a cotasDAO
            ps.execute();                                       //Executa sql
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pessoa Buscar(String matricula) {
        try {
            String sql = "SELECT * FROM Pessoa WHERE matricula= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setString(1, matricula);                           //Paramentros          
            ResultSet rs = ps.executeQuery();                  //Executa sql

            Pessoa pess = new Pessoa();                      //Cria pessoauto a retornar

            if (rs.next()) {
                pess.setMatricula(rs.getString("matricula"));
                pess.setNome(rs.getString("nome"));
                pess.setOcupacao(rs.getString("ocupacao"));
                //pess.setPreco(rs.getFloat("preco")); Cotas DAO
                return pess;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pessoa> BuscarPorNome(String nome) {

        try {
            String sql = "SELECT * FROM Pessoa WHERE nome like '%" + nome + "%'";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament           
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Pessoa> listaPessoa = new ArrayList<Pessoa>();  // Criar lista a retornar

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();                 //Cria novo pessoauto 
                pessoa.setMatricula(rs.getString("matricula"));    // coloca valores
                pessoa.setNome(rs.getString("nome"));
                pessoa.setOcupacao(rs.getString("ocupacao"));
                //pess.setCotas(rs.getFloat("cotas")); Classe cotasDAO ainda nao implementada
                listaPessoa.add(pessoa);                          // add pessoauto na lista 
            }
            return listaPessoa;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pessoa> BuscarPorOcupacao(String ocupacao) {
        try {
            String sql = "SELECT * FROM Pessoa WHERE ocupacao like '%" + ocupacao + "%'";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament           
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Pessoa> listaPessoa = new ArrayList<Pessoa>();  // Criar lista a retornar

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();                 //Cria novo pessoauto 
                pessoa.setMatricula(rs.getString("matricula"));    // coloca valores
                pessoa.setNome(rs.getString("nome"));
                pessoa.setOcupacao(rs.getString("ocupacao"));
                //pess.setCotas(rs.getFloat("cotas")); Classe cotasDAO ainda nao implementada
                listaPessoa.add(pessoa);                          // add pessoauto na lista 
            }
            return listaPessoa;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pessoa> ConsultarTodos() {

        try {
            String sql = "SELECT * FROM Pessoa";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament         
            ResultSet rs = ps.executeQuery();                  //Executa sql

            List<Pessoa> listaPessoa = new ArrayList<Pessoa>();  // Criar lista a retornar

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();                 //Cria novo pessoauto 
                pessoa.setMatricula(rs.getString("matricula"));    // coloca valores
                pessoa.setNome(rs.getString("nome"));
                pessoa.setOcupacao(rs.getString("ocupacao"));
                //pessoa.setCotas(rs.getFloat("cotas"));Classe cotasDAO ainda nao implementada
                listaPessoa.add(pessoa);                          // add pessoauto na lista 
            }

            return listaPessoa;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
