package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class CadastroClienteJuridico extends TelaSistema {
    private MeuJTextField jtfIdFornecedor = new MeuJTextField(10 ,"Id Fornecedor");
    private MeuJTextField jtfCidade = new MeuJTextField(30 ,"Cidade do Fornecedor");
    private MeuJTextField jtfRazaoSocial = new MeuJTextField(30 ,"Razao Social");
    private MeuJTextField jtfCNPJ = new MeuJTextField(15 ,"CNPJ");
    private MeuJTextField jtfInscricaoEstadual = new MeuJTextField(15 ,"Inscricao Estadual");
    private MeuJTextField jtfTelefone = new MeuJTextField(15 ,"Telefone");
    private MeuJTextField jtfEmail = new MeuJTextField(30 ,"Email");
    private MeuJTextField jtfCep = new MeuJTextField(15 ,"Cep");
    private MeuJTextField jtfEndereco = new MeuJTextField(30 ,"Endereco do Fornecedor");
    private MeuJTextField jtfNumero = new MeuJTextField(6 ,"Numero");
    private MeuJTextField jtfComplemento = new MeuJTextField(30 ,"Complemento");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbSalvar = new MeuJButton("Salvar");
    public CadastroClienteJuridico(){
        
        super("Cadastro Cliente Juridico");
        
        montaTela();
        
        ActionListener();
        //h/ Organizar tela conforme componentes
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 1, 1, 1, jtfIdFornecedor);
        adicionaComponentes(jpComponentes, 3, 1, 1, 1, jtfCidade);
        adicionaComponentes(jpComponentes, 5, 1, 1, 1, jtfRazaoSocial);
        adicionaComponentes(jpComponentes, 7, 1, 1, 1, jtfCNPJ);
        adicionaComponentes(jpComponentes, 9, 1, 1, 1, jtfInscricaoEstadual);
        adicionaComponentes(jpComponentes, 11, 1, 1, 1, jtfTelefone);
        adicionaComponentes(jpComponentes, 13, 1, 1, 1, jtfEmail);
        adicionaComponentes(jpComponentes, 15, 1, 1, 1, jtfCep);
        adicionaComponentes(jpComponentes, 1, 2, 1, 1, jtfEndereco);
        adicionaComponentes(jpComponentes, 3, 2, 1, 1, jtfNumero);
        adicionaComponentes(jpComponentes, 5, 2, 1, 1, jtfComplemento);
        adicionaComponentes(jpBotoesInferiores, 13, 3, 1, 1, jbCancelar);
        adicionaComponentes(jpBotoesInferiores, 13, 4, 1, 1, jbSalvar);
    }
    private void ActionListener(){
        jbCancelar.addActionListener(this);
        jbSalvar.addActionListener(this);
    }
}
