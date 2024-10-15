package br.ETS.almoxarifado.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao(){
        try{
            return createDataSource().getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // ao inves de cada acesso abrir uma nova conexão, cria 10 acessos e usa ele
    private HikariDataSource createDataSource(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/almoxarifado?");
        config.setUsername("root");
        config.setPassword("root");
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);

    }
}
