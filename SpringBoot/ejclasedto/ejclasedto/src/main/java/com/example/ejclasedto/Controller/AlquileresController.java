package com.example.ejclasedto.Controller;

import com.example.ejclasedto.Inquilino;
import com.example.ejclasedto.Propiedad;
import com.example.ejclasedto.PropiedadDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlquileresController {
    
    @GetMapping("/propiedad/{id}")
    @ResponseBody
    public PropiedadDTO devolverPropiedad(@PathVariable int id) {
        //en realidad estos objs los traería de una bdd, no los creo yo, pero acá lo hago para simular valores
        Propiedad prop = new Propiedad(id, "Casa", "Av. Siempre Viva 752", 200.0, 250000.0);
        Inquilino inq = new Inquilino(1, "Homero", "Simpson", "11222333", "Inspector de Seguridad");
        
        PropiedadDTO PropDTO = new PropiedadDTO();
        PropDTO.setId_propiedad(prop.getId_propiedad());
        PropDTO.setTipo(prop.getTipo());
        PropDTO.setDireccion(prop.getDireccion());
        PropDTO.setValor_alquiler(prop.getValor_alquiler());
        PropDTO.setNombre_inquilino(inq.getNombre());
        PropDTO.setApellido_inquilino(inq.getApellido());
        
        return PropDTO;
    }
}
