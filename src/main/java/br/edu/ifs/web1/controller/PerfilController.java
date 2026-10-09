package br.edu.ifs.web1.controller;

import br.edu.ifs.web1.serivces.perfil.PerfilService;
import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("perfil")
@RequiredArgsConstructor
public class PerfilController {
    final private PerfilService perfilService;
    @GetMapping
    public List<PerfilDTO> getAll() {
        return perfilService.getAll();
    }
}
