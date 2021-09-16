
package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author hedermilani
 */
public class TelaNovasVendasItens extends TelaSistema{
    //h/ Instanciar componentes desta tela
    private MeuJTextField jtfCodigo = new MeuJTextField(10, "Código Produto");
    private MeuJTextField jtfProduto = new MeuJTextField(20, "Produto");
    private MeuJTextField jtfQuantidade = new MeuJTextField(10, "Quantidade");
    private MeuJTextField jtfDesconto = new MeuJTextField(10, "Desconto");
    private MeuJTextField jtfValorUnitario = new MeuJTextField(10, "Valor Unitário");
    private MeuJTextField jtfValorFinal = new MeuJTextField(15, "Valor Final");
    private MeuJButton jbIncluir = new MeuJButton("Incluir");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbAvancar = new MeuJButton("Avançar");
    
    
    //h/ Método Contrutor Superclasse
    public TelaNovasVendasItens() {
        //h/ Instanciar nome da Tela
        super("Nova Venda");
        //h/ Instanciar método para montagen da tela
        montaTela();
        //h/ Instanciar listeners
        adicionaListeners();
        //h/ Organizar tela conforme componentes
        pack();
    }
    
    //h/ Método para execultar a montagem da tela
    private void montaTela() {
        //h/ Instanciar componentes conforme método da super classe
        adicionaComponentes(jpComponentes, 1, 1, 2, 2, jtfCodigo);
        adicionaComponentes(jpComponentes, 5, 1, 2, 2, jtfProduto);
        adicionaComponentes(jpComponentes, 9, 1, 2, 2, jtfQuantidade);
        adicionaComponentes(jpComponentes, 13, 1, 2, 2, jtfDesconto);
        adicionaComponentes(jpComponentes, 17, 1, 2, 2, jtfValorUnitario);
        //h/ Instanciar botões conforme método da super classe
        adicionaComponentes(jpBotoesInferiores, 1, 1, 1, 3, jbIncluir);
        adicionaComponentes(jpBotoesInferiores, 1, 5, 1, 2, jbCancelar);
        adicionaComponentes(jpBotoesInferiores, 1, 7, 1, 2, jbAvancar);
    }

    @Override 
    public void actionPerformed(ActionEvent ae) {
        //h/ Verifica qual botão foi acionado
        if (ae.getSource() == jbIncluir) {
            //h/ Adicionar dados a lista de itens
            
        } else if (ae.getSource() == jbCancelar) {
            //h/ Cancelar operação
            
        } else if (ae.getSource() == jbAvancar) {
            //h/ Instanciar tela para finalizar venda
            TelaFinalizaVendas finalizaVendas = new TelaFinalizaVendas();
        }
    }
    
    //h/ Método para adicionar Listeners
    private void adicionaListeners() {
        //h/ Instanciar listener ao copmonente
        jbIncluir.addActionListener(this);
        jbCancelar.addActionListener(this);
        jbAvancar.addActionListener(this);
    }
}
