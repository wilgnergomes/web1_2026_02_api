package br.edu.ifs.web1.serivces.usuario;

import br.edu.ifs.web1.model.UsuarioEntidade;
import br.edu.ifs.web1.serivces.usuario.dto.UsuarioDTO;
import br.edu.ifs.web1.serivces.usuario.form.UsuarioForm;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO cadastrar(UsuarioForm usu);
    List<UsuarioDTO> getAll();
    List<UsuarioDTO> getNome(String nome);
    List<UsuarioDTO> getNomeJPQL(String nome);
    List<UsuarioDTO> getNomeNativo(String nome);
    UsuarioDTO getById(Long id);
}
