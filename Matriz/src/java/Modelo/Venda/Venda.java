package Modelo.Venda;

import Modelo.Cliente;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Venda implements Serializable {

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

        public String getDescricao() {
            return descricao;
        }
        
        @Override        
        public String toString() {
            return (this.id + " - " + this.descricao);
        }
    };

    private Integer id = -1;
    private STATUS_VENDA status;

    private LocalDateTime dataEHora = null;
    
    private Double totalBruto = 0.0;
    private Double totalLiquido = -1.0;
    private Double troco = -1.0;
    private Double valorPago = -1.0;
    
    private Cliente cliente;
    private ArrayList<ItemVenda> itens = new ArrayList<>();

    public Venda(){

    }

    public void addItemVenda(ItemVenda item){
        this.itens.add(item);
        this.totalBruto += item.getTotal();
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public void aplicarDesconto(Double porcentagem){
        if(porcentagem == 0){
            this.totalLiquido = this.totalBruto;
        }
        else if(porcentagem <= 1) {
            this.totalLiquido = this.totalBruto * (1.0 - porcentagem);
        }
        else{
            throw new IllegalArgumentException("Porcentagem al�m do permitido.");
        }
    }

    public Double getTotalLiquido() {
        return totalLiquido;
    }

    public Double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(Double totalBruto) {
        this.totalBruto = totalBruto;
    }
    
    public Double getTroco() {
        return troco;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void pagar(Double valorPago) {
        this.valorPago = valorPago;
        this.troco = this.valorPago - this.totalLiquido;
    }

    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(LocalDateTime dataEHora) {
        this.dataEHora = dataEHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public STATUS_VENDA getStatus() {
        return status;
    }

    public void setStatus(STATUS_VENDA status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotalLiquido(Double totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
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
