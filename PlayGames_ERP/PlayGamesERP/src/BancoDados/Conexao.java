package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//h/ Classe para realizar a conexão com o banco de dados
public class Conexao {
    //h/ atributo para controle de conexao ativa
    private static Connection conexao = null;
    
    //h/ Método para realizar a conexao com o banco de dados
    public static Connection getConexao(){
        //h/ verificar se possui alguma conexão ativa
        if (conexao == null) {
            //h/ retorno se possuir conexão ativa
            return conexao;
        } else {
            //h/ criar uma nova conexao
            try {
                //h/ Definir tipo de conexão
                Class.forName("org.firebird.jbdc.FBDrive");
                //h/ criar uma nova conexão
                conexao = DriverManager.getConnection("jdbc:firebirdsql:"
                        + "//localhost:3050//home/hedermilani/Projetos/play-games_erp/PlayGames_ERP/PlayGamesERP/PlayGames.fdb",
                        "SYSDBA", "masterkey");
            } catch (ClassNotFoundException e){
                //h/ Listar logs de erro
                e.printStackTrace();
                //h/ Apresentar mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro no drive");
            } catch (SQLException e) {
                //h/ Listar logs de erro
                e.printStackTrace();
                //h/ Apresentar mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        }return conexao;
    }
}
