package com.example.integradorBazar.repository;

import com.example.integradorBazar.model.Venta;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
//    @Query("SELECT * FROM venta WHERE fecha_venta IN fecha")
//    List<Venta> findByDate(@Param("fecha") LocalDate fecha_venta);
//    
//    @Query("SELECT * FROM venta ORDER BY total DESC LIMIT 1")
//    Venta findByTotal();
}
