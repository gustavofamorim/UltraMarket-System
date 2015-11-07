package Controle;

import services.Filial;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Control {

    private static Control instance = null;
    
    public static Filial filial = null;

    protected final GestaoCliente gestaoCliente = new GestaoCliente(this);
    protected final GestaoVenda gestaoVenda = new GestaoVenda(this);
    protected final GestaoProduto gestaoProduto = new GestaoProduto(this);

    public void startApplication(String nome){
        Control.filial = logar(nome);
    }

    public void endApplication(){
        
    }

    public GestaoCliente getGestaoCliente() {
        return gestaoCliente;
    }

    public GestaoProduto getGestaoProduto() {
        return gestaoProduto;
    }

    public GestaoVenda getGestaoVenda() {
        return gestaoVenda;
    }

    public static Control getInstance(){
        
        if(Control.instance == null){
            Control.instance = new Control();
        }
        
        return (Control.instance);
    }
    
    private static Filial logar(java.lang.String nome) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.logar(nome);
    }
}
