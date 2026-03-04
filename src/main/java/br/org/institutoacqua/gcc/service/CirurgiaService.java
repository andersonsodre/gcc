package br.org.institutoacqua.gcc.service;


import br.org.institutoacqua.gcc.model.Cirurgia;
import br.org.institutoacqua.gcc.repository.CirurgiaRepository;
import org.springframework.stereotype.Service;
import br.org.institutoacqua.gcc.model.StatusCirurgia;

import java.util.List;

@Service
public class CirurgiaService {

    private final CirurgiaRepository repository;

    public CirurgiaService(CirurgiaRepository repository) {
        this.repository = repository;
    }

    public List<Cirurgia> listarTodas() {
        return repository.findAll();
    }

    public Cirurgia buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void salvar(Cirurgia cirurgia) {
        repository.save(cirurgia);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    // ✅ MÉTODO NOVO COM 4 PARÂMETROS
    public List<Cirurgia> filtrar(String paciente,
                                  String procedimento,
                                  String data,
                                  StatusCirurgia status) {

        List<Cirurgia> lista = repository.findAll();

        // PACIENTE
        if (paciente != null && !paciente.isBlank()) {
            String pacienteLower = paciente.toLowerCase();

            lista = lista.stream()
                    .filter(c -> c.getPaciente() != null &&
                            c.getPaciente().toLowerCase().contains(pacienteLower))
                    .toList();
        }

        // PROCEDIMENTO (agora é objeto)
        if (procedimento != null && !procedimento.isBlank()) {
            String procLower = procedimento.toLowerCase();

            lista = lista.stream()
                    .filter(c -> c.getProcedimento() != null &&
                            (
                                    c.getProcedimento().getNome().toLowerCase().contains(procLower)
                                            || c.getProcedimento().getCodigo().toLowerCase().contains(procLower)
                            ))
                    .toList();
        }

        // DATA
        if (data != null && !data.isBlank()) {
            lista = lista.stream()
                    .filter(c -> c.getData() != null &&
                            c.getData().toString().equals(data))
                    .toList();
        }

        // STATUS (enum)
        if (status != null) {
            lista = lista.stream()
                    .filter(c -> c.getStatus() == status)
                    .toList();
        }

        return lista;
    }
}