package pessoa.social.brasil.domain.pessoa;

import pessoa.social.brasil.domain.endereco.Endereco;

public record DadosListagemPessoa(Long id, String nome, String email, String cpf, String idade, String telefone, Profissoess profissoess,Endereco endereco) {

    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getCpf(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getProfissoess(),pessoa.getEndereco());
    }
}
