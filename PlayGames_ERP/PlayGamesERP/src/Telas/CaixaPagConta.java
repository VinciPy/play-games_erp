package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class CaixaPagConta extends TelaSistema{
    private MeuJTextField jtfCliente = new MeuJTextField(30, "Insira o Cliente");
    private MeuJTextField jtfValorConta = new MeuJTextField(30, "Valor da Conta");
    private MeuJComboBox jcbConta = new MeuJComboBox("Selecione a conta");
    private MeuJTextField jtfAcrescimo = new MeuJTextField(30, "Acrescimo");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbPagar = new MeuJButton("Pagar");
    public CaixaPagConta(){
        super("Pagamento de contas");
        montaTela();
        
        adicionaListener();
        
        pack();  
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
 //int linha, int coluna, int quantidadeLinha, int quantidadeColuna   
    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 1, 1, 1, jtfCliente);
        adicionaComponentes(jpComponentes, 1, 2, 1, 1, jtfValorConta);
        adicionaComponentes(jpComponentes, 3, 1, 1, 1, jcbConta);
        adicionaComponentes(jpComponentes, 3, 2, 1, 1, jtfAcrescimo);
        adicionaComponentes(jpComponentes, 5, 3, 1, 1, jbCancelar);
        adicionaComponentes(jpComponentes, 5, 4, 1, 1, jbPagar);
    }
    
    private void adicionaListener(){
        jbCancelar.addActionListener(this);
        jbPagar.addActionListener(this);
    }
}
