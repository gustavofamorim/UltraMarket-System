package Controle;

import Tools.Visual.WindowLoader;
import Visao.Novo.NovoProdutoController;
import java.util.ArrayList;
import services.Produto;

/**
 * Created by Gustavo Freitas on 06/10/2015.
 */
public class GestaoProduto {
    public void saveProduto(NovoProdutoController form) {
        Double valor = null;
        try {
            valor = Double.parseDouble(form.getValor().replace(",", "."));
        }
        catch(NumberFormatException e){
            WindowLoader.showMessage("Entrada Inválida", "Valor é um campo numérico.");
            valor = null;
        }

        if (form.getNome().length() == 0 && form.getValor().length() == 0 && valor > 0) {
            WindowLoader.showError("Preencha todos os campos.", "É necessário que todos os campos estejam preenchidos corretamente.");
        } else {
            Produto produto = new Produto();
            produto.setNome(form.getNome());
            produto.setValor(valor);
            cadastrarProduto(produto, Control.filial);
        }
    }

    public ArrayList<Produto> obterTodosProduto(){
        //return (this.mainController.banco.selectAllFromProduto());
        return (null);
    }

    private static boolean cadastrarProduto(services.Produto produto, services.Filial filial) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.cadastrarProduto(produto, filial);
    }

    private static java.util.List<services.Produto> obterProdutosFilial(int idFilial) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.obterProdutosFilial(idFilial);
    }
}
