/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ClienteDAO;
import DAO.FilialDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Modelo.Cliente;
import Modelo.Filial;
import Modelo.Produto;
import Modelo.Venda.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gustavo Freitas
 */
@WebService(serviceName = "MatrizServices")
public class MatrizServices {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "logar")
    public Filial logar(@WebParam(name = "nome") String nome) {

        Filial f = null;
        
        try {
            f = FilialDAO.getInstance().obter(nome);
            
            if(f == null){
                f = new Filial(nome);
                f = FilialDAO.getInstance().novo(f);
            }
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (f);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cadastrarCliente")
    public Cliente cadastrarCliente(@WebParam(name = "cliente") Cliente cliente) {
        try {
            return (ClienteDAO.getInstance().novo(cliente));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (null);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cadastrarProduto")
    public boolean cadastrarProduto(@WebParam(name = "produto") Produto produto, @WebParam(name = "filial") Filial filial) {
        try {
            return (ProdutoDAO.getInstance().novo(produto, filial.getId()));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (false);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cadastrarVenda")
    public Venda cadastrarVenda(@WebParam(name = "venda") Venda venda, @WebParam(name = "filial") Filial filial) {
        try {
            return (VendaDAO.getInstance().novo(venda));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (null);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "excluirCliente")
    public boolean excluirCliente(@WebParam(name = "idCliente") int idCliente) {
        try {
            return (ClienteDAO.getInstance().apagar(idCliente));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (false);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cancelarVenda")
    public boolean cancelarVenda(@WebParam(name = "idVenda") int idVenda) {
        try {
            return (VendaDAO.getInstance().apagar(idVenda));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (false);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obterProdutosFilial")
    public Collection<Produto> obterProdutosFilial(@WebParam(name = "idFilial") int idFilial) {
        try {
            return (ProdutoDAO.getInstance().obterTodosByIdFilial(idFilial));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (null);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obterClientes")
    public Collection<Cliente> obterTodosClientes() {
        try {
            return (ClienteDAO.getInstance().obterTodos());
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (null);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obterClienteByCPF")
    public Cliente obterClienteByCPF(@WebParam(name = "cpf") String cpf) {
        try {
            return (ClienteDAO.getInstance().obter(cpf));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (null);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obterTodasVendaByIdFilial")
    public Collection<Venda> obterTodasVendaByIdFilial(@WebParam(name = "idFilial") int idFilial) {
        try {
            return (VendaDAO.getInstance().obterTodosByIdFilial(idFilial));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (null);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cancelarDebitoCliente")
    public boolean cancelarDebitoCliente(@WebParam(name = "idCliente") int idCliente) {
        try {
            return (ClienteDAO.getInstance().cancelarDebito(idCliente));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (false);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "atualizarCliente")
    public boolean atualizarCliente(@WebParam(name = "cliente") Cliente cliente) {
        try {
            return (ClienteDAO.getInstance().atualizar(cliente));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MatrizServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (false);
    }
}
