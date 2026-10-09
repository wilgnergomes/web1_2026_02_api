package br.edu.ifs.web1.serivces.usuario.impl;

import br.edu.ifs.web1.model.PerfilEntidade;
import br.edu.ifs.web1.model.UsuarioEntidade;
import br.edu.ifs.web1.repository.UsuarioRepository;
import br.edu.ifs.web1.serivces.perfil.PerfilService;
import br.edu.ifs.web1.serivces.perfil.dto.PerfilDTO;
import br.edu.ifs.web1.serivces.perfil.impl.PerfilServiceImpl;
import br.edu.ifs.web1.serivces.usuario.UsuarioService;
import br.edu.ifs.web1.serivces.usuario.dto.UsuarioDTO;
import br.edu.ifs.web1.serivces.usuario.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired PerfilService perfilService;

    @Override
    public UsuarioDTO cadastrar(UsuarioForm usu) {
        return toDTO(usuarioRepository.save(UsuarioEntidade.builder()
                .nome(usu.getNome())
                .fone(usu.getFone())
                .login(usu.getLogin())
                .senha(usu.getSenha())
                .cadastro(new Date())
                .build()));
    }

    @Override
    public List<UsuarioDTO> getAll() {
        List<UsuarioEntidade> ls = usuarioRepository.findAll();
        List<UsuarioDTO> lsDto = new ArrayList<>();
        for (UsuarioEntidade entidade : ls) {
            lsDto.add(toDTO(entidade));
        }
        return lsDto;
    }

    @Override
    public List<UsuarioDTO> getNome(String nome) {
        List<UsuarioEntidade> ls = usuarioRepository.findByNomeContainingIgnoreCaseOrderByNome(nome);
        List<UsuarioDTO> lsDto = new ArrayList<>();
        for (UsuarioEntidade entidade : ls) {
            lsDto.add(toDTO(entidade));
        }
        return lsDto;
    }

    @Override
    public List<UsuarioDTO> getNomeJPQL(String nome) {
        List<UsuarioEntidade> ls = usuarioRepository.findByNome("%"  +nome + "%");
        List<UsuarioDTO> lsDto = new ArrayList<>();
        for (UsuarioEntidade entidade : ls) {
            lsDto.add(toDTO(entidade));
        }
        return lsDto;
    }

    @Override
    public List<UsuarioDTO> getNomeNativo(String nome) {
        List<UsuarioEntidade> ls = usuarioRepository.findByNomeNativo(nome);
        List<UsuarioDTO> lsDto = new ArrayList<>();
        for (UsuarioEntidade entidade : ls) {
            lsDto.add(toDTO(entidade));
        }
        return lsDto;
    }

    @Override
    public UsuarioDTO getById(Long id) {
        return toDTO(usuarioRepository.findById(id).orElseThrow());
    }

    static private UsuarioDTO toDTO(UsuarioEntidade entidade) {
        return UsuarioDTO.builder()
                .nome(entidade.getNome())
                .id(entidade.getId())
                .login(entidade.getLogin())
                .fone(entidade.getFone())
                .cadastro(entidade.getCadastro())
                .perfis(PerfilServiceImpl.lsEntidadeToLsDto(entidade.getPerfis()))
                .build();
    }

    static public List<UsuarioDTO> lsEntidadeToLsDto(List<UsuarioEntidade> ls) {
        List<UsuarioDTO> lsDto = new ArrayList<>();
        ls.forEach(usuEntidade -> {
            lsDto.add(toDTO(usuEntidade));
        });
        return lsDto;
    }
}
