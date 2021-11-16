
package Telas.componentes;

import javax.swing.JButton;

/**
 * @author hedermilani
 */

public class MeuJButton extends JButton implements MeuComponente{
    //h/ Atributos para composição dos componentes
    private String nome = "";
    
    //h/ Método Construtor do componente
    public MeuJButton (String nome) {
        //h/ Instanciar método construtor da superclasse
        super(nome);
    }

    @Override //h/ Método para compor nome ao instanciar componente
    public String getNome() {
        return nome;
    }

    @Override
    public void limpar() {

    }

    @Override
    public void habilitar(boolean status) {

    }

    @Override
    public boolean eObrigatorio() {
        return true;
    }
}
