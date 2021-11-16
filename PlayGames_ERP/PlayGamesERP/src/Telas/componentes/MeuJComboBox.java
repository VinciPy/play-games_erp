package Telas.componentes;

import javax.swing.JComboBox;

/**
 * @author hedermilani
 */
public class MeuJComboBox extends JComboBox implements MeuComponente {
    //h/ Atributos para composição dos compoentes
    private String nome;
    private boolean obrigatorio;
    
    //h/ Método para contruçao do componente
    public MeuJComboBox (String nome, boolean obrigatorio) {
        //h/ Instanciar método construtos da super classe
        super();
        //h/ Importar informação sobre o compoente
        this.nome = nome;
        this.obrigatorio = obrigatorio;
    }

    @Override //h/ Método para compor nome ao instanciar componente
    public String getNome() {
        return nome;
    }

    //h/ Metodo para realizar a limpeza do campo
    @Override
    public void limpar() {
        //h/ setar campo como nenhum selecionado
        setSelectedIndex(-1);
    }

    //h/ Metodo para habilitar campo de acordo com parametro
    @Override
    public void habilitar(boolean status) {
        //h/ setar o parametro de habilitado ou nao
        setEnabled(status);
    }

    //h/ passa informacao se campo e obrigatorio
    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }
    
}
