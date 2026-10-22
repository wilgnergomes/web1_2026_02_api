package br.edu.ifs.web1.serivces.perfil.dto;

import br.edu.ifs.web1.serivces.usuario.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Dados de retorno do perfil")
public class PerfilDTO {

    @Schema(description = "Identificador único do perfil", example = "1")
    private Long id;

    @Schema(description = "Nome do perfil de acesso", example = "ADMIN")
    private String nome;

    @Schema(description = "Status do perfil (A para Ativo, I para Inativo)", example = "A")
    private String status;

    @Schema(description = "Lista de usuários associados ao perfil")
    private List<UsuarioDTO> usuarios;
}
