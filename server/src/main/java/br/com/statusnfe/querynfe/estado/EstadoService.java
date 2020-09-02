package br.com.statusnfe.querynfe.estado;

import br.com.statusnfe.querynfe.crud.CrudService;

public interface EstadoService extends CrudService<Estado, Long> {

    Estado findEstadoByIbgeCode(Integer codigo);
}
