package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame implements ActionListener {
    //h/ Instanciar gerenciador de janelas do sistema
    public static JDesktopPane jdp = new JDesktopPane();
    //h/ Atributos para composição da barra de menus
    private JMenu jmCadastros, jmLocais;
    //h/ Atributo para composição de itens do menu
    private JMenuItem jmiPessoas, jmiCidades, jmiEstados, jmiPaises;
    //h/ Atributos para composição dos paineis
    protected JPanel jpPainelLateral = new JPanel();
    protected JPanel jpPainelPrincipal = new JPanel();
    //h/ Botões para painel lateral
    protected JButton jbCadastros = new JButton("Cadastro");

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
        //h/ Instanciar layout para painel lateral
        jpPainelLateral.setLayout(new GridBagLayout());
        //h/ Adicionar botões ao painel lateral
        adicionaBotoes(4, 1, 1, 1, jbCadastros);
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
        //h/ Adicionar menus a barra
        jmbTopo.add(jmCadastros);
        //h/ Intanciar um submenu
        jmLocais = new JMenu("Locais");
        //h/ Instanciar os itens do menu
        montaItensMenu();
        //h/ Instanciar ações dos itens do menu
        adicionaListener();
    }

    //h/ Método para montar os itens que compõem o menu
    private void montaItensMenu() {
        //h/ Instanciar itens do menu
        jmiPessoas = new JMenuItem("Pessoas (Cli/For)");
        jmiCidades = new JMenuItem("Cidades");
        jmiEstados = new JMenuItem("Estados");
        jmiPaises = new JMenuItem("Paises");
        //h/ Adicionar itens ao menu
        jmCadastros.add(jmiPessoas);
        //h/ adicionar submenu ao menu
        jmCadastros.add(jmLocais);
        //h/ Adicionar itens ao submenu
        jmLocais.add(jmiCidades);
        jmLocais.add(jmiEstados);
        jmLocais.add(jmiPaises);
    }

    //h/ Método para ativação do ActionListener de ações do menu
    private void adicionaListener() {
        //h/ Instancia ActionListener de cada item do menu
        jmiPessoas.addActionListener(this);
        jmiCidades.addActionListener(this);
        jmiEstados.addActionListener(this);
        jmiPaises.addActionListener(this);
    }

    //h/ Método para ações a serem realizadas pelo ActionListener
    public void actionPerformed(ActionEvent ae) {
        //h/ Verifica qual dos itens do menu esta chamando a ação
        if ((ae.getSource() == jmiPessoas) || (ae.getSource() == jbCadastros)){
            //h/ Instanciar tela conforme classe TelaSistema
//            TelaCadastroPessoas telaCadastroPessoas = new TelaCadastroPessoas();
            JFrame frame = new JFrame(); 
            frame.setBounds(10,10,700,600); 
            frame.setVisible(true);
            
        }
    }

    //h/ Método para adicionar botões ao painel lateral da tela principal
    protected void adicionaBotoes (int linha, int coluna, int quantidadeLinhas, int quantidadeColunas, JButton botao) {
        //h/ Instanciar objeto para regras do layout
        GridBagConstraints gbc = new GridBagConstraints();
        //h/ Instanciar ancoragem do layout
        gbc.anchor = GridBagConstraints.WEST;
        // Instancia posições onde ficará o componente
        gbc.gridy = linha;
        gbc.gridx = coluna;
        // Instancia a quantidade de linha e coluna cada componente ocupa
        gbc.gridheight = quantidadeLinhas;
        gbc.gridwidth = quantidadeColunas;
        //h/ Instanciar um novo botão no painel lateral
        jpPainelLateral.add(botao, gbc);
        //h/ Adiciona função ao novo botão
        botao.addActionListener(this);
    }
}
