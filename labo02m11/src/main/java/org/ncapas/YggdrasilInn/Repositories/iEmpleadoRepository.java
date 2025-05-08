package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Empleado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Transactional
public interface iEmpleadoRepository extends iGenericRepository<Empleado, Long> {
    // JPA
    List<Empleado> findBySucursalNombreSucursalAndCoordinadorTrue(String nombreSucursal);

    // JPQL
    @Query("SELECT e FROM Empleado e WHERE e.departamento = :departamento")
    List<Empleado> findByDepartamento(@Param("departamento") String departamento);

    //nativa
    @Query(value = "SELECT * FROM empleado WHERE coordinador = true AND departamento = :departamento", nativeQuery = true)
    List<Empleado> findCoordinadoresPorDepartamentoNative(@Param("departamento") String departamento);
}
