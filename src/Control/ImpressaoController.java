/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.ImpressoesDAO;
import Model.Impressoes;

/**
 *
 * @author SAMSUNG
 */
public class ImpressaoController {
    
    public void registrarImpressao(Impressoes impressao){
        
        ImpressoesDAO registro = new ImpressoesDAO();
        
        registro.registrarImpressoes(impressao);
    }
    
    public Impressoes verificaImpressoes(int id){
        
        ImpressoesDAO registro = new ImpressoesDAO();
        
        return registro.ConsultarImpressoes(id);
    }
}
