package pessoa.social.brasil.domain.pessoa;

import pessoa.social.brasil.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(Long id, String nome, String email, String cpf, String telefone, String idade, Profissoess profissoess, Endereco endereco) {



    public DadosDetalhamentoPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getCpf(), pessoa.getIdade(), pessoa.getTelefone(), pessoa.getProfissoess(), pessoa.getEndereco());
    }


}
