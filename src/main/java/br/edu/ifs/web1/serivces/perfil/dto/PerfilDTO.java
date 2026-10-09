package br.edu.ifs.web1.serivces.perfil.dto;

import br.edu.ifs.web1.serivces.usuario.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PerfilDTO {
    private Long id;
    private String nome;
    private String status;
    private List<UsuarioDTO> usuarios;
}
