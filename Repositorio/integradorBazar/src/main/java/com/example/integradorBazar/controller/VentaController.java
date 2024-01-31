package com.example.integradorBazar.controller;

import com.example.integradorBazar.dto.VenProCli;
import com.example.integradorBazar.model.Producto;
import com.example.integradorBazar.model.Venta;
import com.example.integradorBazar.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    @Autowired
    private IVentaService ventaServ;
    
    @PostMapping("/ventas/crear")
    public void saveVenta(@RequestBody Venta ven) {
        ventaServ.saveVenta(ven);
    }
    
    @DeleteMapping("/ventas/eliminar/{id_venta}")
    public void deleteVenta(@PathVariable Long id_venta) {
        ventaServ.deleteVenta(id_venta);
    }
    
    @GetMapping("/ventas")
    public List<Venta> getVentas() {
        return ventaServ.getVentas();
    }
    
    @GetMapping("/ventas/{id_venta}")
    public Venta findVenta(@PathVariable Long id_venta) {
        return ventaServ.findVenta(id_venta);
    }
    
    @GetMapping("/ventas/productos/{id_venta}")
    public List<Producto> getProductosVenta(@PathVariable Long id_venta) {
        return ventaServ.getProductosVenta(id_venta);
    }
    
    @GetMapping("/ventas/{fecha_venta}")
    public String getVentasYMontoDelDia(@PathVariable LocalDate fecha_venta) {
        return ventaServ.getMontoYVentasDelDia(fecha_venta);
    }
    
    @GetMapping("/ventas/mayor_venta")
    public VenProCli getDatosMayorVenta() {
        return ventaServ.getDatosMayorVenta();
    }
    
    @PutMapping("/ventas/editar/{id_venta}")
    public void editVenta(@PathVariable Long id_venta, 
            @RequestParam (required = false, name = "fecha_venta") LocalDate fechaVentaNueva,
            @RequestParam (required = false, name = "total") Double totalNuevo) {
        
        ventaServ.editVenta(id_venta, fechaVentaNueva, totalNuevo);
    }
    
    @PutMapping("/ventas/editar")
    public void editVenta(@RequestBody Venta ven) {
        ventaServ.editVenta(ven);
    }
}
