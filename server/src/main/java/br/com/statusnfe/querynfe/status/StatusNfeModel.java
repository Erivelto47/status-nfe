package br.com.statusnfe.querynfe.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusNfeModel {
    private String siglaEstado;
    private StatusEnum autorizacao4;
    private StatusEnum retornoAutorizacao4;
    private StatusEnum inutilizacao4;
    private StatusEnum consultaProtocolo4;
    private StatusEnum statusServico4;
    private String tempoMedio;
    private StatusEnum consultaCadastro4;
    private StatusEnum recepcaoEvento4;
}
