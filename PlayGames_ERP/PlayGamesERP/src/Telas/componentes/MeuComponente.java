package Telas.componentes;

/**
 * @author hedermilani
 */

public interface MeuComponente {
    // Interface de método para informar o nome do componente
    public String getNome();
    public void limpar();
    public void habilitar(boolean status);
    public boolean eObrigatorio();
}
