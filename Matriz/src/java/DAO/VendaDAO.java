/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Gerenciador.GerenciadorBD;
import static DAO.mysql.generatedclasses.tables.Venda.VENDA;
import DAO.mysql.generatedclasses.tables.records.VendaRecord;
import Modelo.Venda.ItemVenda;
import Modelo.Venda.Venda;
import Tools.DateParser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.jooq.Result;

/**
 *
 * @author Gustavo Freitas
 */
public class VendaDAO implements DAO<Venda> {

    @Override
    public Venda novo(Venda novo) throws ClassNotFoundException, SQLException, IOException {
                
        VendaRecord created;
        created = GerenciadorBD.getContext().insertInto(VENDA, VENDA.IDCIENTE, VENDA.TOTALBRUTO, VENDA.TOTALLIQUIDO, VENDA.TROCO, VENDA.VALORPAGO, VENDA.DATA, VENDA.STATUS)
                .values(novo.getCliente().getId(), novo.getTotalBruto(), novo.getTotalLiquido(), novo.getTroco(), novo.getValorPago(), new java.sql.Date(DateParser.toDate(novo.getDataEHora()).getTime()), (byte) novo.getStatus().getId())
                .returning().fetchOne();

        if(created != null){
            novo.setId(created.getIdvenda());
            
            for(ItemVenda item : novo.getItens()){
                ItemVendaDAO.getInstance().novo(item, novo.getId());
            }
            
            return (novo);
        }
        
        return (null);
    }

    @Override
    public Venda obter(int id) throws ClassNotFoundException, SQLException, IOException {
        
        Venda loaded = null;
        
        VendaRecord result = GerenciadorBD.getContext().selectFrom(VENDA)
                                                         .where(VENDA.IDVENDA.eq(id))
                                                         .fetchOne();
        
        if(result != null){
            
            loaded = new Venda();
            loaded.setId(result.getIdvenda());
            loaded.setCliente(ClienteDAO.getInstance().obter(result.getIdciente()));
            loaded.setDataEHora(DateParser.toLocalDateTime(result.getData()));
            loaded.setStatus(result.getStatus() == 1 ? Venda.STATUS_VENDA.CONFIRMADA : Venda.STATUS_VENDA.CANCELADA);
            loaded.setTotalBruto(result.getTotalbruto());
            loaded.setTotalLiquido(result.getTotalliquido());
            loaded.setTroco(result.getTroco());
            loaded.setValorPago(result.getValorpago()); 
            loaded.setItens((ArrayList<ItemVenda>) ItemVendaDAO.getInstance().obterTodos(loaded.getId()));
        }
        
        return (loaded);
    }

    @Override
    public Venda obter(Venda obj) throws ClassNotFoundException, SQLException, IOException {
        return (this.obter(obj.getId()));
    }

    @Override
    public Collection<Venda> obterTodos() throws ClassNotFoundException, SQLException, IOException {
        
        ArrayList<Venda> loaded = null;

        Result<VendaRecord> result = GerenciadorBD.getContext().selectFrom(VENDA).fetch();
        
        if(result != null){
            
            loaded = new ArrayList<>();
            
            for(VendaRecord v : result){
                Venda tmp = new Venda();
                tmp.setId(v.getIdvenda());
                tmp.setCliente(ClienteDAO.getInstance().obter(v.getIdciente()));
                tmp.setDataEHora(DateParser.toLocalDateTime(v.getData()));
                tmp.setStatus(v.getStatus() == 1 ? Venda.STATUS_VENDA.CONFIRMADA : Venda.STATUS_VENDA.CANCELADA);
                tmp.setTotalBruto(v.getTotalbruto());
                tmp.setTotalLiquido(v.getTotalliquido());
                tmp.setTroco(v.getTroco());
                tmp.setValorPago(v.getValorpago());
                tmp.setItens((ArrayList<ItemVenda>) ItemVendaDAO.getInstance().obterTodos(tmp.getId()));
                loaded.add(tmp);
            }
        }
        
        return (loaded);
    }

    @Override
    public boolean apagar(int id) throws ClassNotFoundException, SQLException, IOException {
        
        VendaRecord v = GerenciadorBD.getContext().update(VENDA)
                            .set(VENDA.STATUS, (byte) 0).where(VENDA.IDVENDA.eq(id))
                            .returning().fetchOne();
        
        return (v != null);
    }

    @Override
    public boolean apagar(Venda obj) throws ClassNotFoundException, SQLException, IOException {
        return (this.apagar(obj.getId()));
    }

    @Override
    public boolean atualizar(Venda obj) throws ClassNotFoundException, SQLException, IOException {
        
        VendaRecord v = new VendaRecord(obj.getId(), obj.getCliente().getId(), 
                obj.getTotalBruto(), obj.getTotalLiquido(), obj.getTroco(), 
                obj.getValorPago(), new java.sql.Date(DateParser.toDate(obj.getDataEHora()).getTime()), 
                (byte) obj.getStatus().getId());
        
        v = GerenciadorBD.getContext().update(VENDA)
                         .set(v).where(VENDA.IDVENDA.eq(v.getIdvenda()))
                         .returning().fetchOne();
        
        return (v != null);
    }

    public static VendaDAO getInstance(){
        return (new VendaDAO());
    }
    
}
