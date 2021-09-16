package Telas;

import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class CadastroClienteFisico extends TelaSistema {
    private MeuJTextField jtfIdCliente = new MeuJTextField(30, "ID Cliente");
    private MeuJTextField jtfCidadeCliente = new MeuJTextField(30, "Cidade Do Cliente");
    private MeuJTextField jtfNomeCliente = new MeuJTextField(30, "Nome Do Cliente");
    private MeuJTextField jtfCpfCliente = new MeuJTextField(15, "Cpf do Cliente");
    private MeuJTextField jtfRgCliente = new MeuJTextField(14, "Rg do Cliente");
    private MeuJTextField jtfTelefone = new MeuJTextField(25, "Telefone do Cliente");
    private MeuJTextField jtfEmail = new MeuJTextField(30, "Email do Cliente");
    private MeuJTextField jtfCep = new MeuJTextField(10, "CEP");
    private MeuJTextField jtfEndereco = new MeuJTextField(30, "Endereco do cliente");
    private MeuJTextField jtfNumeroCasa = new MeuJTextField(10, "Numero");
    private MeuJTextField jtfComplemento = new MeuJTextField(30, "Complemento");
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbSalvar = new MeuJButton("Salvar");
    public CadastroClienteFisico(){
        super("Cadastro Pessoa Fisica");
        
        montaTela();
        
        adicionaListener();
        
        pack();  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
//(JPanel painel, int linha, int coluna, int quantidadeLinha, int quantidadeColuna,
    private void montaTela() {
        adicionaComponentes(jpComponentes, 1, 1, 1, 1, jtfIdCliente);
        adicionaComponentes(jpComponentes, 3, 1, 1 ,1, jtfCidadeCliente);
        adicionaComponentes(jpComponentes, 5, 1, 1 ,1, jtfNomeCliente);
        adicionaComponentes(jpComponentes, 7, 1, 1 ,1, jtfCpfCliente);
        adicionaComponentes(jpComponentes, 9, 1, 1 ,1, jtfRgCliente);
        adicionaComponentes(jpComponentes, 11, 1, 1 ,1, jtfTelefone);
        adicionaComponentes(jpComponentes, 13, 1, 1 ,1, jtfEmail);
        adicionaComponentes(jpComponentes, 1, 2, 1 ,1, jtfCep);
        adicionaComponentes(jpComponentes, 3, 2, 1, 1, jtfEndereco);
        adicionaComponentes(jpComponentes, 5, 2, 1 ,1, jtfNumeroCasa);
        adicionaComponentes(jpComponentes, 7, 2, 1, 1, jtfComplemento);
        adicionaComponentes(jpBotoesInferiores, 13, 3, 1, 1, jbCancelar);
        adicionaComponentes(jpBotoesInferiores, 13, 4, 1, 1, jbSalvar);
    }
    
    private void adicionaListener(){
        jbCancelar.addActionListener(this);
        jbSalvar.addActionListener(this);
    }
}
