package br.edu.ifs.web1.serivces.perfil.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilForm {
    private String nome;
    private String status;
}
