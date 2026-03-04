package br.org.institutoacqua.gcc.service;



import br.org.institutoacqua.gcc.model.Procedimento;
import br.org.institutoacqua.gcc.repository.ProcedimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

    private final ProcedimentoRepository repository;

    public ProcedimentoService(ProcedimentoRepository repository) {
        this.repository = repository;
    }

    public List<Procedimento> listarTodos() {
        return repository.findAll();
    }

    public Procedimento salvar(Procedimento procedimento) {
        return repository.save(procedimento);
    }

    public Procedimento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedimento não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}