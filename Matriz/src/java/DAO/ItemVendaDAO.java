/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Gerenciador.GerenciadorBD;
import static DAO.mysql.generatedclasses.tables.Itemvenda.ITEMVENDA;
import DAO.mysql.generatedclasses.tables.records.ItemvendaRecord;
import Modelo.Venda.ItemVenda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.jooq.Result;

/**
 *
 * @author Gustavo Freitas
 */
public class ItemVendaDAO implements DAO<ItemVenda>{

    @Override
    public ItemVenda novo(ItemVenda novo) throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ItemVenda novo(ItemVenda novo, int idVenda) throws ClassNotFoundException, SQLException, IOException {
        
        ItemvendaRecord created = GerenciadorBD.getContext().insertInto(ITEMVENDA, ITEMVENDA.PRODUTO_IDPRODUTO, ITEMVENDA.VENDA_IDVENDA, ITEMVENDA.QTD, ITEMVENDA.TOTAL)
                                                          .values(novo.getItem().getId(), idVenda, novo.getQtd(), novo.getTotal())
                                                          .returning().fetchOne();
        
        if(created != null){
            return (novo);
        }
        
        return (null);
    }

    @Override
    public ItemVenda obter(int id) throws ClassNotFoundException, SQLException, IOException {
        
        ItemVenda loaded = null;
        
        ItemvendaRecord result = GerenciadorBD.getContext().selectFrom(ITEMVENDA)
                                                         .where(ITEMVENDA.VENDA_IDVENDA.eq(id))
                                                         .fetchOne();
        
        if(result != null){
            loaded = new ItemVenda(ProdutoDAO.getInstance().obter(result.getProdutoIdproduto()), result.getQtd());
            loaded.setTotal(result.getTotal());
        }
        
        return (loaded);
    }

    @Override
    public ItemVenda obter(ItemVenda obj) throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ItemVenda> obterTodos() throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<ItemVenda> obterTodos(int idVenda) throws ClassNotFoundException, SQLException, IOException {
        
        ArrayList<ItemVenda> loaded = null;

        Result<ItemvendaRecord> result = GerenciadorBD.getContext().selectFrom(ITEMVENDA)
                                            .where(ITEMVENDA.VENDA_IDVENDA.eq(idVenda)).fetch();
        
        if(result != null){
             
            loaded = new ArrayList<>();
            
            for(ItemvendaRecord v : result){
                ItemVenda tmp = new ItemVenda(ProdutoDAO.getInstance().obter(v.getProdutoIdproduto()), v.getQtd());
                tmp.setTotal(v.getTotal()); 
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
    public boolean apagar(ItemVenda obj) throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(ItemVenda obj) throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static ItemVendaDAO getInstance(){
        return (new ItemVendaDAO());
    }
}
