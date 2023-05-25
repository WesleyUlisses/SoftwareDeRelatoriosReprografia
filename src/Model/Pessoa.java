package Model;


public class  Pessoa {

    
    private int idPessoa;
    private String nome;
    private String matricula;
    private String ocupacao;
    private int idCotas;
    private Cotas cota;
    
    /**
     * @return the cota
     */
    public Cotas getCota() {
        return cota;
    }

    /**
     * @param cota the cota to set
     */
    public void setCota(Cotas cota) {
        this.cota = cota;
    }
    
    
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
        this.cota = new Cotas();
    }
  
    //Methods Gets and Sets
  
    public int getIdCotas() {
        return idCotas;
    }

    public void setIdCotas(int idCotas) {
        this.idCotas = idCotas;
    }
    
    public int getIdPessoa(){
        return this.idPessoa;
    }
    
    public void setIdPessoa(int id){
        this.idPessoa = id;
    }
    
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
