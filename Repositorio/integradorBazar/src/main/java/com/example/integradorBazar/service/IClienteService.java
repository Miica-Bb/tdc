package com.example.integradorBazar.service;

import com.example.integradorBazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    public void saveCliente(Cliente cli);
    
    public void deleteCliente(Long id_cliente);
    
    public void editCliente(Long id_cliente, String nombreNuevo, String apellidoNuevo, String dniNuevo);
    
    public void editCliente(Cliente cli);
    
    public Cliente findCliente(Long id_cliente);
    
    public List<Cliente> getClientes();
}
