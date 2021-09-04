package Telas;

import javax.swing.*;

public abstract class TelaSistema extends JInternalFrame {
    //h/ Método construtor para esta super classe
    public TelaSistema (String titulo) {
        //h/ Implementar construtor da super classe original
        super(titulo, true, true, true, true);
        //h/ Definir o tamanho inicial da no==va tela
        setSize(800, 600);

        //h/ Organiza a tela conforme os componentes
        pack();
        //h/ Instanciar janela como visivel
        setVisible(true);
        //h/ Adicionar nova janela ao gerenciador
        TelaPrincipal.jdp.add(this);

    }
}