package co.edu.unbosque.forpets.repositories;

import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.ParqueaderoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ParqueaderoResposity extends CrudRepository<ParqueaderoModel, Long> {

    @Query(value = "SELECT * FROM parqueadero WHERE parqueadero.id_parqueadero = :id_parqueadero",
            nativeQuery = true)
    ParqueaderoModel idParqueadero(@Param("id_parqueadero") String id_parqueadero);
    /*

    @Query(value = "select  COUNT(distinct id_especialidad) id_especialidad from medico where id_sucursal = :sucursal",
            nativeQuery = true)
    int numeroEspecialidades(@Param("sucursal") Long sucursal);

    @Query(value = "select COUNT( *) from medico where id_sucursal = :sucursal and id_especialidad = :especialidad",
            nativeQuery = true)
    int existeEspecialidad(@Param("sucursal") Long sucursal,@Param("especialidad") Long especialidad);

     */
}
