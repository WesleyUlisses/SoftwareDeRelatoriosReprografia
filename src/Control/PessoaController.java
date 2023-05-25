/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.PessoaDAO;
import Model.Pessoa;

/**
 *
 * @author SAMSUNG
 */
public class PessoaController {
    
    
    public void CadastrarPessoaNoBanco(Pessoa pessoa){
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        pessoaDAO.Cadastrar(pessoa);
    }
}
