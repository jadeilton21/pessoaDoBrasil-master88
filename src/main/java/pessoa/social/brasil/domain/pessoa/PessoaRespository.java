package pessoa.social.brasil.domain.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.DoubleStream;

public interface PessoaRespository extends JpaRepository<Pessoa,Long> {
    Page<Pessoa> findAllByAtivoTrue(Pageable paginacao);


}
