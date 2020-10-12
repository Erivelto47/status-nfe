package br.com.statusnfe.querynfe.estado;

import br.com.statusnfe.querynfe.crud.CrudController;
import br.com.statusnfe.querynfe.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController extends CrudController<Estado, Long> {

    @Autowired
    private EstadoService estadoService;

    @Override
    public CrudService<Estado, Long> getService() {
        return estadoService;
    }

    @GetMapping
    public List<Estado> findAll() {
        return estadoService.findAll();
    }

}
