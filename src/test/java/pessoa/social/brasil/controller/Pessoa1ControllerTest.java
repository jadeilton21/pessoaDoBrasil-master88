package pessoa.social.brasil.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class Pessoa1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve Devolver Código http 400 quando informações estiverem invalidas")
    @WithMockUser
    void cadastrar() throws Exception {


        var response = mockMvc
                .perform(post("/pessoa"))
                .andReturn().getResponse();


        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve Devolver Código http 400 quando informações estiverem invalidas")
    @WithMockUser
    void listar() throws Exception {

        var response = mockMvc
                .perform(post("/pessoa"))
                .andReturn().getResponse();


        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());


    }


    @Test
    @DisplayName("Deve Devolver Código http 400 quando informações estiverem invalidas")
    @WithMockUser
    void atualizar() throws Exception {


        var response = mockMvc
                .perform(post("/pessoa"))
                .andReturn().getResponse();


        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    @DisplayName("Deve Devolver Código Http 400 quando Informações Estiverem Invalidas ")
    @WithMockUser
    void excluir()throws Exception {

        var response = mockMvc
                .perform(post("/pessoa"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());






    }

    @Test
    @DisplayName("Deve Devolver Código Http 400 quando Informações estiverem Invalidas")
    @WithMockUser
    void detalhar()throws Exception {

        var response = mockMvc
                .perform(post("/pessoa"))
                .andReturn().getResponse();


        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}