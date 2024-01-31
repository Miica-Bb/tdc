package com.example.integradorBazar.service;

import com.example.integradorBazar.model.Producto;
import java.util.List;

public interface IProductoService {

    public void saveProducto(Producto prod);
    
    public void deleteProducto(Long id_producto);
    
    public void editProducto(Long id_producto, String nombreNuevo, String marcaNueva, Double costoNuevo, Double cantDisponibleNueva);
    
    public void editProducto(Producto prod);
        
    public Producto findProducto(Long id_producto);
    
    public List<Producto> getProductos();
    
    public Double checkStock(Producto prod);

    public boolean updateStock(Producto prod);
    
    public List<Producto> lackStockProducto();
}
