package Filial.Modelo.Venda;

import Filial.Modelo.Produto;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class ItemVenda {

    private int qtd;
    private Produto item;
    private Double total;

    public ItemVenda(Produto item, int qtd){
        this.qtd = qtd;
        this.item = item;

        this.total = this.item.getValor() * this.qtd;
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

    @Override
    public String toString(){
        return ("| " + this.item + String.format("%-8d", this.qtd) + String.format("%-10.2f", this.total) + "\t|");
    }
}