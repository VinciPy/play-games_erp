package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class TelaPrincipal extends JFrame implements ActionListener {
    //h/ Instanciar gerenciador de janelas do sistema
    public static JDesktopPane jdp = new JDesktopPane();
    //h/ Atributos para composição da barra de menus
    private JMenu jmCadastros, jmLocais, jmCadProdutos,
            jmVendas, 
            jmProdutos;
    //h/ Atributo para composição de itens do menu
    private JMenuItem jmiPessoas, jmiCidades, jmiEstados, jmiPaises, jmiCadastroProdutos, jmiCategorias, 
            jmiNovasVendas, jmiRelatorioVendas,
            jmiEstoque, jmiMovimentacaoProdutos;
    //h/ Atributos para composição dos paineis
    protected JPanel jpPainelLateral = new JPanel();
    protected JPanel jpPainelPrincipal = new JPanel();
    //h/ Botões para painel lateral
    protected JButton jbCadastroProd = new JButton("Cadastro de Produto");
    protected JButton jbCadastroCliFor = new JButton("Cadastro de Cliente e Fornecedor");
    protected JButton jbNovasVendas = new JButton("Novas Vendas");
    protected JButton jbRelatorioVendas = new JButton("Relatório de Vendas");
    protected JButton jbEstoque = new JButton("Estoques");
    protected JButton jbMovimentacaoProdutos = new JButton("Movimentação de Produto");

    //h/ Método para Instanciar uma nova tela
    public TelaPrincipal (String titulo) {
        //h/ Intanciar tela conforme API da super classe
        super(titulo);
        //h/ Define o tamanho inicial da tela
        setSize(1425, 800);
        //h/ Define botão de fechar como encerramento do programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //h/ Instanciar método para montar barra de menu
        montaMenu();
        //h/ Instanciar Layout para tela principal
        getContentPane().setLayout(new BorderLayout());
        //h/ Instanciar painéis ao layout
        getContentPane().add(jpPainelLateral, "West");
        getContentPane().add(jpPainelPrincipal, "Center");
        //h/ Instancia cor de fundo dos painéis
        jpPainelLateral.setBackground(Color.GRAY);
        jpPainelPrincipal.setBackground(Color.black);
        //h/ Instanciar layout para painel lateral
        jpPainelLateral.setLayout(new GridLayout(13, 1));
        //h/ Adicionar botões ao painel lateral
        adicionaBotoes(jbCadastroCliFor);
        adicionaBotoes(jbCadastroProd);
        adicionaBotoes(jbEstoque);
        adicionaBotoes(jbMovimentacaoProdutos);
        adicionaBotoes(jbNovasVendas);
        adicionaBotoes(jbRelatorioVendas);
        //h/ Instanciar gerenciador de janelas para painel principal
        jpPainelPrincipal.add(jdp);
        
        //h/ Definir a tela como visivel
        setVisible(true);
    }

    //h/ Método para montar a barra de menus
    private void montaMenu () {
        //h/ criar novo objeto barra de menu
        JMenuBar jmbTopo = new JMenuBar();
        //h/ Instanciar nova barra de menu
        setJMenuBar(jmbTopo);
        //h/ Instanciar novo menu
        jmCadastros = new JMenu("Cadastros");
        jmVendas = new JMenu("Vendas");
        jmProdutos = new JMenu("Produtos");
        //h/ Adicionar menus a barra
        jmbTopo.add(jmCadastros);
        jmbTopo.add(jmVendas);
        jmbTopo.add(jmProdutos);
        //h/ Intanciar os submenus
        jmLocais = new JMenu("Cadastro de Locais");
        jmCadProdutos = new JMenu("Cadastro de Produtos");
        //h/ Instanciar os itens do menu
        montaItensMenu();
        //h/ Instanciar ações dos itens do menu
        adicionaListener();
    }

    //h/ Método para montar os itens que compõem o menu
    private void montaItensMenu() {
        //h/ Instanciar itens do menu
        jmiPessoas = new JMenuItem("Cliente e Fornecedor");
        jmiCidades = new JMenuItem("Cidades");
        jmiEstados = new JMenuItem("Estados");
        jmiPaises = new JMenuItem("Paises");
        jmiCadastroProdutos = new JMenuItem("Produtos");
        jmiCategorias = new JMenuItem("Categoria de Produtos");
        jmiNovasVendas = new JMenuItem("Nova Venda");
        jmiRelatorioVendas = new JMenuItem("Relatório de Vendas");
        jmiEstoque = new JMenuItem("Relatório de Estoque");
        jmiMovimentacaoProdutos = new JMenuItem("Movimentação de produtos");
        //h/ Adicionar itens ao menu
        jmCadastros.add(jmiPessoas);
        jmVendas.add(jmiNovasVendas);
        jmVendas.add(jmiRelatorioVendas);
        jmProdutos.add(jmiEstoque);
        jmProdutos.add(jmiMovimentacaoProdutos);
        //h/ adicionar submenu ao menu
        jmCadastros.add(jmLocais);
        jmProdutos.add(jmCadProdutos); //verificar com professor
        //h/ Adicionar itens ao submenu
        jmLocais.add(jmiCidades);
        jmLocais.add(jmiEstados);
        jmLocais.add(jmiPaises);
        //h/ Adicionar submenu de produtos
        jmCadastros.add(jmCadProdutos);
        //h/ Adicionar itens ao submenu
        jmCadProdutos.add(jmiCadastroProdutos);
        jmCadProdutos.add(jmiCategorias);
    }

    //h/ Método para ativação do ActionListener de ações do menu
    private void adicionaListener() {
        //h/ Instancia ActionListener de cada item da barra de menu
        jmiPessoas.addActionListener(this);
        jmiCidades.addActionListener(this);
        jmiEstados.addActionListener(this);
        jmiPaises.addActionListener(this);
        jmiCadastroProdutos.addActionListener(this);
        jmiCategorias.addActionListener(this);
        jmiNovasVendas.addActionListener(this);
        jmiRelatorioVendas.addActionListener(this);
        jmiEstoque.addActionListener(this);
        jmiMovimentacaoProdutos.addActionListener(this);
        //h/ Instancia ActionListener de cada botão do menu lateral
        jbCadastroCliFor.addActionListener(this);
        jbCadastroProd.addActionListener(this);
        jbEstoque.addActionListener(this);
        jbMovimentacaoProdutos.addActionListener(this);
        jbNovasVendas.addActionListener(this);
        jbRelatorioVendas.addActionListener(this);
    }

    //h/ Método para ações a serem realizadas pelo ActionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        //h/ Verifica qual dos itens do menu esta chamando a ação
        if ((ae.getSource() == jmiPessoas) || (ae.getSource() == jbCadastroCliFor)){
            //h/ Instanciar tela conforme classe TelaSistema

            System.out.print("Cadastro de Pessoas");
            
        } else if ((ae.getSource() == jmiCadastroProdutos) || (ae.getSource() == jbCadastroProd)) {
            //h/ Instanciar tela de cadastro de produto conforme classe TelaSistema
            System.out.print("Olá Mundo");
            TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(); // Verificar com professor
            
        } else if (ae.getSource() == jmiCidades) {
            //h/ Instanciar tela de cadastro de cidades
            
        } else if (ae.getSource() == jmiEstados) {
            //h/ Instanciar tela de cadastro de estados
            
        } else if (ae.getSource() == jmiPaises) {
            //h/ Instanciar tela de cadastro de paises
            
        } else if (ae.getSource() == jmiCategorias) {
            //h/ Instanciar tela para cadastro de categoria de produtos
            
        } else if ((ae.getSource() == jmiNovasVendas) || (ae.getSource() == jbNovasVendas)) {
            //h/ Instanciar tela para iniciar uma nova venda
            
        } else if ((ae.getSource() == jmiRelatorioVendas) || (ae.getSource() == jbRelatorioVendas)) {
            //h/ Instanciar tela para relatorio de vendas
            
        } else if ((ae.getSource() == jmiEstoque) || (ae.getSource() == jbEstoque)) {
            //h/ Instanciar tela para relatório de estoque
            
        } else if ((ae.getSource() == jmiMovimentacaoProdutos) || (ae.getSource() == jbMovimentacaoProdutos)) {
            //h/ Instanciar tela para entrada de produto no estoque
            
        } 
    }

    //h/ Método para adicionar botões ao painel lateral da tela principal
    protected void adicionaBotoes ( JButton botao) {
        //h/ Instancia botões no painel lateral
        jpPainelLateral.add(botao);
        //h/ Adiciona função ao novo botão
        botao.addActionListener(this);
    }
}
