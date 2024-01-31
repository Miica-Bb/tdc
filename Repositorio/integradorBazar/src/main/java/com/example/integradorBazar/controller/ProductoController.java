package com.example.integradorBazar.controller;

import com.example.integradorBazar.model.Producto;
import com.example.integradorBazar.service.IProductoService;
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
public class ProductoController {
    @Autowired
    private IProductoService prodServ;
    
    @PostMapping("/productos/crear")
    public void saveProducto(@RequestBody Producto prod) {
        prodServ.saveProducto(prod);
    }
    
    @DeleteMapping("/productos/eliminar/{id_producto}")
    public void deleteProducto(@PathVariable Long id_producto) {
        prodServ.deleteProducto(id_producto);
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return prodServ.getProductos();
    }
    
    @GetMapping("/productos/{id_producto}")
    public Producto findProducto(@PathVariable Long id_producto) {
        return prodServ.findProducto(id_producto);
    }
    
    @GetMapping ("/productos/falta_stock")
    public List<Producto> lackStockProducto() {
        return prodServ.lackStockProducto();
    }
    
    @PutMapping("/productos/editar/{id_producto}")
    public void editProducto(@PathVariable Long id_producto,
            @RequestParam (required = false, name = "nombre") String nombreNuevo,
            @RequestParam (required = false, name = "marca") String marcaNueva,
            @RequestParam (required = false, name = "costo") Double costoNuevo,
            @RequestParam (required = false, name = "cantidad_disponible") Double cantDisponibleNueva) {
        
        prodServ.editProducto(id_producto, nombreNuevo, marcaNueva, costoNuevo, cantDisponibleNueva);
    }
    
    @PutMapping("/productos/editar")
    public void editProducto(@RequestBody Producto prod) {
        prodServ.editProducto(prod);
    }
}
