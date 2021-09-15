
package Telas.componentes;

import javax.swing.*;

/**
 * @author hedermilani
 */

public class MeuJTextField extends JTextField implements MeuComponente{
    //h/ Atributos para composição de componentes
    private String nome;
    
    //h/ Método para contrução do componente JTextField
    public MeuJTextField(int tamanho, String nome) {
        //h/ Utilizando o método contrutor da super classe
        super (tamanho);
        //h/ Importar informação sobre o compoente
        this.nome = nome;
    }

    @Override //h/ Método para compor nome ao instanciar componente
    public String getNome() {
        return nome;
    }
    
}
