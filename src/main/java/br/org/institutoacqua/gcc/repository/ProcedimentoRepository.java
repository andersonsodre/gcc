package br.org.institutoacqua.gcc.repository;



import br.org.institutoacqua.gcc.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

    Optional<Procedimento> findByCodigo(String codigo);

}