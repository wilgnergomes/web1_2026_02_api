package br.edu.ifs.web1.serivces.perfil.form;

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
@Schema(description = "Dados para cadastro de um novo perfil")
public class PerfilForm {

    @NotBlank(message = "{perfil.nome.obrigatorio}")
    @Size(min = 2, max = 100, message = "{perfil.nome.size}")
    @Schema(description = "Nome do perfil de acesso", example = "ADMIN")
    private String nome;

    @Size(max = 1, message = "{perfil.status.size}")
    @Schema(description = "Status do perfil (ex: A para Ativo, I para Inativo)", example = "A", defaultValue = "A")
    private String status;
}
