package com.example.integradorBazar.service;

import com.example.integradorBazar.dto.VenProCli;
import com.example.integradorBazar.model.Producto;
import com.example.integradorBazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public void saveVenta(Venta ven);

    public void deleteVenta(Long id_venta);

    public void editVenta(Long id_venta, LocalDate fechaVentaNueva, Double totalNuevo);

    public void editVenta(Venta ven);

    public Venta findVenta(Long id_venta);
    
    public Venta findVentaMayor();
    
    public VenProCli getDatosMayorVenta();

    public List<Venta> getVentas();
    
    public List<Producto> getProductosVenta(Long id_venta);
    
    public List<Venta> getVentasDelDia(LocalDate fecha);
    
    public String getMontoYVentasDelDia(LocalDate fecha);
    
    
}
