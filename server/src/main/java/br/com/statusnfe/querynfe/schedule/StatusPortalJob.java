package br.com.statusnfe.querynfe.schedule;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import br.com.statusnfe.querynfe.portal.StatusPortal;
import br.com.statusnfe.querynfe.portal.StatusPortalService;

@Service
public class StatusPortalJob {

    @Autowired
    private StatusPortalService statusPortalService;

    @Autowired
    private StatusPortal statusPortal;

    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void validateSomething() {
        System.out.println("Execute Job start.");

        try {
            Document document = Jsoup.parse(statusPortal.getStatusPortal());
            statusPortalService.filterAndSaveElements(document);
        } catch (FeignException e) {
            System.out.println("Error get page in: http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx");
            e.printStackTrace();
        }
    }
}
