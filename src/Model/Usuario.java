package Model;

import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;


public class Usuario <Generics> extends Pessoa {

    private String login;
    private String senha;
    private boolean usuarioBloqueado = false;
    private int tentativasLogin = 0;
    private int idUsuario;

    public Usuario(){
        this.setNome(null);
        this.setMatricula(null);
        this.login = null;
        this.senha = null;
        this.setOcupacao("Tecnico");

    }
    
    public Usuario(String nome, String matricula, String login, String senha){
        this.setNome(nome);
        this.setMatricula(matricula);
        this.login = login;
        this.senha = senha;
        this.setOcupacao("Tecnico");

    }
    
    
    public void setId(int x){
        idUsuario = x;
    }
    public int getId(){
        return this.idUsuario;
    }
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
    

    public void setBloquear(boolean valor)
    {
        this.usuarioBloqueado = valor;
    }

    public void boquearUsuario()
    {
            this.usuarioBloqueado = true;
    }


    public boolean verificaUsuarioBloqueado()
    {
        return this.usuarioBloqueado;    
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
    
    
    public void setTentativasLogin(int tentativas)
    {
        this.tentativasLogin = tentativas;
    }
    
    public int getTentativasLogin()
    {
        return this.tentativasLogin;
    }

    public String encriptar(String usuario) throws Exception{
        
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte hash[] = algorithm.digest(usuario.getBytes("UTF-8"));

        StringBuilder texto = new StringBuilder();
        for (byte b : hash) {
            texto.append(String.format("%02X",0xFF & b));
        }
        return texto.toString();
    }
}
    