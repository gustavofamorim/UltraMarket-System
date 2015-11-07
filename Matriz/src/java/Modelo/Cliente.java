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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
