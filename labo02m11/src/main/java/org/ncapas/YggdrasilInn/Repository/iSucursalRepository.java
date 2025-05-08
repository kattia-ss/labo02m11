package org.ncapas.YggdrasilInn.Repository;

import org.ncapas.YggdrasilInn.Domain.Entities.Sucursal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface iSucursalRepository extends iGenericRepository<Sucursal, Long> {
    // JPA
    List<Sucursal> findByNombreSucursalContainingIgnoreCase(String nombreSucursal);

    // JPQL
    @Query("SELECT s FROM Sucursal s WHERE s.direccion LIKE %:direccion%")
    List<Sucursal> findByDireccion(@Param("direccion") String direccion);

    // Nativa
    @Query( nativeQuery = true, value = "SELECT * FROM sucursal WHERE nombre_sucursal = :nombre")
    List<Sucursal> findByNombreSucursalNative(@Param("nombre") String nombre);
}
