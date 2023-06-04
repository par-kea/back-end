package co.edu.unbosque.forpets.repositories;

import co.edu.unbosque.forpets.repositories.models.DatosPagoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DatosPagoRepository extends CrudRepository<DatosPagoModel, Long> {
/*
    @Query(value = "SELECT * FROM medico WHERE medico.cedula = :cedula",
            nativeQuery = true)
    MedicoModel medicoPorCedula(@Param("cedula") String cedula);

    @Query(value = "select  COUNT(distinct id_especialidad) id_especialidad from medico where id_sucursal = :sucursal",
            nativeQuery = true)
    int numeroEspecialidades(@Param("sucursal") Long sucursal);

    @Query(value = "select COUNT( *) from medico where id_sucursal = :sucursal and id_especialidad = :especialidad",
            nativeQuery = true)
    int existeEspecialidad(@Param("sucursal") Long sucursal,@Param("especialidad") Long especialidad);

 */
}
