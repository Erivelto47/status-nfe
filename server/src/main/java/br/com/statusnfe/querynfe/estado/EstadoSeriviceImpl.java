package br.com.statusnfe.querynfe.estado;

import br.com.statusnfe.querynfe.crud.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoSeriviceImpl extends CrudServiceImpl<Estado, Long> implements EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    protected JpaRepository<Estado, Long> getRepository() {
        return estadoRepository;
    }

    @Override
    public Estado findEstadoByIbgeCode(Integer codigo) {
        return estadoRepository.findByCodigoIbge(codigo);
    }
}
