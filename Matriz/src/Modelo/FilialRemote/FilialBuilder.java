package Modelo.FilialRemote;

import Tools.Builder;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialBuilder implements Builder<Filial>{

    private Filial filial = new Filial();

    public void setId(int id){
        filial.setId(id);
    }

    public void setNome(String nome){
        filial.setNome(nome);
    }

    public void setHostname(String hostname){
        filial.setHostname(hostname);
    }

    public void setPorta(int porta){
        filial.setPorta(porta);
    }

    @Override
    public Filial getInstance() {
        Filial tmp = filial;
        filial = new Filial();
        return tmp;
    }

    public Filial getInstance(Integer id, String nome, String hostname, int porta) {
        setId(id);
        setNome(nome);
        setHostname(hostname);
        setPorta(porta);
        return this.getInstance();
    }
}
