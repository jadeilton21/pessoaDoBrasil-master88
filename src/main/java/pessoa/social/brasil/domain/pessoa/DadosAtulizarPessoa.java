package pessoa.social.brasil.domain.pessoa;

import jakarta.validation.constraints.NotNull;
import pessoa.social.brasil.domain.endereco.DadosEndereco;

public record DadosAtulizarPessoa(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {


}
