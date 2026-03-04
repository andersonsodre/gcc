package br.org.institutoacqua.gcc.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.institutoacqua.gcc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}