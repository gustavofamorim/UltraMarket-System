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
public class Cliente extends services.Cliente {
    
    public static Cliente ParseToModel(services.Cliente service) {
        if (service != null) {
            Cliente cliente = new Cliente();
            cliente.setId(service.getId());
            cliente.setCPF(service.getCPF());
            cliente.setNome(service.getNome());
            cliente.setSaldo(service.getSaldo());
            return cliente;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return ("Nome: " + nome + "   CPF: " + cpf);
    }
}
