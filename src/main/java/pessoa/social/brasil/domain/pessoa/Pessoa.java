package pessoa.social.brasil.domain.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoa.social.brasil.domain.endereco.Endereco;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String idade;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Profissoess profissoess;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;


    public Pessoa(DadosCadastrarPessoa dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.idade = dados.idade();
        this.telefone = dados.telefone();
        this.profissoess = dados.profissões();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;

    }
}
