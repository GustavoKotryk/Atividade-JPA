package senai.weg.entidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.weg.entidade.entity.Consultorio;
import java.util.List;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
    boolean existsByCnpj(String cnpj);

    List<Consultorio> findByNomeContainingIgnoreCase(String nome);

    List<Consultorio> findByEnderecoStartingWith(String nome);
}
