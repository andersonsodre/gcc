package br.org.institutoacqua.gcc.controller;

import br.org.institutoacqua.gcc.service.ProcedimentoService;
import br.org.institutoacqua.gcc.model.Procedimento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    private final ProcedimentoService service;

    public ProcedimentoController(ProcedimentoService service) {
        this.service = service;
    }

    // 📋 LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("procedimentos", service.listarTodos());
        return "procedimentos";
    }

    // ➕ NOVO
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("procedimento", new Procedimento());
        return "procedimento-form";
    }

    // 💾 SALVAR (novo e edição)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Procedimento procedimento) {
        service.salvar(procedimento);
        return "redirect:/procedimentos";
    }

    // ✏ EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Procedimento procedimento = service.buscarPorId(id);
        model.addAttribute("procedimento", procedimento);
        return "procedimento-form";
    }

    // ❌ EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/procedimentos";
    }
}