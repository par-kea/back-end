package co.edu.unbosque.forpets.repositories;

import co.edu.unbosque.forpets.repositories.models.RegistroModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistroRepository extends CrudRepository<RegistroModel, Long> {
    /*

    @Query(value = "select  COUNT(distinct id_especialidad) id_especialidad from medico where id_sucursal = :sucursal",
            nativeQuery = true)
    int numeroEspecialidades(@Param("sucursal") Long sucursal);

    @Query(value = "select COUNT( *) from medico where id_sucursal = :sucursal and id_especialidad = :especialidad",
            nativeQuery = true)
    int existeEspecialidad(@Param("sucursal") Long sucursal,@Param("especialidad") Long especialidad);

     */
}
