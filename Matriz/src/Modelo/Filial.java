package Modelo;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Filial {

    private Integer id;
    private String nome;

    public Filial() {}

    public Filial(Integer id, String nome) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }
}
