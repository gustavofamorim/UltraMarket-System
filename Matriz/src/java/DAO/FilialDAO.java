/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Gerenciador.GerenciadorBD;
import static DAO.mysql.generatedclasses.tables.Filial.FILIAL;
import DAO.mysql.generatedclasses.tables.records.FilialRecord;
import Modelo.Filial;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.jooq.Result;

/**
 *
 * @author Gustavo Freitas
 */
public class FilialDAO implements DAO<Filial> {

    @Override
    public boolean novo(Filial novo) throws ClassNotFoundException, SQLException, IOException {
        
        FilialRecord created = GerenciadorBD.getContext().insertInto(FILIAL, FILIAL.NOME)
                                                          .values(novo.getNome())
                                                          .returning().fetchOne();
        
        if(created != null){
            novo.setId(created.getIdfilial());
            return (true);
        }
        
        return (false);
    }

    @Override
    public Filial obter(int id) throws ClassNotFoundException, SQLException, IOException {
        Filial loaded = null;
        
        FilialRecord result = GerenciadorBD.getContext().selectFrom(FILIAL)
                                                         .where(FILIAL.IDFILIAL.eq(id))
                                                         .fetchOne();
        
        if(result != null){
            loaded = new Filial(result.getIdfilial(), result.getNome());
        }
        
        return (loaded);
    }
    
    public Filial obter(String nome) throws ClassNotFoundException, SQLException, IOException {
        Filial loaded = null;
        
        FilialRecord result = GerenciadorBD.getContext().selectFrom(FILIAL)
                                                        .where(FILIAL.NOME.eq(nome))
                                                        .fetchOne();
        
        if(result != null){
            loaded = new Filial(result.getIdfilial(), result.getNome());
        }
        
        return (loaded);
    }

    @Override
    public Filial obter(Filial obj) throws ClassNotFoundException, SQLException, IOException {
        if(obj.getId() != -1){
            return (this.obter(obj.getId()));
        }
        else{
            return (this.obter(obj.getNome()));
        }
    }

    @Override
    public Collection<Filial> obterTodos() throws ClassNotFoundException, SQLException, IOException {
        ArrayList<Filial> loaded = null;
       
        Result<FilialRecord> result = GerenciadorBD.getContext().selectFrom(FILIAL).fetch();
        
        if(result != null){
            
            loaded = new ArrayList<>();
            
            for(FilialRecord f : result){
                Filial tmp = new Filial(f.getIdfilial(), f.getNome());
                loaded.add(tmp);
            }
        }
        
        return (loaded);
    }

    @Override
    public boolean apagar(int id) throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean apagar(Filial obj) throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Filial obj) throws ClassNotFoundException, SQLException, IOException {
        
        FilialRecord f = new FilialRecord(obj.getId(), obj.getNome());
        
        f = GerenciadorBD.getContext().update(FILIAL)
                         .set(f).where(FILIAL.IDFILIAL.eq(obj.getId()))
                         .returning().fetchOne();
        
        return (f != null);
    }
    
    public static FilialDAO getInstance(){
        return (new FilialDAO());
    }
}
