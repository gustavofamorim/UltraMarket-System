/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Gerenciador.GerenciadorBD;
import static DAO.mysql.generatedclasses.Tables.PRODUTO;
import static DAO.mysql.generatedclasses.Tables.FILIAL_PRODUTO;
import DAO.mysql.generatedclasses.tables.records.ProdutoRecord;
import Modelo.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.jooq.Result;

/**
 *
 * @author Gustavo Freitas
 */
public class ProdutoDAO implements DAO<Produto> {

    @Override
    public boolean novo(Produto novo) throws ClassNotFoundException, SQLException, IOException {
        
        ProdutoRecord created = GerenciadorBD.getContext().insertInto(PRODUTO, PRODUTO.NOME, PRODUTO.QTDDISPONIVEL, PRODUTO.VALOR, PRODUTO.APAGADO)
                                                          .values(novo.getNome(), novo.getQtdDisponivel(), novo.getValor(), (byte) 0)
                                                          .returning().fetchOne();

        if(created != null){
            novo.setId(created.getIdproduto());
            return (true);
        }
        
        return (false);
    }

    public boolean novo(Produto novo, int idFilial) throws ClassNotFoundException, SQLException, IOException {
        
        ProdutoRecord created = GerenciadorBD.getContext().insertInto(PRODUTO, PRODUTO.NOME, PRODUTO.QTDDISPONIVEL, PRODUTO.VALOR, PRODUTO.APAGADO)
                                                          .values(novo.getNome(), novo.getQtdDisponivel(), novo.getValor(), (byte) 0)
                                                          .returning().fetchOne();

        if(created != null){
            novo.setId(created.getIdproduto());
            
            GerenciadorBD.getContext().insertInto(FILIAL_PRODUTO, FILIAL_PRODUTO.IDFILIAL, FILIAL_PRODUTO.IDPRODUTO)
                                                          .values(idFilial, novo.getId())
                                                          .returning().fetchOne();
            
            return (true);
        }
        
        return (false);
    }
    
    @Override
    public Produto obter(int id) throws ClassNotFoundException, SQLException, IOException {
        
        Produto loaded = null;
        
        ProdutoRecord result = GerenciadorBD.getContext().selectFrom(PRODUTO)
                                                         .where(PRODUTO.IDPRODUTO.eq(id)).and(PRODUTO.APAGADO.eq((byte) 0))
                                                         .fetchOne();
        
        if(result != null){
            loaded = new Produto(result.getIdproduto(), result.getNome(), result.getValor(), result.getQtddisponivel());
        }
        
        return (loaded);
    }

    public Produto obter(String nome) throws ClassNotFoundException, SQLException, IOException {
        
        Produto loaded = null;
        
        ProdutoRecord result = GerenciadorBD.getContext().selectFrom(PRODUTO)
                                                         .where(PRODUTO.NOME.eq(nome)).and(PRODUTO.APAGADO.eq((byte) 0))
                                                         .fetchOne();
        
        if(result != null){
            loaded = new Produto(result.getIdproduto(), result.getNome(), result.getValor(), result.getQtddisponivel());
        }
        
        return (loaded);
    }
    
    @Override
    public Produto obter(Produto obj) throws ClassNotFoundException, SQLException, IOException {
        if(obj.getId() != -1){
            return (this.obter(obj.getId()));
        }
        else{
            return (this.obter(obj.getNome()));
        }
    }

    @Override
    public Collection<Produto> obterTodos() throws ClassNotFoundException, SQLException, IOException {
        
        ArrayList<Produto> loaded = null;
       
        Result<ProdutoRecord> result = GerenciadorBD.getContext().selectFrom(PRODUTO).where(PRODUTO.APAGADO.eq((byte) 0)).fetch();
        
        if(result != null){
            
            loaded = new ArrayList<>();
            
            for(ProdutoRecord p : result){
                Produto tmp = new Produto(p.getIdproduto(), p.getNome(), p.getValor(), p.getQtddisponivel());
                loaded.add(tmp);
            }
        }
        
        return (loaded);
    }

    @Override
    public boolean apagar(int id) throws ClassNotFoundException, SQLException, IOException {
        ProdutoRecord deleted = GerenciadorBD.getContext().update(PRODUTO)
                               .set(PRODUTO.APAGADO, (byte) 0)
                               .where(PRODUTO.IDPRODUTO.eq(id)).returning().fetchOne();
        
        return (deleted != null);
    }

    @Override
    public boolean apagar(Produto obj) throws ClassNotFoundException, SQLException, IOException {
        return (this.apagar(obj.getId()));
    }

    @Override
    public boolean atualizar(Produto obj) throws ClassNotFoundException, SQLException, IOException {
        
        ProdutoRecord p = new ProdutoRecord(obj.getId(), obj.getNome(), obj.getValor(), obj.getQtdDisponivel(), (byte) 0);
        
        p = GerenciadorBD.getContext().update(PRODUTO)
                         .set(p).where(PRODUTO.IDPRODUTO.eq(p.getIdproduto()))
                         .returning().fetchOne();
        
        return (p != null);
    }
    
    public static ProdutoDAO getInstance(){
        return (new ProdutoDAO());
    }
    
}
