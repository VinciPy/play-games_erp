package Telas.componentes;

import javax.swing.JCheckBox;

/**
 * @author hedermilani
 */
public class MeuJCheckBox extends JCheckBox implements MeuComponente {
    //h/ Atributo para composicao dos componentes
    private String nome;
    private boolean obrigatorio;
    
    //h/ Metodo construtor do componente
    public MeuJCheckBox (String nome, boolean obrigatorio) {
        //h/ Construtor da superclasse
        super();
        //h/ Importar informacao do nome do componente
        this.nome = nome;
        //h/ Importar informacao de obrigatoriedade
        this.obrigatorio = obrigatorio;
    }
    
    //h/ metodo para compor nome ao instanciar o componente
    @Override
    public String getNome() {
        return nome;
    }

    //h/ Metodo para limpar o campo
    @Override
    public void limpar() {
        //h/ setar campo como vazio
        setSelected(false);
    }

    //h/ Metodo para definir o status como habilitado
    @Override
    public void habilitar(boolean status) {
        //h/ setar os campos com o status que vir de parametro
        setEnabled(status);
    }

    //h/ Metodo para definir se campo sera abrigatorio
    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }
    
}
