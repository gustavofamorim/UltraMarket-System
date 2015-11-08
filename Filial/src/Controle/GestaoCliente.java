package Controle;

import Tools.Visual.WindowLoader;
import Visao.Novo.NovoClienteController;
import java.util.ArrayList;
import services.Cliente;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class GestaoCliente {
    
    public services.Cliente searchCliente(String cpf) {
        return obterClienteByCPF(cpf);
    }

    public Cliente saveCliente(NovoClienteController form){

        if (form.getNome().length() == 0 && form.getCPF().length() == 0) {
            WindowLoader.showError("Preencha todos os campos.", "É necessário que todos os campos estejam preenchidos.", "");
            return (null);
        }
        
        Cliente c = new Cliente();
        
        c.setNome(form.getNome());
        c.setCPF(form.getCPF());
        c = cadastrarCliente(c);
        
        if(c != null) {
            form.limpar();
            return (c);
        }
        else{
            WindowLoader.showMessage("Erro", "Erro ao salvar cliente.");
            return (null);
        }
    }

    public ArrayList<Cliente> obterTodosCliente(){
        return (ArrayList<Cliente>) (obterClientes());
    }

    private static Cliente cadastrarCliente(services.Cliente cliente) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.cadastrarCliente(cliente);
    }

    private static boolean excluirCliente(int idCliente) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.excluirCliente(idCliente);
    }

    private static Cliente obterClienteByCPF(java.lang.String cpf) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.obterClienteByCPF(cpf);
    }

    private static java.util.List<services.Cliente> obterClientes() {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.obterClientes();
    }
}
