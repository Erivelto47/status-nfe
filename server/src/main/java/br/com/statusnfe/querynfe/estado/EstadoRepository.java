package br.com.statusnfe.querynfe.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Estado findByCodigoIbge(Integer codigoIbge);
}
