package Telas;

import Telas.componentes.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class TelaSistema extends JInternalFrame implements ActionListener {
    //h/ Instanciar Paineis para componentes da tela
    protected JPanel jpBotoesSuperiores = new JPanel();
    protected JPanel jpBotoesInferiores = new JPanel();
    protected JPanel jpComponentes = new JPanel();
    
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
    
    //h/ Método para instanciar componentes na tela
    protected void adicionaComponentes(JPanel painel,  int linha, int coluna, int quantidadeLinha, int quantidadeColuna, 
        MeuComponente componente) {
        //h/ Variavel para armazenar nome do componente
        String nome = componente.getNome();
        //h/ Instncia método para formataão do nome
        nome = trataLabel(nome);
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
    }
    
    //h/ Método para tratar formatação do nome
    private String trataLabel(String nome) {
        nome = "<html><font color=white>" +
                nome +
                "</font></html>";
        return nome;
    }
}