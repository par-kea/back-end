package co.edu.unbosque.forpets.repositories;

import co.edu.unbosque.forpets.repositories.models.ReservaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<ReservaModel, Long> {
    /*

    //correcion agregar la descripcion de la especialidad
    @Query(value = "select distinct  especialidad.id_especialidad, nombre_especialidad, descripcion_especialidad from especialidad inner join medico on (especialidad.id_especialidad = medico.id_especialidad) where medico.id_sucursal = :idSucursal",
            nativeQuery = true)
    List<EspecialidadModel> especialidadPorSucursal(@Param("idSucursal") Long sucursal);

     */
}
