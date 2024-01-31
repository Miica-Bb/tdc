package com.example.integradorBazar.controller;

import com.example.integradorBazar.model.Cliente;
import com.example.integradorBazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService cliServ;
    
    @PostMapping("/clientes/crear")
    public void saveCliente(@RequestBody Cliente cli) {
        cliServ.saveCliente(cli);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente) {
        cliServ.deleteCliente(id_cliente);
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public void editCliente(@PathVariable Long id_cliente,
            @RequestParam (required = false, name = "nombre") String nombreNuevo,
            @RequestParam (required = false, name = "apellido") String apellidoNuevo,
            @RequestParam (required = false, name = "dni") String dniNuevo) {
        
        cliServ.editCliente(id_cliente, nombreNuevo, apellidoNuevo, dniNuevo);
    }
    
    @PutMapping("/clientes/editar")
    public void editCliente(@RequestBody Cliente cli) {
        cliServ.editCliente(cli);
    }
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return cliServ.getClientes();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente) {
        return cliServ.findCliente(id_cliente);
    }
}
