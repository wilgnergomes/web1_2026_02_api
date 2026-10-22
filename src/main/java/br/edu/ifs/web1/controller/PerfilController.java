package br.edu.ifs.web1.controller;

import br.edu.ifs.web1.serivces.perfil.PerfilService;
import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import br.edu.ifs.web1.serivces.perfil.form.PerfilForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("perfil")
@RequiredArgsConstructor
public class PerfilController {
    final private PerfilService perfilService;

    @PostMapping
    public PerfilDTO cadastrar(@Valid @RequestBody PerfilForm form) {
        return perfilService.cadastrar(form);
    }

    @GetMapping
    public List<PerfilDTO> getAll() {
        return perfilService.getAll();
    }

    @GetMapping("/{id}")
    public PerfilDTO getById(@PathVariable("id") Long id) {
        return perfilService.getById(id);
    }

    @GetMapping("bynome/{nome}")
    public List<PerfilDTO> getByNome(@PathVariable("nome") String nome) {
        return perfilService.getNome(nome);
    }
}

