package br.org.institutoacqua.gcc.controller;

import br.org.institutoacqua.gcc.model.Cirurgia;
import br.org.institutoacqua.gcc.model.Procedimento;
import br.org.institutoacqua.gcc.model.StatusCirurgia;
import br.org.institutoacqua.gcc.repository.ProcedimentoRepository;
import br.org.institutoacqua.gcc.service.CirurgiaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cirurgias")
public class CirurgiaController {

    private final CirurgiaService service;
    private final ProcedimentoRepository procedimentoRepository;

    // 🔥 Injeção pelo construtor (forma correta)
    public CirurgiaController(CirurgiaService service,
                              ProcedimentoRepository procedimentoRepository) {
        this.service = service;
        this.procedimentoRepository = procedimentoRepository;
    }

    // LISTAR + FILTRO
    @GetMapping
    public String listar(
            @RequestParam(required = false) String paciente,
            @RequestParam(required = false) String procedimento,
            @RequestParam(required = false) String data,
            @RequestParam(required = false) StatusCirurgia status,
            Model model) {

        model.addAttribute("cirurgias",
                service.filtrar(paciente, procedimento, data, status));

        model.addAttribute("paciente", paciente);
        model.addAttribute("procedimento", procedimento);
        model.addAttribute("data", data);
        model.addAttribute("status", status);

        return "cirurgias";
    }

    // NOVA
    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("cirurgia", new Cirurgia());
        model.addAttribute("procedimentos", procedimentoRepository.findAll()); // 🔥 IMPORTANTE
        return "cirurgia-form";
    }

    // SALVAR
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cirurgia cirurgia,
                         @RequestParam("procedimentoId") Long procedimentoId) {

        Procedimento procedimento = procedimentoRepository
                .findById(procedimentoId)
                .orElseThrow();

        cirurgia.setProcedimento(procedimento);

        service.salvar(cirurgia); // ✅ CORRETO

        return "redirect:/cirurgias";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cirurgia", service.buscarPorId(id));
        model.addAttribute("procedimentos", procedimentoRepository.findAll()); // 🔥 IMPORTANTE
        return "cirurgia-form";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/cirurgias";
    }
}