package br.com.statusnfe.querynfe.status;

import br.com.statusnfe.querynfe.crud.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class StatusServiceImpl
        extends CrudServiceImpl<StatusNfe, Long>
        implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    protected JpaRepository<StatusNfe, Long> getRepository() {
        return this.statusRepository;
    }

    @Override
    public List<StatusNfeModel> findAllB() {

        return nfeModelMapper(this.statusRepository.findAllByEstadoAndIsContigenciaIsFalse());
    }

    public List<String> findStatusNfeByEstadoAndIsContigenciaIsFalse(Long id) {
        return this.statusRepository.findStatusNfeByEstadoAndIsContigenciaIsFalse(id);
    }

    public List<String> findStatusNfeByDataStatusEqualsOrderByEstadoId(Date date) {
        return this.statusRepository.findStatusNfeByDataStatusEqualsOrderByEstadoId(date);
    }

    private List<StatusNfeModel> nfeModelMapper(List<String> result) {

        List<StatusNfeModel> statusNfeModelList = new ArrayList();

        result.forEach(statusNfe -> {
            StatusNfeModel statusNfeModel = new StatusNfeModel();

            String[] values = statusNfe.split(",");

            statusNfeModel.setSiglaEstado(values[0]);
            statusNfeModel.setAutorizacao4(getStatusEnumOfOrdinal(values[1]));
            statusNfeModel.setRetornoAutorizacao4(getStatusEnumOfOrdinal(values[2]));
            statusNfeModel.setInutilizacao4(getStatusEnumOfOrdinal(values[3]));
            statusNfeModel.setConsultaProtocolo4(getStatusEnumOfOrdinal(values[4]));
            statusNfeModel.setStatusServico4(getStatusEnumOfOrdinal(values[5]));
            statusNfeModel.setTempoMedio(values[6]);
            statusNfeModel.setConsultaCadastro4(getStatusEnumOfOrdinal(values[7]));
            statusNfeModel.setRecepcaoEvento4(getStatusEnumOfOrdinal(values[8]));

            statusNfeModelList.add(statusNfeModel);
        });

        return statusNfeModelList;
    }

    private StatusEnum getStatusEnumOfOrdinal(String ordinal) {

        if("null".equals(ordinal) || isNull(ordinal)) {
            return StatusEnum.INDISPONIVEL;
        }

        return StatusEnum.valueOf(StatusEnum.values()[Integer.parseInt(ordinal)].name());
    }

}
