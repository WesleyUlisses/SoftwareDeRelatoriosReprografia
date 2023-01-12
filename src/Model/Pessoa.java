package Model;


public class  Pessoa {
    
    private String nome;
    private String matricula;
    private String ocupacao;
    private Cotas cota;
    
    //Method Construct
    public Pessoa()
    {
        this.matricula = null;
        this.ocupacao = null;
        this.nome = null;
        this.cota = new Cotas();
    }
    
    //Method Construct 2
    public Pessoa(String nome, String matricula, String ocupacao)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.ocupacao = ocupacao;
        
        //New Pessoa are a professor
        if(ocupacao.equals("Professor"))
        {
            this.cota = new Cotas();            
        }
        else
        {
            this.cota = new Cotas();
        }
        
    }
    
    //Methods Gets and Sets
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public String getOcupacao()
    {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao)
    {
        this.ocupacao = ocupacao;
    }
    
    //Test if the person like then others
    public boolean equals(Pessoa pessoa)
    {
        if(this.getMatricula().equals(pessoa.getMatricula()) && this.getNome().equals(pessoa.getNome()))
        {
            return true;
        }  
        else
        {
            return false;
        }
    }
    
    //Function toString
    public String toString()
    {
        return "Nome: "+getNome()+
                "\nMatricula: "+getMatricula()+
                "\nOcupação: "+getOcupacao();
    }
}
