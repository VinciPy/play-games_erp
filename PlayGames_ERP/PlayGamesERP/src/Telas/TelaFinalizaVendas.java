
package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

/**
 * @author hedermilani
 */
public class TelaFinalizaVendas extends TelaSistema{
    //h/ Instanciar componentes da tela
    private MeuJComboBox jcbPagamento = new MeuJComboBox("Forma de Pagamento");
    private MeuJTextField jtfData = new MeuJTextField(15, "Data");
    private MeuJTextField jtfValorVenda = new MeuJTextField(15, "Valor Venda");
    private MeuJTextField jtfDescontoFinal = new MeuJTextField(15, "Desconto Final");
    private MeuJTextField jtfValorFinal = new MeuJTextField(15, "Valor Final");
    private MeuJTextField jtfDataPagamento = new MeuJTextField(15, "Data Pagamento");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbSalvar = new MeuJButton("Salvar");

    public TelaFinalizaVendas() {
        super("Finaliza Venda");
        //h/ Instanciar método para montagen da tela
        montaTela();
        //h/ Instanciar listeners
        adicionaListeners();
        //h/ Organizar tela conforme componentes
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //h/ Verificar qual Botao foi acionado
        if (ae.getSource() == jbCancelar) {
            //h/ Cancelar Operação
            
        } else if (ae.getSource() == jbSalvar) {
            //h/ Salvar operação
            
        }
    }

    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 6, 2, 2, jcbPagamento);
        adicionaComponentes(jpComponentes, 5, 6, 2, 2, jtfData);
        adicionaComponentes(jpComponentes, 9, 6, 2, 2, jtfValorVenda);
        adicionaComponentes(jpComponentes, 13, 6, 2, 2, jtfDescontoFinal);
        adicionaComponentes(jpComponentes, 17, 6, 2, 2, jtfValorFinal);
        adicionaComponentes(jpComponentes, 21, 6, 2, 2, jtfDataPagamento);
        adicionaComponentes(jpBotoesInferiores, 1, 5, 2, 2, jbCancelar);
        adicionaComponentes(jpBotoesInferiores, 1, 7, 2, 2, jbSalvar);
    }

    private void adicionaListeners() {
        jbCancelar.addActionListener(this);
        jbSalvar.addActionListener(this);
    }
    
}
