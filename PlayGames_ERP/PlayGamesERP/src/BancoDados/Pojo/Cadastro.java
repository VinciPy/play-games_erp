package BancoDados.Pojo;

/**
 * @author hedermilani
 */

//h/ Classe para espelhar dados da tabela
public class Cadastro {
    //h/ Atributos referente as colunas das tabelas
    private int bp;
    private int idCidade;
    private String nomeRazao;
    private int cpfCnpj;
    private int rgInscric;
    private int telefone;
    private String email;
    private String endereco;
    private int numero;
    private int cep;
    private String complemento;
    private boolean status;
    
    //h/ Metodos para acesso aos dados
    public int getBp() {
        return bp;
    }
    public int getIdCidade() {
        return idCidade;
    }
    public String getNomeRazao() {
        return nomeRazao;
    }
    public int getCpfCnpj() {
        return cpfCnpj;
    }
    public int getRgInscric() {
        return rgInscric;
    }
    public int getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public int getNumero() {
        return numero;
    }
    public int getCep() {
        return cep;
    }
    public String getComplemento() {
        return complemento;
    }
    public boolean getStatus() {
        return status;
    }
    
    //h/ Metodos para insercao dos dados
    public void setBp(int bp) {
        this.bp = bp;
    }
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }
    public void setCpfCnpj (int cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public void setRgInscric(int rgInscric) {
        this.rgInscric = rgInscric;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setnumero(int numero) {
        this.numero = numero;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
