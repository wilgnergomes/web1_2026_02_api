package br.edu.ifs.web1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "per_perfil", schema = "public")
public class PerfilEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_nr_id")
    private Long id;

    @Column(name = "per_tx_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "per_tx_status", length = 1, nullable = false)
    private String status;

    @ManyToMany(mappedBy = "perfis", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private List<UsuarioEntidade> usuarios;
}
