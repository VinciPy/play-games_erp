package Telas.componentes;

import javax.swing.JComboBox;

/**
 * @author hedermilani
 */
public class MeuJComboBox extends JComboBox implements MeuComponente {
    //h/ Atributos para composição dos compoentes
    private String nome;
    
    //h/ Método para contruçao do componente
    public MeuJComboBox (String nome) {
        //h/ Instanciar método construtos da super classe
        super();
        //h/ Importar informação sobre o compoente
        this.nome = nome;
    }

    @Override //h/ Método para compor nome ao instanciar componente
    public String getNome() {
        return nome;
    }
    
}
