package br.edu.ifs.web1.i18n;

import br.edu.ifs.web1.config.InternacionalizacaoConfig;
import br.edu.ifs.web1.controller.UsuarioController;
import br.edu.ifs.web1.exception.GlobalExceptionHandler;
import br.edu.ifs.web1.serivces.usuario.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
@Import({InternacionalizacaoConfig.class, GlobalExceptionHandler.class})
class InternacionalizacaoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioService usuarioService;

    @Test
    void deveRetornarMensagensEmPortuguesPorPadrao() throws Exception {
        String jsonInvalido = """
            {
                "nome": "",
                "senha": "12",
                "fone": "",
                "login": ""
            }
        """;

        mockMvc.perform(post("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.senha").value("A senha deve ter no mínimo 4 caracteres"));
    }

    @Test
    void deveRetornarMensagensEmInglesQuandoAcceptLanguageForEn() throws Exception {
        String jsonInvalido = """
            {
                "nome": "",
                "senha": "12",
                "fone": "",
                "login": ""
            }
        """;

        mockMvc.perform(post("/usuario")
                        .header(HttpHeaders.ACCEPT_LANGUAGE, "en")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.senha").value("Password must have at least 4 characters"));
    }

    @Test
    void deveRetornarMensagensEmEspanholQuandoAcceptLanguageForEs() throws Exception {
        String jsonInvalido = """
            {
                "nome": "",
                "senha": "12",
                "fone": "",
                "login": ""
            }
        """;

        mockMvc.perform(post("/usuario")
                        .header(HttpHeaders.ACCEPT_LANGUAGE, "es")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.senha").value("La contraseña debe tener al menos 4 caracteres"));
    }
}
