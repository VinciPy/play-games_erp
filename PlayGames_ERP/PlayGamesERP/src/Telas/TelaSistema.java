package Telas;

import javax.swing.*;

public abstract class TelaSistema extends JInternalFrame {
    //h/ Método construtor para esta super classe
    public TelaSistema (String titulo) {
        //h/ Implementar construtor da super classe original
        super(titulo, true, true, true, true);
        //h/ Definir o tamanho inicial da nova tela
        setSize(800, 600);
        //h/ Adicionar nova janela ao gerenciador
        TelaPrincipal.jdp.add(this);

        //h/ Instanciar janela como visivel
        setVisible(true);
        //h/ Organiza a tela conforme os componentes
        pack();
    }
}