
package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author hedermilani
 */
public class TelaNovasVendasItens extends TelaSistema{
    //h/ Instanciar componentes desta tela
    private MeuJTextField jtfCodigo = new MeuJTextField(30, "Código Produto");
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
        adicionaComponentes(jpBotoesInferiores, 1, 1, 1, 3, jbIncluir);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
