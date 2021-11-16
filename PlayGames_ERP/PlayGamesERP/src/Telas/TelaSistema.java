package Telas;

import Telas.componentes.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public abstract class TelaSistema extends JInternalFrame implements ActionListener {
    //h/ Instanciar Paineis para componentes da tela
    protected JPanel jpBotoesSuperiores = new JPanel();
    protected JPanel jpBotoesInferiores = new JPanel();
    protected JPanel jpComponentes = new JPanel();
    //h/ componentes para montar menubar
    protected JMenuItem jmiIncluir, jmiConsultar, jmiAlterar, jmiExcluir;
    // Definando os padrões de estados para os botões
    private final int PADRAO = 0;
    private final int INCLUINDO = 1;
    private final int ALTERANDO = 2;
    private final int EXCLUINDO = 3;
    private final int CONSULTANDO = 4;
    // Atributo para controle do estado
    private int estadoTela = PADRAO;
    //h/ Lista para armazenar todos os componentes da tela
    public ArrayList<MeuComponente> componentes = new ArrayList();
    
    //h/ Método construtor para esta super classe
    public TelaSistema (String titulo) {
        //h/ Implementar construtor da super classe original
        super(titulo, true, true, true, true);
        //h/ Definir o tamanho inicial da no==va tela
        setSize(800, 600);
        //h/ Adicionar nova janela ao gerenciador
        TelaPrincipal.jdp.add(this);
        //h/ Instanciar Gerenciador de Layout para novas telas
        getContentPane().setLayout(new BorderLayout());
        //h/ Adicionar paineis ao layout principal
        getContentPane().add(jpBotoesSuperiores, "North");
        getContentPane().add(jpComponentes, "West");
        getContentPane().add(jpBotoesInferiores, "South");
        //h/ Definir cor de fundo dos painéis
        jpBotoesSuperiores.setBackground(Color.black);
        jpBotoesInferiores.setBackground(Color.black);
        jpComponentes.setBackground(Color.black);
        //h/ Instanciar Layout para todos os painéis
        jpBotoesSuperiores.setLayout(new GridBagLayout());
        jpComponentes.setLayout(new GridBagLayout());
        jpBotoesInferiores.setLayout(new GridBagLayout());

        //h/ Instanciar janela como visivel
        setVisible(true);
        //h/ Organiza a tela conforme os componentes
        pack();
    }
    
    //h/ metodo para montar menubar
    public void montaMenuOptions() {
        //h/ Instanciar objeto menubar
        JMenuBar jmbOptions = new JMenuBar();
        //h/ Ativar objeto criado
        setJMenuBar(jmbOptions);
        //h/ Instanciar opcoes do menu
        jmiIncluir = new JMenuItem("Incluir");
        jmiConsultar = new JMenuItem("Consultar");
        jmiAlterar = new JMenuItem("Alterar");
        jmiExcluir = new JMenuItem("Excluir");
        //h/ Adicionar opcoes ao menu
        jmbOptions.add(jmiIncluir);
        jmbOptions.add(jmiConsultar);
        jmbOptions.add(jmiAlterar);
        jmbOptions.add(jmiExcluir);
        //h/ Instanciar Action listeners
        jmiIncluir.addActionListener(this);
        jmiConsultar.addActionListener(this);
        jmiAlterar.addActionListener(this);
        jmiExcluir.addActionListener(this);
    }
    
    //h/ Método para instanciar componentes na tela
    protected void adicionaComponentes(JPanel painel,  int linha, int coluna, int quantidadeLinha, int quantidadeColuna, 
        MeuComponente componente) {
        //h/ Variavel para armazenar nome do componente
        String nome = componente.getNome();
        //h/ Instncia método para formatação do nome
        nome = trataLabel(nome, componente);
        //h/ Instanciar Objeto para regras de construção
        GridBagConstraints gbc = new GridBagConstraints();
        //h/ Instanciar Margens de cada Compoente
        gbc.insets = new Insets(2, 5, 2, 5);
        //h/ Instanciar ancoragem dos componentes
        gbc.anchor = GridBagConstraints.WEST;
        //h/ Define posição do nome do componente
        gbc.gridy = linha;
        gbc.gridx = coluna;
        //h/ Define o tamanho do nome do componente
        gbc.gridheight = quantidadeLinha;
        gbc.gridwidth = quantidadeColuna;
        //h/ Instanciar nome do componente
        painel.add(new JLabel(nome), gbc);
        //h/ Define posição do componente
        gbc.gridy = gbc.gridy + quantidadeLinha;
        //h/ Instncia componente
        painel.add((JComponent) componente, gbc);
        //h/ Adiciona o componente a lista
        componentes.add(componente);
    }
    
    //h/ Método para tratar formatação do nome
    private String trataLabel(String nome, MeuComponente componente) {
        nome = "<html><font color=white>" +
                nome +
                "</font></html>";
        //h/ Tratamento de obrigatoriedade
        if (componente.eObrigatorio()) {
            nome = nome + "<html><font color=red>*</font></html";
        }
        return nome;
    }
    
    //h/ metodo de acoes das opcoes no menu
    @Override
    public void actionPerformed(ActionEvent ae){
        //h/ Verificar qual opcao foi selecionada
        if(ae.getSource() == jmiIncluir) {
            //h/ Acao do incluir
            incluir();
        } else if (ae.getSource() == jmiConsultar) {
            //h/ Açao do consultar
            consultar();
        } else if (ae.getSource() == jmiAlterar) {
            //h/ Açao do alterar
            alterar();
        } else if (ae.getSource() == jmiExcluir) {
            //h/ Açao do excluir
            excluir();
        }
    }
    
    //h/ metodos para instaciar acoes do menu
    private void incluir() {
        //h/ Altera o estado da tela
        estadoTela = INCLUINDO;
        //h/ Libera os campos para preenchimento
        habilitaComponentes(true);
        //h/ Define padrao para os itens do menu
        habilitaMenu();
    }
    private void consultar() {
        //h/ Altera o estado da tela
        estadoTela = CONSULTANDO;
        //h/ Libera todos os campos para preenchimento
        habilitaComponentes(true);
        //h/ Define o padrao para os itens do menu
        habilitaMenu();
    }
    private void alterar() {
        //h/ Altera o estado da tela
        estadoTela = ALTERANDO;
        //h/ Libera todos os campos para preenchimento
        habilitaComponentes(true);
        //h/ Define o padrao para os itens do menu
        habilitaMenu();
    }
    private void excluir() {
        //h/ Altera o estado da tela
        estadoTela = EXCLUINDO;
        //h/ bloqueia todos os campos para preenchimento
        habilitaComponentes(false);
        //h/ Define o padrao para os itens do menu
        habilitaMenu();
    }
    protected void cancelar(){
        //h/ define o status dos campos
        habilitaComponentes(false);
        //h/ Limpar todos os campos da tela
        limpaComponentes();
        //h/ define o stado da tela
        estadoTela = PADRAO;
        //h/ habilita o menu
        habilitaMenu();
    }
    protected void salvar() {
        
    }
    
    //h/ metodos para instanciar funcoes de dados
    public abstract boolean incluirDados();
    public abstract boolean consultarDados();
    public abstract boolean alterarDados();
    public abstract boolean excluirDados();
    
    //h/ metodo para definir status dos componentes
    protected void habilitaComponentes(boolean status) {
        //h/ setar o status em todos os componentes da tela
        for (MeuComponente componente : componentes) {
            componente.habilitar(status);
        }
    }
    
    //h/ Metodo para realizar a limpeza dos campos
    protected void limpaComponentes() {
        //h/ setar todos os campos como vazios
        for (MeuComponente componente : componentes) {
            componente.limpar();
        }
    }
    
    //h/ Metodo para habilitar componentes do menu
    protected void habilitaMenu() {
        //h/ Verifica qual o estado atual da tela
        switch (estadoTela) {
            case PADRAO:
                //h/ Define o estado para cada item do menu
                jmiIncluir.setEnabled(true);
                jmiConsultar.setEnabled(true);
                jmiAlterar.setEnabled(false);
                jmiExcluir.setEnabled(false);
                break;
            case INCLUINDO:
                //h/ Define o estado para cada item do menu
                jmiIncluir.setEnabled(false);
                jmiConsultar.setEnabled(false);
                jmiAlterar.setEnabled(false);
                jmiExcluir.setEnabled(false);
                break;
            case CONSULTANDO:
                //h/ Define o estado para cada item do menu
                jmiIncluir.setEnabled(false);
                jmiConsultar.setEnabled(true); 
                jmiAlterar.setEnabled(true);
                jmiExcluir.setEnabled(true);
                break;
            case ALTERANDO:
                //h/ Define o estado para cada item do menu
                jmiIncluir.setEnabled(false);
                jmiConsultar.setEnabled(true);
                jmiAlterar.setEnabled(true);
                jmiExcluir.setEnabled(true);
                break;
            case EXCLUINDO:
                //h/ Define o estado para cada item do menu
                jmiIncluir.setEnabled(false);
                jmiConsultar.setEnabled(true);
                jmiAlterar.setEnabled(true);
                jmiExcluir.setEnabled(false);
                break;
            default:
                break;
        }
    }
}