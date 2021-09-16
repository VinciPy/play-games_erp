
package Telas;

import java.awt.event.ActionEvent;
import javax.swing.*;
import Telas.componentes.*;


public class TelaRelatorioFinanceiro extends TelaSistema {
    public TelaRelatorioFinanceiro() {
        //h/ Instanciar o super método
        super("Cadastro de Cliente Fornecedor");
        MeuJButton pessoa_fisica = new MeuJButton("Contas A Receber");
        MeuJButton pessoa_juurida = new MeuJButton("Contas A Pagar");
        MeuJTextField id = new MeuJTextField(30, "Contas A Pagar");
        MeuJTextField nome = new MeuJTextField(30, "FORNECEDOR / CLIENTE");
        MeuJTextField data_inicial = new MeuJTextField(30, "DATA INICIAL");
        MeuJTextField data_final = new MeuJTextField(30, "DATA FINAL");
        adicionaComponentes(jpComponentes, 1, 1, 1 , 1 , pessoa_fisica);
        adicionaComponentes(jpComponentes, 3, 1, 1, 1 , pessoa_juurida);
        adicionaComponentes(jpComponentes, 5, 1, 1, 1 , id);
        adicionaComponentes(jpComponentes, 7, 1, 1, 1 , nome);
        adicionaComponentes(jpComponentes, 5, 2, 1, 1 , data_inicial);
        adicionaComponentes(jpComponentes, 7, 2, 1, 1 , data_final);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
