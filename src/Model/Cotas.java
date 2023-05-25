package Model;

import Dao.CotasDAO;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.List;

public class Cotas {

     private List<Impressoes> impressoes;
     private int idImpressoes;
     private int idCotas;
    /**
     * @return the impressoes
     */
    public List<Impressoes> getImpressoes() {
        return impressoes;
    }

    /**
     * @param impressoes the impressoes to set
     */
    public void setImpressoes(List<Impressoes> impressoes) {
        this.impressoes = impressoes;
    }
    
    /**
     * @return the idImpressoes
     */
    public int getIdImpressoes() {
        return idImpressoes;
    }

    /**
     * @param idImpressoes the idImpressoes to set
     */
    public void setIdImpressoes(int idImpressoes) {
        this.idImpressoes = idImpressoes;
    }

    /**
     * @return the idCotas
     */
    public int getIdCotas() {
        return idCotas;
    }

    /**
     * @param idCotas the idCotas to set
     */
    public void setIdCotas(int idCotas) {
        this.idCotas = idCotas;
    }


}
