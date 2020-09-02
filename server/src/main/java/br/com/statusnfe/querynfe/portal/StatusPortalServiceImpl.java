package br.com.statusnfe.querynfe.portal;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.statusnfe.querynfe.estado.Estado;
import br.com.statusnfe.querynfe.estado.EstadoEnum;
import br.com.statusnfe.querynfe.estado.EstadoService;
import br.com.statusnfe.querynfe.status.StatusNfe;
import br.com.statusnfe.querynfe.status.StatusEnum;
import br.com.statusnfe.querynfe.status.StatusNfeModel;
import br.com.statusnfe.querynfe.status.StatusService;
import br.com.statusnfe.querynfe.utils.Utils;

@Service
public class StatusPortalServiceImpl implements StatusPortalService {
    @Autowired
    private StatusService statusService;

    @Autowired
    private EstadoService estadoService;

    @Override
    public void filterAndSaveElements(Document document) {
        Elements tableElements = document.getElementById("ctl00_ContentPlaceHolder1_gdvDisponibilidade2").select("tbody");
        Elements lineElements = tableElements.get(0).select("tr");

        lineElements.stream().filter(element -> element.attributes().size() > 0)
                .forEach(element -> {
                    StatusNfeModel statusNfeModel = new StatusNfeModel();
                    Elements tdTable = element.select("td");

                    String siglaAutorizador = getElementByIdex(tdTable, TableOrderEnum.AUTORIZADOR);

                    statusNfeModel.setAutorizacao4(getStatusEnum(tdTable, TableOrderEnum.AUTORIZACAO4));
                    statusNfeModel.setRetornoAutorizacao4(getStatusEnum(tdTable, TableOrderEnum.RETORNOAUTORIZACAO4));
                    statusNfeModel.setInutilizacao4(getStatusEnum(tdTable, TableOrderEnum.INUTILIZACAO4));
                    statusNfeModel.setConsultaProtocolo4(getStatusEnum(tdTable, TableOrderEnum.CONSULTAPROTOCOLO4));
                    statusNfeModel.setStatusServico4(getStatusEnum(tdTable, TableOrderEnum.STATUSSERVICO4));
                    statusNfeModel.setConsultaCadastro4(getStatusEnum(tdTable, TableOrderEnum.CONSULTACADASTRO4));
                    statusNfeModel.setRecepcaoEvento4(getStatusEnum(tdTable, TableOrderEnum.RECEPCAOEVENTO4));
                    statusNfeModel.setTempoMedio(Utils.removeHtmlTags(getElementByIdex(tdTable, TableOrderEnum.TEMPOMEDIO)));

                    try {
                        this.saveStatus(siglaAutorizador, statusNfeModel);
                    } catch (Exception e) {
                        System.out.println("Error to persist StatusNfe: " + e.getMessage());
                        e.printStackTrace();
                    }
                });
    }

    private StatusEnum getStatusEnum(Elements table, TableOrderEnum index) {
        return StatusEnum.find(getElementByIdex(table, index));
    }

    private String getElementByIdex(Elements table,TableOrderEnum index) {
        return table.get(index.ordinal()).getAllElements().get(0).toString();
    }

    private void saveStatus(String siglaAutorizador, StatusNfeModel statusNfeModel) throws Exception {

        AutorizadorEnum autorizadorEnum = AutorizadorEnum.valueOf(Utils.removeAll(siglaAutorizador));
        Boolean isContigencia = AutorizadorEnum.SVCRS.equals(autorizadorEnum) || AutorizadorEnum.SVCAN.equals(autorizadorEnum);

        autorizadorEnum.getEstados().forEach(estadoSigla -> {
            EstadoEnum estadoEnum = EstadoEnum.valueOf(estadoSigla);
            Estado estado = estadoService.findEstadoByIbgeCode(estadoEnum.getCodigoIbge());

            StatusNfe statusNfe = StatusNfe.builder()
                    .estado(estado)
                    .isContigencia(isContigencia)
                    .StatusServico4(statusNfeModel.getStatusServico4())
                    .Autorizacao4(statusNfeModel.getAutorizacao4())
                    .ConsultaCadastro4(statusNfeModel.getConsultaCadastro4())
                    .ConsultaProtocolo4(statusNfeModel.getConsultaProtocolo4())
                    .Inutilizacao4(statusNfeModel.getInutilizacao4())
                    .RecepcaoEvento4(statusNfeModel.getRecepcaoEvento4())
                    .RetornoAutorizacao4(statusNfeModel.getRetornoAutorizacao4())
                    .TempoMedio(statusNfeModel.getTempoMedio())
                    .build();

            statusService.save(statusNfe);
        });
    }
}
