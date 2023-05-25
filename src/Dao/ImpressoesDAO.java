package Dao;

import Conection.Conexao;
import Model.Cotas;
import Model.Impressoes;
import Model.Pessoa;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ImpressoesDAO {
    private Connection conexao;

    public ImpressoesDAO() {
        this.conexao = new Conexao().getConexao();
    }
    
     public void registrarImpressoes(Impressoes impressao) {
            
            try 
            {
                String sql = "INSERT INTO impressao (data, quantidade)VALUES (?,?)";

                PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 
                //Registro de impressões é autoincremental
                ps.setDate(1, impressao.getData());
                ps.setInt(2, impressao.getQuantidade());
                
                ps.executeUpdate();                                       //Executa sql
                ps.close();
                
                JOptionPane.showMessageDialog(null,"Registro de impressão efetuado com sucesso!");
            } catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"erro ao registrar, "+e);
            }finally
            {
                Conexao.closeConexao();
            }
    }
     
     
    public Impressoes ConsultarImpressoes(int idImpressoes) {

        try {
            String sql = "SELECT * FROM impressao WHERE idimpressao= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setInt(1, idImpressoes);                   //Paramentros          
            
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Impressoes impressao = new Impressoes();                     //Cria Usuario a retornar
            if (rs.next()) {

                impressao.setData(rs.getDate("data"));
                impressao.setQuantidade(rs.getInt("quantidade"));
                impressao.setIdImpressoes(rs.getInt("idimpressao"));
                
                return impressao;
                
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Impressoes> ConsultarListaDeImpressoes(int idCota) {

        try {
            String sql = "SELECT * FROM impressao WHERE idcotas= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setInt(1, idCota);                   //Paramentros          
            
            ResultSet rs = ps.executeQuery();                     //Executa sql

            List<Impressoes> listaImpressoes = new ArrayList<Impressoes>();  // Criar lista a retornar

            while (rs.next()) {

                Impressoes impressao = new Impressoes();                 //Cria novo produto 
                
                impressao.setData(rs.getDate("data"));
                impressao.setQuantidade(rs.getInt("quantidade"));
                impressao.setIdImpressoes(rs.getInt("idimpressao"));
                
                listaImpressoes.add(impressao);                          // add Usuario na lista 
            }

            return listaImpressoes;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
