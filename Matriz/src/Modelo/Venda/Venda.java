package Modelo.Venda;

import Modelo.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Venda {

    private int cod;

    private Double total = 0.0;
    private Double totalComDesconto = -1.0;

    private Double troco = -1.0;
    private Double valorPago = -1.0;

    private Cliente cliente;

    private LocalDateTime dataEHora = null;

    private ArrayList<ItemVenda> itens = new ArrayList<>();

    public Venda(){

    }

    public void addItemVenda(ItemVenda item){
        this.itens.add(item);
        this.total += item.getTotal();
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public void aplicarDesconto(Double porcentagem){
        if(porcentagem == 0){
            this.totalComDesconto = this.total;
        }
        else if(porcentagem <= 1) {
            this.totalComDesconto = this.total * (1.0 - porcentagem);
        }
        else{
            throw new IllegalArgumentException("Porcentagem além do permitido.");
        }
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalComDesconto() {
        return totalComDesconto;
    }

    public Double getTroco() {
        return troco;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void pagar(Double valorPago) {
        this.valorPago = valorPago;
        this.troco = this.valorPago - this.totalComDesconto;
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

    @Override
    public String toString(){
        String str = "Venda: " + this.cod + "\n";

        str += "---------------------------------------\n";
        str += "| Produto        QTD     Total        |\n";

        for(ItemVenda item : this.itens){
            str += item + "\n";
        }

        str += "---------------------------------------\n";
        str += "\n";
        str += "Total:              " + this.total + "\n";
        str += "Total Com Desconto: " + this.totalComDesconto + "\n";
        str += "Pago:               " + this.valorPago + "\n";
        str += "Troco:              " + this.troco + "\n";
        str += "Data e Hora:        " + this.dataEHora + "\n";
        str += "fim\n";
        return (str);
    }
}
