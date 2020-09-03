package br.com.statusnfe.querynfe.schedule;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx", name = "StatusPortal")
public interface StatusPortal {

    @GetMapping
    String getStatusPortal();
}
