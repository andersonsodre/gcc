package br.org.institutoacqua.gcc.repository;


import br.org.institutoacqua.gcc.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}