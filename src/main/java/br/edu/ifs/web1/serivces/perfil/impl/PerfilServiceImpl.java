package br.edu.ifs.web1.serivces.perfil.impl;

import br.edu.ifs.web1.model.PerfilEntidade;
import br.edu.ifs.web1.repository.PerfilRepository;
import br.edu.ifs.web1.serivces.perfil.PerfilService;
import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import br.edu.ifs.web1.serivces.perfil.form.PerfilForm;
import br.edu.ifs.web1.serivces.usuario.UsuarioService;
import br.edu.ifs.web1.serivces.usuario.impl.UsuarioServiceImpl;
import br.edu.ifs.web1.exception.ResourceNotFoundException;
import br.edu.ifs.web1.serivces.i18n.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private MessageService messageService;

    @Override
    public PerfilDTO cadastrar(PerfilForm form) {
        String status = (form.getStatus() != null && !form.getStatus().isBlank()) ? form.getStatus() : "A";
        return toDTO(perfilRepository.save(PerfilEntidade.builder()
                .nome(form.getNome())
                .status(status)
                .build()));
    }

    @Override
    public List<PerfilDTO> getAll() {
        List<PerfilEntidade> ls = perfilRepository.findAll();
        List<PerfilDTO> lsDto = new ArrayList<>();
        for (PerfilEntidade entidade : ls) {
            lsDto.add(toDTO(entidade));
        }
        return lsDto;
    }

    @Override
    public List<PerfilDTO> getNome(String nome) {
        List<PerfilEntidade> ls = perfilRepository.findByNomeContainingIgnoreCaseOrderByNome(nome);
        List<PerfilDTO> lsDto = new ArrayList<>();
        for (PerfilEntidade entidade : ls) {
            lsDto.add(toDTO(entidade));
        }
        return lsDto;
    }

    @Override
    public PerfilDTO getById(Long id) {
        return toDTO(perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageService.getMessage("erro.perfil.naoencontrado", id))));
    }

    static private PerfilDTO toDTO(PerfilEntidade entidade) {
        return PerfilDTO.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .status(entidade.getStatus())
                //.usuarios(UsuarioServiceImpl.lsEntidadeToLsDto(entidade.getUsuarios()))
                .build();
    }

    static public List<PerfilDTO> lsEntidadeToLsDto(List<PerfilEntidade> ls) {
        List<PerfilDTO> lsDto = new ArrayList<>();
        ls.forEach(perEntidade -> {
            lsDto.add(toDTO(perEntidade));
        });
        return lsDto;
    }
}
