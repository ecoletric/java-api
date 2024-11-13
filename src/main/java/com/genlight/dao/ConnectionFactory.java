package com.genlight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static ConnectionFactory instance;
    private Connection conexao;

    private String url;
    private String user;
    private String pass;
    private String driver;

    public ConnectionFactory(String url, String user, String pass, String driver) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }

    public static ConnectionFactory getInstance() {
        ConnectionFactory result = instance;
        if (result != null) {
            return result;
        }

        String url = System.getProperty("DB_URL");
        String user = System.getProperty("DB_USERNAME");
        String pass = System.getProperty("DB_PASSWORD");
        String driver = System.getProperty("DB_DRIVER");

        if (instance == null) {
            instance = new ConnectionFactory(url, user, pass, driver);
        }
        return instance;
    }

    public Connection getConexao() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                return this.conexao;
            }
            if (this.getDriver() == null || this.getDriver().isEmpty()) {
                throw new ClassNotFoundException("Nome da classe nulo ou em branco");
            }
            if (this.getUrl() == null || this.getUrl().isEmpty()) {
                throw new SQLException("URL de conexão nulo ou em branco");
            }
            if (this.getUser() == null || this.getUser().isEmpty()) {
                throw new SQLException("Usuário de conexão nulo ou em branco");
            }
            Class.forName(this.getDriver());
            this.conexao = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro nome da classe: " + e.getMessage());
            System.exit(1);
        }
        return conexao;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDriver() {
        return driver;
    }
}