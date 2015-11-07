package Modelo.Venda;

import Modelo.Produto;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class ItemVenda {

    private Integer id = -1;
    private Integer qtd;
    private Produto item;
    private Double total;
    
    public ItemVenda(Produto item, int qtd){
        this.qtd = qtd;
        this.item = item;

        this.total = item.getValor() * qtd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Produto getItem() {
        return item;
    }

    public void setItem(Produto item) {
        this.item = item;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    
    @Override
    public String toString(){
        return ("| " + item + String.format("%-8d", qtd) + String.format("%-10.2f", total) + "\t|");
    }
}
