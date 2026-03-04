package br.org.institutoacqua.gcc.controller;



import br.org.institutoacqua.gcc.model.Sala;
import br.org.institutoacqua.gcc.service.SalaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("salas", service.listarTodas());
        return "salas";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("sala", new Sala());
        return "sala-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Sala sala) {
        service.salvar(sala);
        return "redirect:/salas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("sala", service.buscarPorId(id));
        return "sala-form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/salas";
    }
}