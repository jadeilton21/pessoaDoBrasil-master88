package pessoa.social.brasil.domain.pessoa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pessoa.social.brasil.domain.consultaNoSistema.ConsultaNoSistema;
import pessoa.social.brasil.domain.endereco.DadosEndereco;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PessoaRespositoryTest {


    @Autowired
    private PessoaRespository pessoaRespository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deve devolver null quando o a pessoa não estiver disponivel da data marcada")
    void testandoRepositoryDeUmaPessoa_cenario1(){

        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);


            // tem que fazer o cadastro da pessoa no banco de dados para simular essa parte do teste
        //var pessoa = cadastrarPessoaNaVida("Pessoa","pessoa@gmail.com","10050030029","22","82988994066",Profissoess.JIUJITERO);
        //cadastrarPessoaNoSistema(pessoa,proximaSegundaAs10);

    }

    private Pessoa cadastrarPessoaNaVida(String nome, String email, String cpf,String idade, String telefone, Profissoess profissoess) {
        var pessoa = new Pessoa(dadosPessoa(nome,email,cpf,idade, telefone,profissoess));
        em.persist(pessoa);
        return pessoa;
    }

    private DadosCadastrarPessoa dadosPessoa(String nome, String email, String cpf, String idade, String telefone,Profissoess profissoess) {

        return new DadosCadastrarPessoa(
                nome,
                email,
                cpf,
                idade,
                telefone,
                profissoess,
                dadosEndereco()
        );


    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "Casa",
                "Nossa Senhora da Saúde",
                "105663-00",
                "Piranhas",
                "AL",
                "CASARÃO",
                "30");
    }

    private void cadastrarPessoaNoSistema(Pessoa pessoa, LocalDateTime data) {
        em.persist(new ConsultaNoSistema());


    }


}