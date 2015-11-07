package Modelo;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Produto {

    private Integer id = -1;
    private String nome;
    private Double valor;
    private Integer qtdDisponivel;

    public Produto(Integer id, String nome, Double valor, Integer qtdDisponivel){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.qtdDisponivel = qtdDisponivel;
    }
    
    public Produto(String nome, Double valor, Integer qtdDisponivel){
        this.nome = nome;
        this.valor = valor;
        this.qtdDisponivel = qtdDisponivel;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(Integer qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
    
    @Override
    public String toString(){
        return (String.format("%-15s", this.nome));
    }
}
