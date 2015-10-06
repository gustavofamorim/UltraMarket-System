package Modelo;

import java.io.Serializable;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Cliente implements Serializable{

    private String nome;
    private String CPF;
    private Double debito;

    public Cliente(String nome, String CPF){
        this.CPF = CPF;
        this.nome = nome;
        this.debito = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Double getDebito() {
        return debito;
    }

    public void setDebito(Double debito){
        this.debito = debito;
    }

    @Override
    public String toString(){
        return ("Nome: " + this.nome + "   CPF: " + this.CPF);
    }
}
