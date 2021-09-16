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

    public MeuJComboBox(String[] dados, String selecione_a_conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //h/ Método para compor nome ao instanciar componente
    public String getNome() {
        return nome;
    }
    
}
