package br.com.statusnfe.querynfe.status;

import br.com.statusnfe.querynfe.estado.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "status_nfe")
@AllArgsConstructor
@NoArgsConstructor
public class StatusNfe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Estado estado;

    @Column(name = "contingencia")
    private Boolean isContigencia;

    @Column(name = "autorizacao_4")
    private StatusEnum Autorizacao4;

    @Column(name = "retorno_autorizacao_4")
    private StatusEnum RetornoAutorizacao4;

    @Column(name = "inutilizacao_4")
    private StatusEnum Inutilizacao4;

    @Column(name = "consulta_protocolo_4")
    private StatusEnum ConsultaProtocolo4;

    @Column(name = "status_servico_4")
    private StatusEnum StatusServico4;

    @Column(name = "tempo_medio")
    private String TempoMedio;

    @Column(name = "consulta_cadastro_4" )
    private StatusEnum ConsultaCadastro4;

    @Column(name = "recepcao_evento_4")
    private StatusEnum RecepcaoEvento4;

}