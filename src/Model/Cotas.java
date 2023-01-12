
package Model;

import Dao.CotasDAO;
import javax.swing.JOptionPane;
import java.util.Date;

public class Cotas <Pessoa> {
   
    private int cotasTotaisDoIf;
    private double cotasIndividual;
    private int cotasUsadas;
    private String impressoesData; //
    private double cotasRestantes;
    
    public Cotas()
    {
        //Calculo de cotas individual
    }
    
    public Cotas(String ocupacao, CotasDAO idividuais, CotasDAO totais)//CotasDAO individuais retorna a quantidade de cotas individuais
    {
        if(ocupacao.equals("Professor")){
            
        }
        else if(ocupacao.equals("Estudante")){
            
        }
        else{
            
        }
    }
    
    public int getCotasTotaisDoIf()
    {
        return cotasTotaisDoIf;
    }

    public void setCotasTotaisDoIf(int cotasTotaisDoIf)
    {
        this.cotasTotaisDoIf = cotasTotaisDoIf;
    }

    public double getCotasIndividual()
    {
        return cotasIndividual;
    }
  
    public void setCotasIndividual(int cotasIndividual)
    {
        this.cotasIndividual = cotasIndividual;
    }

    public int getCotasUsadas()
    {
        return cotasUsadas;
    }
 
    public void setCotasUsadas(int cotasUsadas)
    {
        this.cotasUsadas += cotasUsadas;
    }

    public double getCotasRestantes()
    {
        return cotasRestantes;
    }
    
    public int alertaCotasEsgotando()
    {   
        /*Retorna um valor para cada intervalo de impressões*/
        
        //Valor em porcentagem
        double porcentagem = (this.cotasRestantes * 100) / this.cotasIndividual;

        if( porcentagem >= 70 && porcentagem <= 100){
            return 3;            
        }
        else if( porcentagem >= 30 && porcentagem < 70){
            return 2;            
        }
        else if( porcentagem >= 0 && porcentagem < 30){
             return 1;           
        }
        else{
            
            //Error
            throw new IllegalArgumentException(
                            "Quantidade Invalida\nTotal de cotas: "+
                                    getCotasIndividual()+"Cotas Usadas: "
                                        +getCotasUsadas()
            );
        }
            

    }
    
    public void calculaCotasRestantes()
    {
        this.cotasRestantes = getCotasIndividual() - getCotasUsadas();
    }
    
    public void imprimir(int quantidade)
    {
        //Prints true
        if(quantidade > getCotasRestantes())
        {
            setCotasUsadas(quantidade);
        }
        else
        {
            //Message to user
            JOptionPane.showMessageDialog(null,
                    "Quantidade maior que cotas restantes\nQuantidade solicitada "
                            +quantidade+"Quantidade restante "+
                                getCotasRestantes()
            );
            //Error
            throw new IllegalArgumentException("Quantidade Invalida");
        }
            
    }
    
    @Override
    public String toString()
    {
        return "Cotas Individuais: "+getCotasIndividual()+
                "\nNumero de Impressões: "+getCotasUsadas()+
                "\nCotas Restantes: "+getCotasRestantes()+
                "\nCotas gerais para o instituto: "+getCotasTotaisDoIf();
    }
}
