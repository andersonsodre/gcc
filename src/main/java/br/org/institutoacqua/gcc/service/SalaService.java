package br.org.institutoacqua.gcc.service;



import br.org.institutoacqua.gcc.model.Sala;
import br.org.institutoacqua.gcc.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public List<Sala> listarTodas() {
        return repository.findAll();
    }

    public Sala salvar(Sala sala) {
        return repository.save(sala);
    }

    public Sala buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}