package br.org.institutoacqua.gcc.repository;


import br.org.institutoacqua.gcc.model.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CirurgiaRepository extends JpaRepository<Cirurgia, Long> {

    List<Cirurgia> findByData(LocalDate data);

}