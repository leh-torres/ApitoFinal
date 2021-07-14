/**
 * Classes destinada a estabelecer a conexão com o banco de dados
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Leticia Torres
 */
public class DataSource {
    private String hostname;
    private int    porta;
    private String database;
    private String username;
    private String password;
    private Connection conexao;

    public DataSource(){
        try {
            hostname = "localhost";
            porta = 3306;
            database = "apito_final";
            username = "root";
            password = "";

            String url = "jdbc:mysql://" + hostname + ":" + porta + "/" + database;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conexao = DriverManager.getConnection(url, username, password);

            System.out.println("Conexão estabelecida....");
            
        } catch (SQLException ex) {
            System.err.println("ERRO de conexão" + ex.getMessage());
        } catch(Exception ex){
            System.err.println("ERRO genérico" + ex.getMessage());
        }
    }

    /**
     * Método que retorna o estado da conexão com o banco
     * @return conexao
     */
    public Connection getConnection(){
        return this.conexao;
    }

    /**
     * Método que fecha a conexão com o banco de dados
     */
    public void closeDataSource(){
        try {
            conexao.close();
        } catch (Exception e) {
            System.err.println("ERRO ao desconectar..." + e.getMessage());
        }
    }

}
