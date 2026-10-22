package br.edu.ifs.web1.serivces.usuario.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro de um novo usuário")
public class UsuarioForm {

    @NotBlank(message = "{usuario.nome.obrigatorio}")
    @Size(min = 2, max = 100, message = "{usuario.nome.size}")
    @Schema(description = "Nome completo do usuário", example = "Maria Silva")
    private String nome;

    @NotBlank(message = "{usuario.senha.obrigatorio}")
    @Size(min = 4, max = 100, message = "{usuario.senha.size}")
    @Schema(description = "Senha de acesso", example = "123456")
    private String senha;

    @NotBlank(message = "{usuario.fone.obrigatorio}")
    @Schema(description = "Telefone de contato", example = "(79) 99999-8888")
    private String fone;

    @NotBlank(message = "{usuario.login.obrigatorio}")
    @Size(min = 3, max = 50, message = "{usuario.login.size}")
    @Schema(description = "Login único do usuário", example = "maria.silva")
    private String login;
}
