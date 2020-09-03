package br.com.statusnfe.querynfe.status;

import lombok.Data;

@Data
public class StatusNfeModel {
    private StatusEnum autorizacao4;
    private StatusEnum retornoAutorizacao4;
    private StatusEnum inutilizacao4;
    private StatusEnum consultaProtocolo4;
    private StatusEnum statusServico4;
    private String tempoMedio;
    private StatusEnum consultaCadastro4;
    private StatusEnum recepcaoEvento4;
}
