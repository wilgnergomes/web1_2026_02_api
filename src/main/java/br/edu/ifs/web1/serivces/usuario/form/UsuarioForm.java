package br.edu.ifs.web1.serivces.usuario.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioForm {
    private String nome;
    private String senha;
    private String fone;
    private String login;
}
