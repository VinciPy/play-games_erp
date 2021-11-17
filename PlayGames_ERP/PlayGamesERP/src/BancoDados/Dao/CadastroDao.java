package BancoDados.Dao;

import BancoDados.Conexao;
import BancoDados.Pojo.Cadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author hedermilani
 */

//h/ Classe para preparar os SQL de acesso ao banco
public class CadastroDao {
    //h/ Metodo para criar o SQL de insercao de dados ao banco
    public boolean inserir(Cadastro cadastro) {
        //h/ modulo para tratamento de erros
        try {
            //h/ Criar script SQL
            String sql = "INSERT INTO CADASTRO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //h/ Preparar SQL com a conexao
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //h/ Adicionar dados para insercao
            ps.setInt(1, cadastro.getBp());
            ps.setInt(2, cadastro.getIdCidade());
            ps.setString(3, cadastro.getNomeRazao());
            ps.setInt(4, cadastro.getCpfCnpj());
            ps.setInt(5, cadastro.getRgInscric());
            ps.setInt(6, cadastro.getTelefone());
            ps.setString(7, cadastro.getEmail());
            ps.setString(8, cadastro.getEndereco());
            ps.setInt(9, cadastro.getNumero());
            ps.setInt(10, cadastro.getCep());
            ps.setString(11, cadastro.getComplemento());
            ps.setBoolean(12, cadastro.getStatus());
            //h/ executar insercao
            ps.executeUpdate();
            return true;
        } catch(Exception e) {
            //h/ Apresentar logs de erros
            e.printStackTrace();
            //h/ Apresentar mensagem de erro
            JOptionPane.showMessageDialog(null, "Falha na inserçao de dados.");
            return false;
        }
    }
    
    //h/ metodo para criar SQL de consulta no banco
    public boolean consultar(Cadastro cadastro) {
        //h/ Modulo de tratamento de erros
        try {
            //h/ Criar script SQL de consulta
            String sql = "SELECT * FROM CADASTRO WHERE BP = ?";
            //H/ preparar conexao com SQL
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //h/ Passar paremetro para consulta
            ps.setInt(1, cadastro.getBp());
            //h/ Realizar consulta e armazenar resultado
            ResultSet rs = ps.executeQuery();
            //h/ Verifica se consulta possui resultado
            if (rs.next()) {
                //h/ Passar dados do resultado para classe cadatro pojo
                cadastro.setIdCidade(rs.getInt(2));
                cadastro.setNomeRazao(rs.getString(3));
                cadastro.setCpfCnpj(rs.getInt(4));
                cadastro.setRgInscric(rs.getInt(5));
                cadastro.setTelefone(rs.getInt(6));
                cadastro.setEmail(rs.getString(7));
                cadastro.setEndereco(rs.getString(8));
                cadastro.setnumero(rs.getInt(9));
                cadastro.setCep(rs.getInt(10));
                cadastro.setComplemento(rs.getString(11));
                cadastro.setStatus(rs.getBoolean(12));
                return true;
            }else {
                //h/ Apresentar mensagem caso consulta nao tiver resultado
                JOptionPane.showMessageDialog(null, "Cadastro nao localizado.");
                return false;
            }
        } catch(Exception e) {
            //h/ Apresentar logs de erros
            e.printStackTrace();
            //h/ Apresentar mensagem de erro
            JOptionPane.showMessageDialog(null, "Falha na consulta.");
            return false;
        }
    }
    
    //h/ Metodo para preparar SQL para alterar banco
    public boolean alterar(Cadastro cadastro) {
        //h/ Modulo para tratamento de erro
        try {
            //h/ Criar Script SQL de Alteracao
            String sql = "UPDATE CADASTRO SET "
                    + "ID_CIDADE = ?, "
                    + "NOME_RAZAO = ?, "
                    + "CPF_CNPJ = ?, "
                    + "RG_INSCREIC = ?"
                    + "TELEFONE = ?, "
                    + "EMAIL = ?, "
                    + "ENDERECO = ?, "
                    + "NUMERO = ?, "
                    + "CEP = ?, "
                    + "COMPLEMENTO = ?, "
                    + "STATUS = ? "
                    + "WHERE BP = ?";
            //H/ Preparar conexao com SQL
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //h/ Paramentro de alteracao
            ps.setInt(12, cadastro.getBp());
            //h/ Dados a serem alterados
            ps.setInt(1, cadastro.getIdCidade());
            ps.setString(2, cadastro.getNomeRazao());
            ps.setInt(3, cadastro.getCpfCnpj());
            ps.setInt(4, cadastro.getRgInscric());
            ps.setInt(5, cadastro.getTelefone());
            ps.setString(6, cadastro.getEmail());
            ps.setString(7, cadastro.getEndereco());
            ps.setInt(8, cadastro.getNumero());
            ps.setInt(9, cadastro.getCep());
            ps.setString(10, cadastro.getComplemento());
            ps.setBoolean(11, cadastro.getStatus());
            return true;
        } catch(Exception e) {
            //h/ Apresentar logs de erro
            e.printStackTrace();
            //h/ Apresentar mensagem de erro
            JOptionPane.showMessageDialog(null, "Falha ao realizar Alteraçao");
            return false;
        }
    }
    
}
