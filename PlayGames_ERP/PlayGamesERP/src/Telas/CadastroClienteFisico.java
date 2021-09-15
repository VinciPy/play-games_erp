package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class CadastroClienteFisico extends TelaSistema {
    private MeuJTextField jtfIdCliente = new MeuJTextField(30, "ID Cliente");
    public CadastroClienteFisico(){
        super("Cadastro Pessoa Fisica");
        
        montaTela();
        
        pack();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 1, 1 ,2 , jtfIdCliente);
    }
    
    private void adicionaListener(){
        jtfIdCliente.addActionListener(this);
    }
}
