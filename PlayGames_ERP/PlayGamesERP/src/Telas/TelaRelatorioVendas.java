
package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;


public class TelaRelatorioVendas extends TelaSistema {
    
    private MeuJTextField jtfDataInicial = new MeuJTextField(15 ,"Data Inicial");
    private MeuJTextField jtfDataFinal = new MeuJTextField(15 ,"Data Final");
    private MeuJTextField jtfCliente = new MeuJTextField(15 ,"Cliente");
    private MeuJTextField jtfId = new MeuJTextField(15 ,"Id");
    private MeuJTextField jtfPagamento = new MeuJTextField(15 ,"Forma de Pagamento");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbSalvar = new MeuJButton("Salvar");
    
    public TelaRelatorioVendas(){
        
        super("Relatorio de Vendas");
        
        montaTela();
        
        ActionListener();
        
        pack();
                
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    private void montaTela() {
       adicionaComponentes(jpComponentes ,1 ,1 ,1 ,1 ,jtfDataInicial);
       adicionaComponentes(jpComponentes ,1 ,2 ,1 ,1 ,jtfDataFinal);
       adicionaComponentes(jpComponentes ,1 ,3 ,1 ,1 ,jtfCliente);
       adicionaComponentes(jpComponentes ,3 ,1 ,1 ,1 ,jtfId);
       adicionaComponentes(jpComponentes ,3 ,3 ,1 ,1 ,jtfPagamento);
       adicionaComponentes(jpComponentes, 13, 3, 1, 1, jbCancelar);
       adicionaComponentes(jpComponentes, 13, 4, 1, 1, jbSalvar);
    }

    private void ActionListener() {
       jbCancelar.addActionListener(this);
       jbSalvar.addActionListener(this);
    }
}
