package br.edu.ifs.web1.repository;

import br.edu.ifs.web1.model.PerfilEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntidade, Long> {

    List<PerfilEntidade> findByNomeContainingIgnoreCaseOrderByNome(String nome);

    @Query(
            nativeQuery = true,
    value =
    """
         select p.* from per_perfil p
         inner join peu_per_usu peu on peu.per_nr_id = p.per_nr_id
         inner join usu_usuario u on u.usu_nr_id = peu.usu_nr_id
         where u.usu_nr_id = ?1   
    """)
    List<PerfilEntidade> getByUsuario(Long usuNrId);
}
