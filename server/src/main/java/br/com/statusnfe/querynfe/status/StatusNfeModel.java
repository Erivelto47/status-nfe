package br.com.statusnfe.querynfe.status;

import lombok.Data;

@Data
public class StatusNfeModel {
    private StatusEnum Autorizacao4;
    private StatusEnum RetornoAutorizacao4;
    private StatusEnum Inutilizacao4;
    private StatusEnum ConsultaProtocolo4;
    private StatusEnum StatusServico4;
    private String TempoMedio;
    private StatusEnum ConsultaCadastro4;
    private StatusEnum RecepcaoEvento4;
}
