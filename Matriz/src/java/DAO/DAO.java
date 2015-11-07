/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Gustavo Freitas
 */
public interface DAO<Objeto> {
    
    public abstract Objeto novo(Objeto novo)  throws ClassNotFoundException, SQLException, IOException;
    public abstract Objeto obter(int id)  throws ClassNotFoundException, SQLException, IOException;
    public abstract Objeto obter(Objeto obj) throws ClassNotFoundException, SQLException, IOException;
    public abstract Collection<Objeto> obterTodos() throws ClassNotFoundException, SQLException, IOException;
    public abstract boolean apagar(int id) throws ClassNotFoundException, SQLException, IOException;
    public abstract boolean apagar(Objeto obj) throws ClassNotFoundException, SQLException, IOException;
    public abstract boolean atualizar(Objeto obj) throws ClassNotFoundException, SQLException, IOException;
    
}
