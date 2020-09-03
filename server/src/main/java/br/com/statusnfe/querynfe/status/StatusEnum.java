package br.com.statusnfe.querynfe.status;

import java.util.Arrays;
import java.util.List;

public enum StatusEnum {
    VERMELHO("inativo", "<td><img src=\"imagens/bola_vermelho_P.png\"></td>"),
    AMARELO("aguardando", "<td><img src=\"imagens/bola_amarela_P.png\"></td>"),
    VERDE("ativo", "<td><img src=\"imagens/bola_verde_P.png\"></td>");

    private final List<String> status;

    StatusEnum(String ...status) {
        this.status = Arrays.asList(status);
    }

    public List<String> getStatus() {
        return status;
    }

    public static StatusEnum find(String status) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getStatus().contains(status)) {
                return statusEnum;
            }
        }
        return null;
    }
}