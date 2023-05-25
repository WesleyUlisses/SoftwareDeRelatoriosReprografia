package Model;

import java.sql.Date;


public class Impressoes {

    private int quantidade;
    private Date data;
    private int idImpressoes;
    
    public int getIdImpressoes() {
        return this.idImpressoes;
    }


    public void setIdImpressoes(int id) {
        this.idImpressoes = id;
    }
    
    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public Date getData() {
        return data;
    }


    public void setData(Date data) {
        this.data = data;
    }
    
}
