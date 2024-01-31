package com.example.integradorBazar.service;

import com.example.integradorBazar.dto.VenProCli;
import com.example.integradorBazar.model.Producto;
import com.example.integradorBazar.model.Venta;
import com.example.integradorBazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired 
    private ProductoService prodServ;

    @Override
    public void saveVenta(Venta ven) {
        List<Producto> listaProductosSolicitados = ven.getListaProductos();
        List<Producto> productosDisponibles = new ArrayList<>();
        
        Double valorFinal = 0.0;
        
        for(Producto prod : listaProductosSolicitados) {
            Producto productoBDD = prodServ.findProducto(prod.getId_producto());
            boolean actualizar = prodServ.updateStock(productoBDD);
            
            if (actualizar == true) {
                valorFinal += productoBDD.getCosto();
                productosDisponibles.add(productoBDD);
            }
        }
        
        ven.setListaProductos(productosDisponibles);
        ven.setTotal(valorFinal);
        
        ventaRepo.save(ven);
    }

    @Override
    public void deleteVenta(Long id_venta) {
        ventaRepo.deleteById(id_venta);
    }

    @Override
    public void editVenta(Long id_venta, LocalDate fechaVentaNueva, Double totalNuevo) {
        Venta ven = this.findVenta(id_venta);

        ven.setFecha_venta(fechaVentaNueva);
        ven.setTotal(totalNuevo);

        this.saveVenta(ven);
    }

    @Override
    public void editVenta(Venta ven) {
        this.saveVenta(ven);
    }

    @Override
    public Venta findVenta(Long id_venta) {
        return ventaRepo.findById(id_venta).orElse(null);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public List<Producto> getProductosVenta(Long id_venta) {
        Venta ven = this.findVenta(id_venta);
        
        return ven.getListaProductos();
    }

    @Override
    public List<Venta> getVentasDelDia(LocalDate fecha) {
        List<Venta> listaVentas = this.getVentas();
        List<Venta> listaVentasFecha = new ArrayList<>();
        
        for(Venta ven : listaVentas) {
            if(ven.getFecha_venta().equals(fecha)) {
                listaVentasFecha.add(ven);
            }
        }
        return listaVentasFecha;
    }
    
    @Override
    public String getMontoYVentasDelDia(LocalDate fecha) {
        List<Venta> totalVentasDia = this.getVentasDelDia(fecha);
        Double totalGananciaDia = 0.0;
        
        for(Venta ven : totalVentasDia) {
            totalGananciaDia += ven.getTotal();
        }
        
        return "Día " + fecha + ":\n Ventas: " + totalVentasDia.size() + "\n Ganancia: " + totalGananciaDia;
    }

    @Override
    public Venta findVentaMayor() {
        List<Venta> listaVentas = this.getVentas();
        Venta ventaMayor = new Venta();
        Double mayorMontoVenta = 0.0;
        
        for(Venta ven : listaVentas) {
            if(ven.getTotal().compareTo(mayorMontoVenta) > 0) {
                mayorMontoVenta = ven.getTotal();
                ventaMayor = ven;
            }
        }
        
        return ventaMayor;
    }

    @Override
    public VenProCli getDatosMayorVenta() {
        Venta ven = this.findVentaMayor();
        VenProCli vpcDTO = new VenProCli();
        
        vpcDTO.setId_venta(ven.getId_venta());
        vpcDTO.setTotal(ven.getTotal());
        vpcDTO.setCantidad_productos(ven.getListaProductos().size());
        vpcDTO.setNombre_cliente(ven.getUnCliente().getNombre());
        vpcDTO.setApellido_cliente(ven.getUnCliente().getApellido());
        
        return vpcDTO;
    }
}
