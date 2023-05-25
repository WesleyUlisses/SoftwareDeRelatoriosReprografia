package Dao;

import Conection.Conexao;
import Model.Cotas;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CotasDAO {
    
    private Connection conexao;

    public CotasDAO() {
        this.conexao = new Conexao().getConexao();
    }
    

    public void cadastrarCota() {
        
            try {
                String sql = "INSERT INTO cotas ()VALUES ()";

                PreparedStatement ps = conexao.prepareStatement(sql);   //obejeto Stament 

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
    
    
    public Cotas ConsultarId(int id) {

        try {
            String sql = "SELECT * FROM usuario_pessoa WHERE cotas_idcotas= ?";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
            ps.setInt(1, id);                   //Paramentros          
            ResultSet rs = ps.executeQuery();                     //Executa sql

            Cotas cota = new Cotas();                     //Cria Usuario a retornar
            if (rs.next()) {

                cota.setIdCotas(rs.getInt("cotas_idcotas"));
                cota.setIdImpressoes(rs.getInt("cotas_has_impressao_impressao_idimpressao"));
 
                return cota;
                
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public int ultimaCota() {

        try {
            String sql = "SELECT * FROM cotas ORDER BY idcotas DESC LIMIT1";

            PreparedStatement ps = conexao.prepareStatement(sql);  //obejeto Stament 
    
            ResultSet rs = ps.executeQuery();                     //Executa sql

            int idUltimaCota;                     //Cria Usuario a retornar
            if (rs.next()) {

                idUltimaCota = (rs.getInt("idcotas"));

                return idUltimaCota;
                
            } else {
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
