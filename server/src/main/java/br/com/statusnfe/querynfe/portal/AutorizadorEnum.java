package br.com.statusnfe.querynfe.portal;

import java.util.Arrays;
import java.util.List;

public enum AutorizadorEnum {

    AM("AM"),
    BA("BA"),
    CE("CE"),
    GO("GO"),
    MG("MG"),
    MS("MS"),
    MT("MT"),
    PE("PE"),
    PR("PR"),
    RS("RS"),
    SP("SP"),
    SVAN("MA"),
    SVRS("AC", "AL", "AP", "DF", "ES", "PB", "PI", "RJ", "RN", "RO", "RR", "SC", "SE", "TO"),
    SVCAN("AC", "AL", "AP", "DF","ES", "MG", "PA", "PB", "PI", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"),
    SVCRS("AM", "BA", "CE", "GO", "MA", "MS", "MT", "PE", "PR");


    private final List<String> estados;

    AutorizadorEnum(String ...estados) {
        this.estados = Arrays.asList(estados);
    }

    public List<String> getEstados() {
        return estados;
    }


    public static AutorizadorEnum find(String sigla) {
        for (AutorizadorEnum autorizadorEnum : AutorizadorEnum.values()) {
            if (autorizadorEnum.getEstados().contains(sigla)) {
                return autorizadorEnum;
            }
        }
        return null;
    }
}