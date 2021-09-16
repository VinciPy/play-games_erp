package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class TelaCaixa extends TelaSistema {
    private MeuJButton jbCaixaMovimentacao = new MeuJButton("Incluir Movimentação");
    private MeuJButton jbCaixaPagConta =new MeuJButton("Pagar Conta");
    //h/ Método contrutor da super classe
    public TelaCaixa() {
        //h/ Instanciar o super método
        super("Caixa");
        
        montaTela();
        adicionaListener();
        
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() == jbCaixaMovimentacao)){
            CaixaMovimentacao caixaMovimentacao = new CaixaMovimentacao();
        }else if((e.getSource() == jbCaixaPagConta)){
            CaixaPagConta caixaPagConta = new CaixaPagConta();
        }
    }

    private void montaTela() {
        adicionaComponentes(jpBotoesSuperiores, 1, 1, 1, 2, jbCaixaMovimentacao);
        adicionaComponentes(jpBotoesSuperiores, 1, 3, 1, 2, jbCaixaPagConta);
    }
    
    private void adicionaListener(){
        jbCaixaMovimentacao.addActionListener(this);
        jbCaixaPagConta.addActionListener(this);
    }

    
}
