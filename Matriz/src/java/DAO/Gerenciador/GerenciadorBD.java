/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Gerenciador;

import DAO.mysql.generatedclasses.tables.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author Gustavo Freitas
 */
public class GerenciadorBD {
    
    private static Connection con = null;
    private static DSLContext context = null;
    
    public static boolean connect() throws ClassNotFoundException, SQLException, IOException{
        System.out.println("Conectando-se ao banco de dados... ");
        Class.forName(ConfigLoader.CONTROLLER);
        GerenciadorBD.con = DriverManager.getConnection(ConfigLoader.URL, ConfigLoader.USER, ConfigLoader.PASSWORD);
        GerenciadorBD.context = DSL.using(GerenciadorBD.con, SQLDialect.MYSQL);
        System.out.println("Conectado.");

        System.out.println("Testando conexão com o banco de dados... ");
        GerenciadorBD.getContext().select(Cliente.CLIENTE.IDCLIENTE).from(Cliente.CLIENTE).limit(1).fetch();
        System.out.println("Sucesso.");
        
        return (true);
    }
    
    public static DSLContext getContext() throws ClassNotFoundException, SQLException, IOException{
        
        if(GerenciadorBD.context == null){
            GerenciadorBD.connect();
        }
        
        return (GerenciadorBD.context);
    }
    
}
