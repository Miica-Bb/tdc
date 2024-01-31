package com.example.integradorBazar.service;

import com.example.integradorBazar.model.Producto;
import com.example.integradorBazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public void saveProducto(Producto prod) {
        prodRepo.save(prod);
    }

    @Override
    public void deleteProducto(Long id_producto) {
        prodRepo.deleteById(id_producto);
    }

    @Override
    public void editProducto(Long id_producto, String nombreNuevo, String marcaNueva, Double costoNuevo, Double cantDisponibleNueva) {
        Producto prod = this.findProducto(id_producto);
        
        prod.setNombre(nombreNuevo);
        prod.setMarca(marcaNueva);
        prod.setCosto(costoNuevo);
        prod.setCantidad_disponible(cantDisponibleNueva);
        
        this.saveProducto(prod);
    }

    @Override
    public void editProducto(Producto prod) {
        prodRepo.save(prod);
    }

    @Override
    public Producto findProducto(Long id_producto) {
        return prodRepo.findById(id_producto).orElse(null);
    }

    @Override
    public List<Producto> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Double checkStock(Producto prod) {
        return prod.getCantidad_disponible();
    }

    @Override
    public boolean updateStock(Producto prod) {
        Double cantidadActual = this.checkStock(prod);

        if (cantidadActual.compareTo(0.0) > 0) {
            Double cantidadNueva = cantidadActual - 1;

            if (cantidadNueva.compareTo(0.0) >= 0) {
                prod.setCantidad_disponible(cantidadNueva);
                this.saveProducto(prod);

                return true;
            }
        }

        return false;
    }

    @Override
    public List<Producto> lackStockProducto() {
        List<Producto> listaProductos = this.getProductos();
        
        List<Producto> pocoStock = new ArrayList<>();
        
        for(Producto prod : listaProductos) {
            if(prod.getCantidad_disponible().compareTo(5.0) < 0) {
                pocoStock.add(prod);
            }
        }
        
        return pocoStock;
    }
    
}
