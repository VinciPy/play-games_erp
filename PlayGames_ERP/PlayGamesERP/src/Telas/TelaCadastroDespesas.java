package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;


public class TelaCadastroDespesas extends TelaSistema {
    private MeuJTextField jtfIdDespesa = new MeuJTextField(10, "ID de Despesa");
    private MeuJTextField jtfCadastro = new MeuJTextField(10, "Cadastro");
    private MeuJTextField jtfValor = new MeuJTextField(10, "Valor da Despesa");
    private MeuJTextField jtfDataDespesa = new MeuJTextField(10, "Data da Despesa");
    private MeuJTextField jtfVencimento = new MeuJTextField(10, "Data do Vencimento");
    private MeuJTextField jtfTipoDespesa = new MeuJTextField(15, "Tipo De Despesa");
    private MeuJTextField jtfSituacao = new MeuJTextField(15, "Situacao");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbSalvar = new MeuJButton("Salvar");
    public TelaCadastroDespesas(){
    
        super("Tela Cadastro Despesas");
        
        montaTela();
        
        AdicionaListener();
        
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 1, 1, 1, jtfIdDespesa);
        adicionaComponentes(jpComponentes, 3, 1, 1, 1, jtfCadastro);
        adicionaComponentes(jpComponentes, 5, 1, 1, 1, jtfValor);
        adicionaComponentes(jpComponentes, 1, 2, 1, 1, jtfDataDespesa);
        adicionaComponentes(jpComponentes, 1, 3, 1, 1, jtfVencimento);
        adicionaComponentes(jpComponentes, 3, 2, 1, 1, jtfTipoDespesa);
        adicionaComponentes(jpComponentes, 5, 2, 1, 1, jtfSituacao);
        adicionaComponentes(jpComponentes, 13, 3, 1, 1, jbCancelar);
        adicionaComponentes(jpComponentes, 13, 4, 1, 1, jbSalvar);
    }
    private void AdicionaListener(){
        jbCancelar.addActionListener(this);
        jbSalvar.addActionListener(this);
   }
}