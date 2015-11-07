/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Gerenciador.GerenciadorBD;
import static DAO.mysql.generatedclasses.tables.Cliente.CLIENTE;
import DAO.mysql.generatedclasses.tables.records.ClienteRecord;
import Modelo.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.jooq.Result;

/**
 *
 * @author Gustavo Freitas
 */
public class ClienteDAO implements DAO<Cliente>{

    @Override
    public Cliente novo(Cliente novo) throws ClassNotFoundException, SQLException, IOException {
        
        ClienteRecord created = GerenciadorBD.getContext().insertInto(CLIENTE, CLIENTE.NOME, CLIENTE.SALDO, CLIENTE.CPF, CLIENTE.APAGADO)
                                                          .values(novo.getNome(), novo.getSaldo(), novo.getCPF(), (byte) 0)
                                                          .returning().fetchOne();
        
        if(created != null){
            novo.setId(created.getIdcliente());
            return (novo);
        }
        
        return (null);
    }

    @Override
    public Cliente obter(int id) throws ClassNotFoundException, SQLException, IOException {
        
        Cliente loaded = null;
        
        ClienteRecord result = GerenciadorBD.getContext().selectFrom(CLIENTE)
                                                         .where(CLIENTE.IDCLIENTE.eq(id)).and(CLIENTE.APAGADO.eq((byte)0))
                                                         .fetchOne();
        
        if(result != null){
            loaded = new Cliente(result.getNome(), result.getCpf());
            loaded.setSaldo(result.getSaldo());
            loaded.setId(result.getIdcliente());
        }
        
        return (loaded);
    }

    public Cliente obter(String cpf) throws ClassNotFoundException, SQLException, IOException {
        
        Cliente loaded = null;
        
        ClienteRecord result = GerenciadorBD.getContext().selectFrom(CLIENTE)
                                                         .where(CLIENTE.CPF.eq(cpf)).and(CLIENTE.APAGADO.eq((byte)0))
                                                         .fetchOne();
        
        if(result != null){
            loaded = new Cliente(result.getNome(), result.getCpf());
            loaded.setSaldo(result.getSaldo());
            loaded.setId(result.getIdcliente());
        }
        
        return (loaded);
    }
    
    @Override
    public Cliente obter(Cliente obj) throws ClassNotFoundException, SQLException, IOException {
        
        if(obj.getId() != -1){
            return (this.obter(obj.getId()));
        }
        else{
            return (this.obter(obj.getCPF()));
        }
    }

    @Override
    public Collection<Cliente> obterTodos() throws ClassNotFoundException, SQLException, IOException {
        
        ArrayList<Cliente> loaded = null;
       
        Result<ClienteRecord> result = GerenciadorBD.getContext().selectFrom(CLIENTE).where(CLIENTE.APAGADO.eq((byte)0)).fetch();
        
        if(result != null){
            
            loaded = new ArrayList<>();
            
            for(ClienteRecord c : result){
                Cliente tmp = new Cliente(c.getNome(), c.getCpf());
                tmp.setId(c.getIdcliente());
                tmp.setSaldo(c.getSaldo());
                loaded.add(tmp);
            }
        }
        
        return (loaded);
    }

    @Override
    public boolean apagar(int id) throws ClassNotFoundException, SQLException, IOException {
        ClienteRecord deleted = GerenciadorBD.getContext().update(CLIENTE)
                               .set(CLIENTE.APAGADO, (byte) 0)
                               .where(CLIENTE.IDCLIENTE.eq(id)).returning().fetchOne();
        
        return (deleted != null);
    }

    @Override
    public boolean apagar(Cliente obj) throws ClassNotFoundException, SQLException, IOException {
        return (this.apagar(obj.getId()));
    }

    @Override
    public boolean atualizar(Cliente obj) throws ClassNotFoundException, SQLException, IOException {
        
        ClienteRecord c = new ClienteRecord(obj.getId(), obj.getNome(), obj.getCPF(), obj.getSaldo(), (byte) 0);
        
        c = GerenciadorBD.getContext().update(CLIENTE)
                         .set(c).where(CLIENTE.IDCLIENTE.eq(c.getIdcliente()))
                         .returning().fetchOne();
        
        return (c != null);
    }
    
    public static ClienteDAO getInstance(){
        return (new ClienteDAO());
    }
}
