package Filial.Modelo;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Produto {

    private String nome;
    private Double valor;

    public Produto(String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString(){
        return (String.format("%-15s", this.nome));
    }
}
