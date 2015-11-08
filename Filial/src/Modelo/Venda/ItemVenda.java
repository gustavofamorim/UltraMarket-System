/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Venda;

import Modelo.Produto;

/**
 *
 * @author Emerson C. Romaneli
 */
public class ItemVenda extends services.ItemVenda {
    
    private Produto produto;
    
    public static ItemVenda ParseToModel(services.ItemVenda service) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setId(service.getId());
        itemVenda.setItem(Produto.ParseToModel(service.getItem()));
        itemVenda.setQtd(service.getQtd());
        itemVenda.setTotal(service.getTotal());
        return itemVenda;
    }
    
    @Override
    public Produto getItem() {
        return produto;
    }
    
    public void setItem(Produto item) {
        this.produto = item;
        this.item = item;
    }
    
    @Override
    public String toString() {
        return ("| " + item + String.format("%-8d", this.qtd) + String.format("%-10.2f", this.total) + "\t|");
    }
}
