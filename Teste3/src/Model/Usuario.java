package Model;

import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JOptionPane;


public class Usuario <Generics> extends Pessoa {

    private String login;
    private String senha;
    private boolean bloquear = false;
    
    //Person registration
    public void cadastrarPessoa(String nome, String matricula, String ocupacao)
    {
                
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setOcupacao(ocupacao);
        
    }

    //User registration
    public void cadastrarUsuario(String nome, String matricula, String login, String senha)
    {
        
        this.setNome(nome);
        this.setMatricula(matricula);
        this.login = login;
        this.senha = senha;
        this.setOcupacao("Tecnico");
        
    }
    
    //Return Objetct Pessoa with adress memory
    public Pessoa buscarPorMatricula(String matricula, LinkedList<Pessoa> lista)
    {
        //Return this object
        Pessoa pessoa = new Pessoa();

        //Research in the list
        for(int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).getMatricula().equalsIgnoreCase(matricula))
            {
                pessoa = lista.get(i);
                return pessoa;
            }
        }

                return null;
    }
    

    //Return a Stack with objetcts Pessoa
    public Stack<Pessoa> buscarPorNome(String nome, LinkedList<Pessoa> lista)
    {
        //Lista Retornada, Pilha
        Stack pilha  = new Stack<Pessoa>();
        
        //Busca na Lista e inserção na nova estrutura
        for(int i = 0; i <  lista.size(); i++)
        {
            if(lista.get(i).getNome().equalsIgnoreCase(nome))
            {
                pilha.push(lista.get(i));
            }
        }
        

        //Retorno 
        return pilha;
    }
    
    //Return Objetct Pessoa with adress memory, that you can change some informations
    public Stack <Pessoa> buscaPorOcupacao(String ocupacao, LinkedList<Pessoa> lista)
    {

        Stack pilha  = new Stack<Pessoa>();
        
        //Busca na Lista e inserção na nova estrutura
        for(int i = 0; i <  lista.size(); i++)
        {
            if(lista.get(i).getOcupacao().equalsIgnoreCase(ocupacao))
            {
                pilha.push(lista.get(i));
            }
        }
        

        //Retorno 
        return pilha;
    }


    public Usuario buscaUsuario(String login, String matricula, LinkedList<Usuario> lista){
         //Return this object
         Usuario usuario = new Usuario();

         //Research in the list
         for(int i = 0; i < lista.size(); i++)
         {
             if(lista.get(i).getMatricula().equalsIgnoreCase(matricula) && lista.get(i).getLogin().equalsIgnoreCase(login))
             {
                 usuario = lista.get(i);
                 return usuario;
             }
         }
 
                 return null;
    }

    //Remove a Pessoa of data base
    public void removerPessoa(String matricula, LinkedList<Pessoa> lista)//Add a data structure
    {
        //Busca pessoa
        Pessoa pessoa = buscarPorMatricula(matricula, lista);

        //Setar valores null
        pessoa.setMatricula(null);
        pessoa.setNome(null);
        pessoa.setOcupacao(null);

        //Retornar o objeto null, ou a lista alterada
        JOptionPane.showMessageDialog(null,"Pessoa Removida Com Sucesso!");
    }
     
    //Remove a User of data base
    public void removerUsuario(String login, String matricula, LinkedList lista)//Add a data structure
    {
        Usuario user = buscaUsuario(login, matricula, lista);

        user.setLogin(null);
        user.setMatricula(null);
        user.setNome(null);
        user.setOcupacao(null);
        user.setSenha(null);
    }
    
    //Testing if this new register has a looks like register
    public boolean comparaUsuarioCadastrados(String matricula, LinkedList<Usuario> lista)//Add a data structure
    {
        //Comparação de todos os itens
        for(int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).getMatricula().equalsIgnoreCase(matricula))
            {
                return true;
            }
        }
        //Caso encontrou um objeto ele retornará um valor booleano
        return false;
    }
    
    //Testing if this new register has a looks like register
    public boolean comparaPessoaCadastradas(String matricula, LinkedList<Pessoa> lista)
    {
        //Comparação de todos os itens
        for(int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).getMatricula().equalsIgnoreCase(matricula))
            {
                return true;
            }
        }
        //Caso encontrou um objeto ele retornará um valor booleano
        return false;
    }

    private void setBloquear(boolean valor)
    {
        this.bloquear = valor;
    }

    public void boquearUsuario(Login login, Usuario usuario)
    {
        if(login.getTentativasLogin() > 2)
        {
            this.bloquear = true;
        }
    }

    public void desbloquearUsuario(Usuario usuario)
    {
        if(usuario.verificaUsuarioBloqueado() == true)
        {
            usuario.setBloquear(false);
        }
    }

    public boolean verificaUsuarioBloqueado()
    {
        if(this.bloquear == true)
        {
            return true;
        }
        else
        {
            return false;
        }    
    }

    //printing for the person, with your object
    public void imprimirCotas(String nome, String matricula, String ocupacao, int quantidade)
    {
        JOptionPane.showMessageDialog(null,"Impressão feita com sucesso");
    }
    
    //the first printing for the person, need your datas
    public void imprimirCotasPrimeiraVez(String nome,String matricula,String ocupacao, int quantidade) //register in the data base
    {
        
    }
    
    
    public void RelatorioAnual()
    {
        
    }
    
    public void relatorioMensal()
    {
        
    }
    
    public void relatorioSemanal()
    {
        
    }
    
    public void relatorioDiario()
    {
        
    }
    
    
    public String getLogin() 
    {
        return login;
    }
    
    public void setLogin(String login) 
    {
        this.login = login;
    }
    
    public String getSenha() 
    {
        return senha;
    }
    
    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    //Funcao para aplicarmos o hash para criar senha no banco de dados e buscar senha no BD quando o usuario logar
    public static String encriptar(String usuario) throws Exception{
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte hash[] = algorithm.digest(usuario.getBytes("UTF-8"));
    
        StringBuilder texto = new StringBuilder();
        for (byte b : hash) {
            texto.append(String.format("%02X",0xFF & b));
        }
        return texto.toString();
    }
}
    