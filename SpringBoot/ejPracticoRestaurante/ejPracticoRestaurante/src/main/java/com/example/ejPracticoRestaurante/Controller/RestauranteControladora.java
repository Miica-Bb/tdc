package com.example.ejPracticoRestaurante.Controller;

import com.example.ejPracticoRestaurante.Plato;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteControladora {
    
    @GetMapping("/infoPlato")
    @ResponseBody
    public Plato consultarPlato(@RequestParam int numPlato) {
        List<Plato> listaPlatos = new ArrayList<>();
        listaPlatos.add(new Plato(1, "pizza", 5.99, "de jamón y queso"));
        listaPlatos.add(new Plato(2, "milanesa", 2.50, "de pollo"));
        listaPlatos.add(new Plato(3, "canelones", 2.00, "2 unidades, de verdura"));
        listaPlatos.add(new Plato(4, "filet de merluza", 6.99, "a la romana con ensalada"));
        listaPlatos.add(new Plato(5, "pastel de papas", 3.25, "1/4 de tarta"));
        
        for(Plato pla : listaPlatos) {
            if(numPlato == pla.getNumPlato()) {
                return pla;
            }
        }
        
        return null;
    }
}
