/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Emerson C. Romaneli
 */
public class Produto extends services.Produto {
    public static Produto ParseToModel(services.Produto service) {
        Produto produto = new Produto();
        produto.setId(service.getId());
        produto.setNome(service.getNome());
        produto.setValor(service.getValor());
        return produto;
    }
    
    @Override
    public String toString() {
        return (String.format("%-15s", nome));
    }
}
