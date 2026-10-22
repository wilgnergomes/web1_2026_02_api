package br.edu.ifs.web1.controller;

import br.edu.ifs.web1.exception.ErrorResponse;
import br.edu.ifs.web1.serivces.usuario.UsuarioService;
import br.edu.ifs.web1.serivces.usuario.dto.UsuarioDTO;
import br.edu.ifs.web1.serivces.usuario.form.UsuarioForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@Tag(name = "Usuários", description = "Endpoints para gerenciamento e consulta de usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar usuário", description = "Cadastra um novo usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Conflito de integridade nos dados",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public UsuarioDTO cadastrar(@Valid @RequestBody UsuarioForm form) {
        return usuarioService.cadastrar(form);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna os detalhes de um usuário pelo seu identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public UsuarioDTO getByID(@PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários", description = "Retorna a listagem completa de usuários cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    public List<UsuarioDTO> getAll() {
        return usuarioService.getAll();
    }

    @GetMapping("bynome/{nome}")
    @Operation(summary = "Buscar usuários por nome (Spring Data Derived Query)", description = "Retorna usuários que contenham o nome informado")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    public List<UsuarioDTO> getByNome(@PathVariable("nome") String nome) {
        return usuarioService.getNome(nome);
    }

    @GetMapping("bynomejpql/{nome}")
    @Operation(summary = "Buscar usuários por nome (JPQL)", description = "Retorna usuários utilizando consulta customizada via JPQL")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    public List<UsuarioDTO> getByNomeJpql(@PathVariable("nome") String nome) {
        return usuarioService.getNomeJPQL(nome);
    }

    @GetMapping("bynomenativo/{nome}")
    @Operation(summary = "Buscar usuários por nome (SQL Nativo)", description = "Retorna usuários utilizando consulta customizada via SQL nativo")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    public List<UsuarioDTO> getByNomeNativo(@PathVariable("nome") String nome) {
        return usuarioService.getNomeNativo(nome);
    }
}
