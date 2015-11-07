package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Produto implements Serializable{

    private Integer id = -1;
    private String nome;
    private Double valor;

    public Produto(Integer id, String nome, Double valor){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
    public Produto(String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
