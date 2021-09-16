package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class TelaCadastroPessoas extends TelaSistema {
    private MeuJButton jbCadastroFisica = new MeuJButton("Pessoa Fisica");
    private MeuJButton jbCadastroJuridico =new MeuJButton("Pessoa Juridica");
    //h/ Método contrutor da super classe
    public TelaCadastroPessoas() {
        //h/ Instanciar o super método
        super("Cadastro de Cliente Fornecedor");
        
        montaTela();
        adicionaListener();
        
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() == jbCadastroFisica)){
            CadastroClienteFisico cadastroClienteFisico = new CadastroClienteFisico();
        }else if((e.getSource() == jbCadastroJuridico)){
            CadastroClienteJuridico cadastroClienteJuridico = new CadastroClienteJuridico();
        }
    }

    private void montaTela() {
        adicionaComponentes(jpBotoesSuperiores, 1, 1, 1, 2, jbCadastroFisica);
        adicionaComponentes(jpBotoesSuperiores, 1, 3, 1, 2, jbCadastroJuridico);
    }
    
    private void adicionaListener(){
        jbCadastroFisica.addActionListener(this);
        jbCadastroJuridico.addActionListener(this);
    }

    
}
