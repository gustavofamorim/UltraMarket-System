package FilialMaker.Controle;

import Filial.FilialRemoteImpl;
import Matriz.Matriz;
import Matriz.MatrizRemote;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class Controle {

    FilialRemoteImpl essaFilial = null;
    MatrizRemote matriz = null;

    public void conectar() {
        try {
            Object object = Naming.lookup("rmi://" + "localhost:" + Matriz.PORTA + "/" + Matriz.NOME_OBJETO);
        }
        catch(Exception e){
            System.out.println("Erro");
        }
    }

    public void registrarFilial(String nome){
        try {
            this.essaFilial.setFilialInfo(this.matriz.requisitarLogon(this.essaFilial, nome));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
