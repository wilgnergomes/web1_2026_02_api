package br.edu.ifs.web1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("olamundo")
public class OlaMundoController {
    @GetMapping
    public String olaMundo() {
        return "Ola Mundo";
    }

    @GetMapping("/ola2")
    public String olaMundo2() {
          return "Ola Mundo2";
    }
    @PostMapping
    public String olaMundoPost() {
        return "Ola Mundo Post";
    }

    @DeleteMapping
    public String olaMundoDeleteMapping() {
        return "Ola Mundo DeleteMapping";
    }

    @PutMapping
    public String olaMundoPutMapping() {
        return "Ola Mundo PutMapping";
    }

    @PatchMapping
    public String olaMundoPatchMapping() {
        return "Ola Mundo PatchMapping";
    }

}
