package br.edu.ifs.web1.repository;

import br.edu.ifs.web1.model.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, Long> {
//UsuarioRepository = nome do repository, ideal que seja o mesmo nome da tabela
//extends JpaRepository = deve herdade dessa classe (CRUDRepository)
//<UsuarioEntidade, Long> = O primeiro indica o tipo do objeto, e o segundo, o tipo do ID

    List<UsuarioEntidade> findByNomeContainingIgnoreCaseOrderByNome(String nome);

    @Query("""
        select usu from UsuarioEntidade usu
                where usu.nome like :nome
                order by usu.nome
        """)
    List<UsuarioEntidade> findByNome(@Param("nome")String nome);

    @Query(nativeQuery = true,
    value = """
        select * from usu_usuario 
        where usu_tx_nome like '%'||:nome || '%' 
        order by usu_tx_nome
        """)
    List<UsuarioEntidade> findByNomeNativo(@Param("nome") String nome);
}
