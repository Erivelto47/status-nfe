package br.com.statusnfe.querynfe.status;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import br.com.statusnfe.querynfe.crud.CrudController;
import br.com.statusnfe.querynfe.crud.CrudService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController extends CrudController<StatusNfe, Long> {

    @Autowired
    private StatusService statusService;

    @Override
    public CrudService<StatusNfe, Long> getService() {
        return this.statusService;
    }

    @GetMapping("/last")
    public List<String> findAllB() {
        return statusService.findAllB();
    }

    @GetMapping("/estado/{id}")
    public List<String> findByEstadoId(@PathVariable Long id) {
        return statusService.findStatusNfeByEstadoAndIsContigenciaIsFalse(id);
    }

    @PostMapping("/date")
    public List<String> findByDate(@RequestBody @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return statusService.findStatusNfeByDataStatusEqualsOrderByEstadoId(date);
    }

}
