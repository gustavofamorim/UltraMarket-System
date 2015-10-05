package Modelo;

import java.io.Serializable;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Filial implements Serializable{

    private Integer id;
    private static String nome;

    private String HOST_NAME;
    private Integer SERVER_PORT;
    private String OBJECT_NAME;

    public Filial(String nome, String HOST_NAME, Integer SERVER_PORT, String OBJECT_NAME){
        this.nome = nome;
        this.HOST_NAME = HOST_NAME;
        this.SERVER_PORT = SERVER_PORT;
        this.OBJECT_NAME = OBJECT_NAME;
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

    public String getHostName() {
        return HOST_NAME;
    }

    public Integer getServerPort() {
        return SERVER_PORT;
    }

    public String getObjectName() {
        return OBJECT_NAME;
    }
}
