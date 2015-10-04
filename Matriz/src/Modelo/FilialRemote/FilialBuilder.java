package Modelo.FilialRemote;

import Tools.Builder;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialBuilder implements Builder<Filial>{

    private Filial filial = new Filial();

    public void setId(int id){
        this.filial.setId(id);
    }

    public void setNome(String nome){
        this.filial.setNome(nome);
    }

    @Override
    public Filial getInstance() {
        Filial tmp = this.filial;
        this.filial = new Filial();
        return tmp;
    }

    public Filial getInstance(Integer id, String nome) {
        this.setId(id);
        this.setNome(nome);
        return this.getInstance();
    }
}
