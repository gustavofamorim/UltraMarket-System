package Modelo;

import java.io.Serializable;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Filial implements Serializable{

    private Integer id = -1;
    private String nome;

    public Filial(String nome){
        this.nome = nome;
    }
    
    public Filial(int id, String nome){
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return id + " | " + nome;
    }
}
