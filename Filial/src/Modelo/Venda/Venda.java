package Modelo.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import services.StatusVENDA;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Venda extends services.Venda {
    
    private List<ItemVenda> itensVenda = new ArrayList<>();

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
    
    public static Venda ParseToModel(services.Venda service) {
        Venda venda = new Venda();
        venda.setCliente(service.getCliente());
        venda.setDataEHora(service.getDataEHora());
        venda.setId(service.getId());
        
        ArrayList<ItemVenda> itens = new ArrayList<>();
        service.getItens().forEach(item -> {itens.add(ItemVenda.ParseToModel(item)); });
        
        venda.setItens(itens);
        venda.setStatus(service.getStatus());
        venda.setTotalBruto(service.getTotalBruto());
        venda.setTotalLiquido(service.getTotalLiquido());
        venda.setTroco(service.getTroco());
        venda.setValorPago(service.getValorPago());
        return venda;
    }
    
    public void addItemVenda(ItemVenda item){
        itensVenda.add(item);
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(item);
        if (totalBruto == null) {
            totalBruto = 0.0;
        }
        totalBruto += item.getTotal();
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

    public void setItens(List <ItemVenda> itens) {
        this.itensVenda = itens;
        
        ArrayList<services.ItemVenda> service = new ArrayList<>();
        for (ItemVenda item : itens) {
            service.add(ItemVenda.ParseToService(item));
        }
        this.itens = service;
    }
    
    @Override
    public String toString(){
        String str = "ID da Venda: " + this.id + "\n";

        str += "---------------------------------------\n";
        str += "| Produto        QTD     Total        |\n";

        for(ItemVenda item : this.itensVenda){
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
