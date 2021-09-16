package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class CaixaMovimentacao extends TelaSistema{
    private MeuJComboBox jcbTipoMovi = new MeuJComboBox("Selecione o Tipo de Movimentação");
    private MeuJTextField jtfValorConta = new MeuJTextField(30, "Valor");
    private MeuJComboBox jcbConta = new MeuJComboBox("Selecione a conta");
    private MeuJTextField jtfData = new MeuJTextField(10, "Data");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbPagar = new MeuJButton("Pagar");
    public CaixaMovimentacao(){
        super("Movimentação");
        montaTela();
        
        adicionaListener();
        
        pack();  
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
 //int linha, int coluna, int quantidadeLinha, int quantidadeColuna   
    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 1, 1, 1, jcbTipoMovi);
        adicionaComponentes(jpComponentes, 1, 2, 1, 1, jtfValorConta);
        adicionaComponentes(jpComponentes, 3, 1, 1, 1, jcbConta);
        adicionaComponentes(jpComponentes, 3, 2, 1, 1, jtfData);
        adicionaComponentes(jpComponentes, 5, 3, 1, 1, jbCancelar);
        adicionaComponentes(jpComponentes, 5, 4, 1, 1, jbPagar);
    }
    
    private void adicionaListener(){
        jbCancelar.addActionListener(this);
        jbPagar.addActionListener(this);
    }
}