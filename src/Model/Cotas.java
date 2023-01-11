
package Model;

import javax.swing.JOptionPane;

/*
70  Professores = 75 % = 26 250
Alunos e Servidores = 25 % = 8 750

Valor ano.

IF cota mensal = x
Quantidade de professores variável;

professores = ( 75 % ) / 70 
alunos e servidores = ( 25 % ) / 400

*/
public class Cotas {
   
    private int cotasTotaisDoIf;
    private int cotasIndividual;
    private int cotasUsadas;
    private int cotasRestantes;
    
    public Cotas()
    {
        //Calculo de cotas individual
    }
    
    public Cotas(String ocupacao)
    {
        if(ocupacao.equals("Professor")){
            
            //Calculo de cotas para professor
        }
       else{
          //Calculo de cotas para servidor ou aluno
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

    public int getCotasIndividual()
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

    public int getCotasRestantes()
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
