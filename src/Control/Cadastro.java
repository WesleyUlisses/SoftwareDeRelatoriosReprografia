/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.UsuarioDAO;
import Model.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cadastro extends JFrame {

    private JLabel labelNome;
    private JTextField textFieldNome;
    private JLabel labelLogin;
    private JTextField textFieldLogin;
    private JLabel labelSenha;
    private JPasswordField passwordFieldSenha;
    private JLabel labelMatricula;
    private JTextField textFieldMatricula;
    private JButton buttonCadastrar;

    public Cadastro() {
        // Configurações básicas da janela
        setTitle("Cadastro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(720, 420));

        // Inicialização dos componentes
        labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font(labelNome.getFont().getName(), Font.PLAIN, 16));
        textFieldNome = new JTextField(20);
        labelLogin = new JLabel("Login:");
        labelLogin.setFont(new Font(labelLogin.getFont().getName(), Font.PLAIN, 16));
        textFieldLogin = new JTextField(20);
        labelSenha = new JLabel("Senha:");
        labelSenha.setFont(new Font(labelSenha.getFont().getName(), Font.PLAIN, 16));
        passwordFieldSenha = new JPasswordField(20);
        labelMatricula = new JLabel("Matrícula:");
        labelMatricula.setFont(new Font(labelMatricula.getFont().getName(), Font.PLAIN, 16));
        textFieldMatricula = new JTextField(20);
        buttonCadastrar = new JButton("Cadastrar");

        // Layout da interface: GridLayout com duas colunas centralizadas
        setLayout(new GridLayout(0, 2, 10, 10));
        JPanel painel1 = new JPanel();
        painel1.setLayout(new GridLayout(0, 1, 5, 5));
        JPanel painel2 = new JPanel();
        painel2.setLayout(new GridLayout(0, 1, 5, 5));
        add(painel1);
        add(painel2);

        // Adição dos componentes aos painéis
        painel1.add(labelNome);
        painel1.add(labelLogin);
        painel1.add(labelSenha);
        painel1.add(labelMatricula);
        painel2.add(textFieldNome);
        painel2.add(textFieldLogin);
        painel2.add(passwordFieldSenha);
        painel2.add(textFieldMatricula);
        painel1.add(new JLabel()); // espaço em branco para alinhar o botão à direita
        painel2.add(buttonCadastrar);

        // Configuração do ouvinte do botão "Cadastrar"
        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        // Exibição da janela
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método que será chamado quando o botão "Cadastrar" for clicado
    private void cadastrar()
    {
        
        String nome = textFieldNome.getText();
        String login = textFieldLogin.getText();
        String senha = new String(passwordFieldSenha.getPassword());
        String matricula = textFieldMatricula.getText();

        Usuario user = new Usuario();
        
        user.setLogin(login);
        user.setMatricula(matricula);
        user.setNome(nome);
        user.setSenha(senha);
        
        UsuarioDAO novoUser = new UsuarioDAO();
        novoUser.cadastrarUsuario(user);
        
        
    }

}