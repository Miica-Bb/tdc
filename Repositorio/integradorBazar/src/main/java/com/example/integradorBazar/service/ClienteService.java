package com.example.integradorBazar.service;

import com.example.integradorBazar.model.Cliente;
import com.example.integradorBazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public void saveCliente(Cliente cli) {
        cliRepo.save(cli);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        cliRepo.deleteById(id_cliente);
    }

    @Override
    public void editCliente(Long id_cliente, String nombreNuevo, String apellidoNuevo, String dniNuevo) {
        Cliente cli = this.findCliente(id_cliente);
        
        cli.setNombre(nombreNuevo);
        cli.setApellido(apellidoNuevo);
        cli.setDni(dniNuevo);
        
        this.saveCliente(cli);
    }

    @Override
    public void editCliente(Cliente cli) {
        this.saveCliente(cli);
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        return cliRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public List<Cliente> getClientes() {
        return cliRepo.findAll();
    }
    
    
}
