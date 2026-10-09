package br.edu.ifs.web1.controller;

import br.edu.ifs.web1.model.UsuarioEntidade;
import br.edu.ifs.web1.serivces.usuario.UsuarioService;
import br.edu.ifs.web1.serivces.usuario.dto.UsuarioDTO;
import br.edu.ifs.web1.serivces.usuario.form.UsuarioForm;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public UsuarioDTO cadastrar(@RequestBody UsuarioForm form) {
        return usuarioService.cadastrar(form);
    }
    @GetMapping("/{id}")
    public UsuarioDTO getByID(@PathVariable("id") Long id) {

        return usuarioService.getById(id);
    }

    @GetMapping
    public List<UsuarioDTO> getAll() {

        return usuarioService.getAll();
    }

    @GetMapping("bynome/{nome}")
    public List<UsuarioDTO> getByNome(@PathVariable String nome) {

        return usuarioService.getNome(nome);
    }

    @GetMapping("bynomejpql/{nome}")
    public List<UsuarioDTO> getByNomeJpql(@PathVariable String nome) {

        return usuarioService.getNomeJPQL(nome);
    }
    @GetMapping("bynomenativo/{nome}")
    public List<UsuarioDTO> getByNomeNativo(@PathVariable String nome) {

        return usuarioService.getNomeNativo(nome);
    }
}
