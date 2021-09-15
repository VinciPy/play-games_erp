
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
    
    
    //h/ Método Contrutor Superclasse
    public TelaNovasVendasItens() {
        //h/ Instanciar nome da Tela
        super("Nova Venda");
        //h/ Instanciar método para montagen da tela
        montaTela();
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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
