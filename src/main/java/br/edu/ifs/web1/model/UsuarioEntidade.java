package br.edu.ifs.web1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_usuario", schema = "public")
public class UsuarioEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_nr_id")
    private Long id;
    @Column(name = "usu_tx_nome")
    private String nome;
    @Column(name = "usu_tx_fone")
    private String fone;
    @Column(name = "usu_tx_login")
    private String login;
    @Column(name = "usu_tx_senha")
    private String senha;
    @Column(name = "usu_dt_cadastro")
    private Date cadastro;

    @ManyToMany
    @JoinTable(
            name = "peu_per_usu",
            schema = "public",
            joinColumns = @JoinColumn(name = "usu_nr_id"),
            inverseJoinColumns = @JoinColumn(name = "per_nr_id")
    )
    @ToString.Exclude
    private List<PerfilEntidade> perfis;
}
