package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Cliente implements Serializable{
    
    private Integer id = -1;
    private String nome;
    private String CPF;
    private Double saldo;

    public Cliente(String nome, String CPF){
        this.CPF = CPF;
        this.nome = nome;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return ("Nome: " + this.nome + "   CPF: " + this.CPF);
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
