package br.com.statusnfe.querynfe.status;

import br.com.statusnfe.querynfe.crud.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<String> findAllB() {
        return this.statusRepository.findAllByEstadoAndIsContigenciaIsFalse();
    }

    public List<String> findStatusNfeByEstadoAndIsContigenciaIsFalse(Long id) {
        return this.statusRepository.findStatusNfeByEstadoAndIsContigenciaIsFalse(id);
    }

    public List<String> findStatusNfeByDataStatusEqualsOrderByEstadoId(Date date) {
        return this.statusRepository.findStatusNfeByDataStatusEqualsOrderByEstadoId(date);
    }

}
