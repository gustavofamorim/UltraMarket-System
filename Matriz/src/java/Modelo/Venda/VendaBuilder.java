package Modelo.Venda;

import Modelo.Cliente;
import Modelo.Produto;
import Tools.Builder;
import Tools.DateParser;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class VendaBuilder implements Builder<Venda>, Serializable {

    private Venda venda = new Venda();
    
    public void addItem(ItemVenda item){
        this.venda.addItemVenda(item);
    }

    public void addItens(Collection<ItemVenda> itens){
        for(ItemVenda item : itens){
            this.venda.addItemVenda(item);
        }
    }

    public void addItem(Produto produto, int qtd){
        ItemVenda item = new ItemVenda(produto, qtd);
        this.venda.addItemVenda(item);
    }

    public boolean darDesconto(Double porcentagem){
        if(!this.venda.getItens().isEmpty()) {
            this.venda.aplicarDesconto(porcentagem);
            return (true);
        }
        return (false);
    }

    public boolean pagar(Double valor) {

        if(this.venda.getItens().isEmpty()){
            return (false);
        }
        this.venda.pagar(valor);
        return (true);
    }

    public void cliente(Cliente c){
        this.venda.setCliente(c);
    }

    public Venda getInstance(){

        if(!this.venda.getItens().isEmpty()) {
            LocalDateTime dataEHora = LocalDateTime.now();

            DateTimeFormatter formatador = DateTimeFormatter
                    .ofLocalizedDateTime(FormatStyle.SHORT)
                    .withLocale(new Locale("pt", "br"));

            dataEHora.format(formatador);

            this.venda.setDataEHora(DateParser.toDate(dataEHora));

            if(this.venda.getValorPago() < this.venda.getTotalLiquido()){
                this.venda.getCliente().setSaldo(this.venda.getValorPago() - this.venda.getTotalLiquido());
            }

            this.venda.setStatus(Venda.STATUS_VENDA.CONFIRMADA);

            System.out.println(this.venda);
            return (this.venda);
        }

        return (null);
    }

    public void cancelar(){
        this.venda = new Venda();
    }
}


