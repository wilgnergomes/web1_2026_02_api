package br.edu.ifs.web1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("olamundo")
@Tag(name = "Exemplos / Olá Mundo", description = "Endpoints de exemplo demonstrando métodos HTTP")
public class OlaMundoController {

    @GetMapping
    @Operation(summary = "Exemplo GET simples", description = "Retorna uma mensagem 'Ola Mundo'")
    public String olaMundo() {
        return "Ola Mundo";
    }

    @GetMapping("/ola2")
    @Operation(summary = "Exemplo GET alternativo", description = "Retorna uma mensagem 'Ola Mundo2'")
    public String olaMundo2() {
        return "Ola Mundo2";
    }

    @PostMapping
    @Operation(summary = "Exemplo POST", description = "Retorna uma mensagem de teste para POST")
    public String olaMundoPost() {
        return "Ola Mundo Post";
    }

    @DeleteMapping
    @Operation(summary = "Exemplo DELETE", description = "Retorna uma mensagem de teste para DELETE")
    public String olaMundoDeleteMapping() {
        return "Ola Mundo DeleteMapping";
    }

    @PutMapping
    @Operation(summary = "Exemplo PUT", description = "Retorna uma mensagem de teste para PUT")
    public String olaMundoPutMapping() {
        return "Ola Mundo PutMapping";
    }

    @PatchMapping
    @Operation(summary = "Exemplo PATCH", description = "Retorna uma mensagem de teste para PATCH")
    public String olaMundoPatchMapping() {
        return "Ola Mundo PatchMapping";
    }
}
