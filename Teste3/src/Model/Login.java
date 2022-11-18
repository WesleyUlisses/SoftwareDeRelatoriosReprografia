package Model;

import java.security.MessageDigest;

public class Login {
    private String login;
    private String senha;
    private int tentativasLogin = 0;
    private boolean secaoAtiva;

    public void bloquearUsuario(int tentativasLogin)
    {
        if(tentativasLogin == 3) {
            //Bloquear usuario e retorna uma mensagem que ele foi bloqueado
        }
    }


    public Usuario autentificacaoUsuario(String login, String senha) throws Exception
    
    {
        this.login = encriptar(login);
        this.senha = encriptar(senha);

        //Aqui fazemos procuramos o hash de login e senha cadastradas no BD e por fim, se encontramos o usuário retornamos o usuario
        return null;
    }

    public int getTentativasLogin()
    {
        return this.tentativasLogin;
    }
    public boolean liberarAcesso() {
        //Me retorna um usuario, se o usuario for nulo, entao autentifico o usuari

        try {
            
            if ((this.autentificacaoUsuario(login, senha) ) == null) {
                //Liberamos acesso, CONSULTA NO BANCOOO
            } else {
                //Informamos que o login ou senha estão incorretos
                tentativasLogin++;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false; //FAZER CORREÇÃO
    }
    
    public boolean secaoAtiva() {
        secaoAtiva = liberarAcesso();
        return secaoAtiva;
    }


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

