package Modelo.Venda;

import Modelo.Produto;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class ItemVenda implements Serializable {

    private Integer id = -1;
    private Integer qtd = 0;
    private Produto item = null;
    private Double total = 0.0;
    
    public ItemVenda(){
        
    }
    
    public ItemVenda(Produto item, int qtd){
        this.qtd = qtd;
        this.item = item;

        this.total = this.item.getValor() * this.qtd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
}
