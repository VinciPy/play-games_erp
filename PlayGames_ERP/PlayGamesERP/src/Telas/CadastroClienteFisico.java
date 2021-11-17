package Telas;

import BancoDados.Dao.CadastroDao;
import BancoDados.Pojo.Cadastro;
import Telas.componentes.*;
import java.awt.event.ActionEvent;

public class CadastroClienteFisico extends TelaSistema {
    private MeuJTextField jtfIdCliente = new MeuJTextField(30, "ID Cliente", true);
    private MeuJTextField jtfCidadeCliente = new MeuJTextField(30, "Cidade Do Cliente", true);
    private MeuJTextField jtfNomeCliente = new MeuJTextField(30, "Nome Do Cliente", true);
    private MeuJTextField jtfCpfCliente = new MeuJTextField(15, "Cpf do Cliente", true);
    private MeuJTextField jtfRgCliente = new MeuJTextField(14, "Rg do Cliente", true);
    private MeuJTextField jtfTelefone = new MeuJTextField(25, "Telefone do Cliente", true);
    private MeuJTextField jtfEmail = new MeuJTextField(30, "Email do Cliente", true);
    private MeuJTextField jtfCep = new MeuJTextField(10, "CEP", true);
    private MeuJTextField jtfEndereco = new MeuJTextField(30, "Endereco do cliente", true);
    private MeuJTextField jtfNumeroCasa = new MeuJTextField(10, "Numero", true);
    private MeuJTextField jtfComplemento = new MeuJTextField(30, "Complemento", false);
    private MeuJCheckBox jcbStatus = new MeuJCheckBox("Ativo: ", true);
    private MeuJButton jbCancelar = new MeuJButton("Cancelar");
    private MeuJButton jbSalvar = new MeuJButton("Confirmar");
    //h/ Instanciar objetos para SQL
    private Cadastro cadastro = new Cadastro();
    private CadastroDao cadastroDao = new CadastroDao();
    
    public CadastroClienteFisico(){
        super("Cadastro Pessoa Fisica");
        
        montaTela();
        
        montaMenuOptions();
        
        adicionaListener();
        
        pack();  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //h/ Verificar qual botao foi instanciado
        if (ae.getSource() == jbSalvar) {
            //h/ Açao do botao salvar
            salvar();
        } else if (ae.getSource() == jbCancelar) {
            //h/ Açao do botao cancelar
            cancelar();
        }
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
        adicionaComponentes(jpComponentes, 13, 3, 1, 1, jbCancelar);
        adicionaComponentes(jpComponentes, 13, 4, 1, 1, jbSalvar);
        adicionaComponentes(jpComponentes, 9, 4, 1, 1, jcbStatus);
    }
    
    private void adicionaListener(){
        jbCancelar.addActionListener(this);
        jbSalvar.addActionListener(this);
    }
    
    //h/ Metodo para passar dados para o banco
    @Override
    public boolean incluirDados() {
        //h/ Setar os dados para o pojo
        adicionaPojo();
        //h/ Instanciar metodo para incluir os dados
        return cadastroDao.inserir(cadastro);
    }

    @Override
    public boolean consultarDados() {
        //h/ Setar parametro para pesquisa
        cadastro.setBp(Integer.parseInt(jtfIdCliente.getText()));
        //h/ Realizar consulta
        if (cadastroDao.consultar(cadastro)) {
            jtfCidadeCliente.setText(String.valueOf(cadastro.getIdCidade()));
            jtfNomeCliente.setText(cadastro.getNomeRazao());
            jtfCpfCliente.setText(String.valueOf(cadastro.getCpfCnpj()));
            jtfRgCliente.setText(String.valueOf(cadastro.getRgInscric()));
            jtfTelefone.setText(String.valueOf(cadastro.getTelefone()));
            jtfEmail.setText(cadastro.getEmail());
            jtfEndereco.setText(cadastro.getEndereco());
            jtfNumeroCasa.setText(String.valueOf(cadastro.getNumero()));
            jtfCep.setText(String.valueOf(cadastro.getCep()));
            jtfComplemento.setText(cadastro.getComplemento());
            jcbStatus.setEnabled(cadastro.getStatus());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean alterarDados() {
        //h/ Setar dados para banco
        adicionaPojo();
        //h/ Instanciar metodo para alterar dados do banco
        return cadastroDao.alterar(cadastro);
    }

    @Override
    public boolean excluirDados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //h/ Metodo para adicionar os dados do banco
    private void adicionaPojo() {
        cadastro.setBp(Integer.parseInt(jtfIdCliente.getText()));
        cadastro.setIdCidade(Integer.parseInt(jtfCidadeCliente.getText()));
        cadastro.setNomeRazao(jtfNomeCliente.getText());
        cadastro.setCpfCnpj(Integer.parseInt(jtfCpfCliente.getText()));
        cadastro.setRgInscric(Integer.parseInt(jtfRgCliente.getText()));
        cadastro.setTelefone(Integer.parseInt(jtfTelefone.getText()));
        cadastro.setEmail(jtfEmail.getText());
        cadastro.setEndereco(jtfEndereco.getText());
        cadastro.setnumero(Integer.parseInt(jtfNumeroCasa.getText()));
        cadastro.setCep(Integer.parseInt(jtfCep.getText()));
        cadastro.setComplemento(jtfComplemento.getText());
        cadastro.setStatus(jcbStatus.isSelected());
    }
}
