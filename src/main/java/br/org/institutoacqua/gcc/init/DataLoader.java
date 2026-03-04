package br.org.institutoacqua.gcc.init;

import br.org.institutoacqua.gcc.model.Usuario;
import br.org.institutoacqua.gcc.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository,
                      PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (usuarioRepository.findByUsername("admin").isEmpty()) {

            Usuario u = new Usuario();
            u.setUsername("admin");
            u.setPassword(passwordEncoder.encode("123"));
            u.setAtivo(true);

            usuarioRepository.save(u);

            System.out.println("USUÁRIO ADMIN CRIADO");
        }
    }
}