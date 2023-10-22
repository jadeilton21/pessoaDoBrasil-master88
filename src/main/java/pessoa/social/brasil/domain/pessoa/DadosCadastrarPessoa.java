package pessoa.social.brasil.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pessoa.social.brasil.domain.endereco.DadosEndereco;

public record DadosCadastrarPessoa(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String idade,
        @NotBlank
        String telefone,
        @NotNull
        Profissoess profissões,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
