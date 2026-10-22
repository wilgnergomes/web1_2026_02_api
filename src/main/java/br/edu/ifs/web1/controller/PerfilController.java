package br.edu.ifs.web1.controller;

import br.edu.ifs.web1.exception.ErrorResponse;
import br.edu.ifs.web1.serivces.perfil.PerfilService;
import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import br.edu.ifs.web1.serivces.perfil.form.PerfilForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("perfil")
@RequiredArgsConstructor
@Tag(name = "Perfis", description = "Endpoints para gerenciamento e consulta de perfis de usuário")
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar perfil", description = "Cadastra um novo perfil de acesso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Perfil cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Conflito de integridade nos dados",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public PerfilDTO cadastrar(@Valid @RequestBody PerfilForm form) {
        return perfilService.cadastrar(form);
    }

    @GetMapping
    @Operation(summary = "Listar todos os perfis", description = "Retorna a listagem completa de perfis cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de perfis retornada com sucesso")
    public List<PerfilDTO> getAll() {
        return perfilService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar perfil por ID", description = "Retorna os detalhes de um perfil pelo seu identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil encontrado"),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public PerfilDTO getById(@PathVariable("id") Long id) {
        return perfilService.getById(id);
    }

    @GetMapping("bynome/{nome}")
    @Operation(summary = "Buscar perfis por nome", description = "Retorna perfis que contenham o nome informado")
    @ApiResponse(responseCode = "200", description = "Lista de perfis retornada com sucesso")
    public List<PerfilDTO> getByNome(@PathVariable("nome") String nome) {
        return perfilService.getNome(nome);
    }
}
