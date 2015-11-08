package Modelo;

import services.Cliente;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.datatype.XMLGregorianCalendar;
import services.ItemVenda;
import services.StatusVENDA;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Venda extends services.Venda {

    public static enum STATUS_VENDA{
        CONFIRMADA(1, "Venda confirmada."), CANCELADA(0, "Venda cancelada.");
    
        int id = -1;
        String descricao;

        private STATUS_VENDA(int id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
        
        @Override        
        public String toString() {
            return (this.id + " - " + this.descricao);
        }
    };
    
    public void addItemVenda(ItemVenda item){
        this.itens.add(item);
        this.totalBruto += item.getTotal();
    }

    public void aplicarDesconto(Double porcentagem){
        if(porcentagem == 0){
            this.totalLiquido = this.totalBruto;
        }
        else if(porcentagem <= 1) {
            this.totalLiquido = this.totalBruto * (1.0 - porcentagem);
        }
        else{
            throw new IllegalArgumentException("Porcentagem alem do permitido.");
        }
    }
    
    public void pagar(Double valorPago) {
        this.valorPago = valorPago;
        this.troco = this.valorPago - this.totalLiquido;
    }

    public void setStatus(STATUS_VENDA status) {
        this.status = status == STATUS_VENDA.CONFIRMADA ? StatusVENDA.CONFIRMADA : StatusVENDA.CANCELADA;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }
    
    @Override
    public String toString(){
        String str = "ID da Venda: " + this.id + "\n";

        str += "---------------------------------------\n";
        str += "| Produto        QTD     Total        |\n";

        for(ItemVenda item : this.itens){
            str += item + "\n";
        }

        str += "---------------------------------------\n";
        str += "\n";
        str += "Status:             " + this.status.name() + "\n";
        str += "Total Bruto:        " + this.totalBruto + "\n";
        str += "Total Liquido:      " + this.totalLiquido + "\n";
        str += "Pago:               " + this.valorPago + "\n";
        str += "Troco:              " + this.troco + "\n";
        str += "Data e Hora:        " + this.dataEHora + "\n";
        str += "fim\n";
        return (str);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
