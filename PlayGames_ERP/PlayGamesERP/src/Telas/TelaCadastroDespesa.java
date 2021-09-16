
package Telas;

import java.awt.event.ActionEvent;
import javax.swing.*;
import Telas.componentes.*;


public class TelaCadastroDespesa extends TelaSistema {
    public TelaCadastroDespesa() {
        //h/ Instanciar o super método
        super("Cadastro de Cliente Fornecedor");
        MeuJTextField id = new MeuJTextField(30, "ID");
        MeuJTextField nome = new MeuJTextField(30, "NOME");
        MeuJTextField valor_despesa = new MeuJTextField(30, "VALOR DA DESPESA");
        MeuJTextField data_despesa = new MeuJTextField(30, "DATA_DESPESA");
        MeuJTextField data_vencimento = new MeuJTextField(30, "DATA VENCIMENTO");
        MeuJTextField situacao = new MeuJTextField(30, "SITUAÇÃO");
        adicionaComponentes(jpComponentes, 1, 1, 1 , 1 , id);
        adicionaComponentes(jpComponentes, 3, 1, 1, 1 , nome);
        adicionaComponentes(jpComponentes, 5, 1, 1, 1 , valor_despesa);
        adicionaComponentes(jpComponentes, 7, 1, 1, 1 , data_despesa);
        adicionaComponentes(jpComponentes, 5, 2, 1, 1 , data_vencimento);
        adicionaComponentes(jpComponentes, 7, 2, 1, 1 , situacao);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
