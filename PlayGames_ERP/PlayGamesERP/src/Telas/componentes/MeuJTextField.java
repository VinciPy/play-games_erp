
package Telas.componentes;

import javax.swing.*;

/**
 * @author hedermilani
 */

public class MeuJTextField extends JTextField implements MeuComponente{
    //h/ Atributos para composição de componentes
    private String nome;
    private boolean obrigatorio;
    
    //h/ Método para contrução do componente JTextField
    public MeuJTextField(int tamanho, String nome, boolean obrigatorio) {
        //h/ Utilizando o método contrutor da super classe
        super (tamanho);
        //h/ Importar informação sobre o compoente
        this.nome = nome;
        //h/ importar informacao de obrigatoriedade
        this.obrigatorio = obrigatorio;
    }

    @Override //h/ Método para compor nome ao instanciar componente
    public String getNome() {
        return nome;
    }

    //h/ metodo para realizar a limpeza do campo
    @Override
    public void limpar() {
        //h/ setar campo como vazio
        setText("");
    }

    //h/ Metodo para habilitar componente de acordo com paramentro
    @Override
    public void habilitar(boolean status) {
        //h/ setar paramentro para o componente
        setEnabled(status);
    }

    //h/ Metodo para passar informacao de obrigatoriedade
    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }
    
}
