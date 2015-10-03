package Modelo;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class Cliente {

    private String nome;
    private String CPF;

    public Cliente(String nome, String CPF){
        this.CPF = CPF;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }
}
