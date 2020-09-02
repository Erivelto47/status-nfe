package br.com.statusnfe.querynfe.status;

import br.com.statusnfe.querynfe.crud.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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

}
