package Telas;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    //h/ Atributos para composição da barra de menus
    private JMenu jmCadastros;

    //h/ Método para Instanciar uma nova tela
    public TelaPrincipal (String titulo) {
        //h/ Intanciar tela conforme API da super classe
        super(titulo);
        //h/ Define o tamanho inicial da tela
        setSize(1425, 800);
        //h/ Define botão de fechar como encerramento do programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //h/ Instancia método para montar barra de menu
        montaMenu();

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
    }
}
