package br.edu.ifs.web1.serivces.usuario.form;

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
public class UsuarioForm {

//    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, max = 100, message = "A senha deve ter no mínimo 4 caracteres")
    private String senha;

    @NotBlank(message = "O telefone é obrigatório")
    private String fone;

    @NotBlank(message = "O login é obrigatório")
    @Size(min = 3, max = 50, message = "O login deve ter entre 3 e 50 caracteres")
    private String login;
}
