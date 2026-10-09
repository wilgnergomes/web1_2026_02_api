package br.edu.ifs.web1.serivces.usuario.dto;

import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import jakarta.persistence.Column;
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
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String fone;
    private String login;
    private Date cadastro;
    private List<PerfilDTO> perfis;
}
