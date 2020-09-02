package br.com.statusnfe.querynfe.status;

import br.com.statusnfe.querynfe.crud.CrudController;
import br.com.statusnfe.querynfe.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/status")
public class StatusController extends CrudController<StatusNfe, Long> {

    @Autowired
    private StatusService statusService;

    @Override
    public CrudService<StatusNfe, Long> getService() {
        return this.statusService;
    }
}
