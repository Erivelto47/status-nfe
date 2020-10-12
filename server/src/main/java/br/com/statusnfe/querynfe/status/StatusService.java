package br.com.statusnfe.querynfe.status;

import br.com.statusnfe.querynfe.crud.CrudService;

import java.util.Date;
import java.util.List;

public interface StatusService extends CrudService<StatusNfe, Long> {
    List<StatusNfeModel> findAllB();

    List<String> findStatusNfeByEstadoAndIsContigenciaIsFalse(Long id);

    List<String> findStatusNfeByDataStatusEqualsOrderByEstadoId(Date date);
}
