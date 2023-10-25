package pessoa.social.brasil.domain.consultaNoSistema;


import jakarta.persistence.*;
import lombok.*;
import pessoa.social.brasil.domain.pessoa.Pessoa;

import java.time.LocalDateTime;

@Entity(name = "consultaNoSistema")
@Table(name = "consultasNoSistemas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ConsultaNoSistema {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    private LocalDateTime time;
    @Column(name = "motivodocancelamento_nosistema")
    @Enumerated(EnumType.STRING)
    private MotivoDOCancelamentoDaConsultaNoSistema consultaNoSistema;

    public ConsultaNoSistema(Long id, Pessoa pessoa, LocalDateTime time) {
        this.id = id;
        this.pessoa = pessoa;
        this.time = time;
    }

    public void cancelar(MotivoDOCancelamentoDaConsultaNoSistema motivo){
        this.consultaNoSistema = motivo;
    }

    public LocalDateTime getTime(){
        return time;
    }

}
