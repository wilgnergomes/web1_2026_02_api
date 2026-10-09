package br.edu.ifs.web1.serivces.perfil;

import br.edu.ifs.web1.model.PerfilEntidade;
import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import br.edu.ifs.web1.serivces.perfil.form.PerfilForm;

import java.util.List;

public interface PerfilService {
    PerfilDTO cadastrar(PerfilForm form);
    List<PerfilDTO> getAll();
    List<PerfilDTO> getNome(String nome);
    PerfilDTO getById(Long id);
}
