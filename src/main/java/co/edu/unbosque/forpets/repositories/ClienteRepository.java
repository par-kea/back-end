package co.edu.unbosque.forpets.repositories;

import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {

    @Query(value = "SELECT * FROM cliente WHERE cliente.cc_cliente = :cc_cliente",
            nativeQuery = true)
    ClienteModel clientePorCedula(@Param("cc_cliente") String cedula);
}
