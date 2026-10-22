package br.edu.ifs.web1.serivces.usuario.dto;

import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Dados de retorno do usuário")
public class UsuarioDTO {

    @Schema(description = "Identificador único do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome completo do usuário", example = "Maria Silva")
    private String nome;

    @Schema(description = "Telefone de contato", example = "(79) 99999-8888")
    private String fone;

    @Schema(description = "Login do usuário", example = "maria.silva")
    private String login;

    @Schema(description = "Data e hora do cadastro", example = "2026-10-22T14:30:00.000+00:00")
    private Date cadastro;

    @Schema(description = "Lista de perfis vinculados ao usuário")
    private List<PerfilDTO> perfis;
}
