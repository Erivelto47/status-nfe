package br.com.statusnfe.querynfe.estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "estado")
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "codigo_ibge",length = 3)
    private Integer codigoIbge;

    @Column()
    private String nome;

    @Column()
    private String sigla;
}
