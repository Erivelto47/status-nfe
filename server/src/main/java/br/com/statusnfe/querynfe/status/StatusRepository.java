package br.com.statusnfe.querynfe.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<StatusNfe, Long> {

    /**
     *  3- Retornar por rest os status atual dos serviços por estado.
     */
    @Query(value = "select e.sigla, " +
            "nfe.autorizacao_4, " +
            "nfe.retorno_autorizacao_4, " +
            "nfe.inutilizacao_4,  " +
            "nfe.consulta_protocolo_4, " +
            "nfe.status_servico_4, " +
            "nfe.tempo_medio, " +
            "nfe.consulta_cadastro_4, " +
            "nfe.recepcao_evento_4 " +
            "from status_nfe nfe " +
            "join estado e on e.id = nfe.estado_id " +
            "where nfe.id in (select max(snfe.id) " +
            "                 from status_nfe snfe " +
            "                 where snfe.contingencia=false " +
            "                 group by snfe.estado_id) " +
            "group by e.sigla", nativeQuery = true)
    List<String> findAllByEstadoAndIsContigenciaIsFalse();

    /**
     * 4- Retornar por rest o status atual do serviço filtrando por estado.
     *
     * @param id Id do estado selecionado
     * @return
     */

    @Query(value = "select status_nfe.status_servico_4, estado.sigla from estado join status_nfe where estado.id =?1 and status_nfe.contingencia=false group by estado.sigla, status_nfe.status_servico_4", nativeQuery = true)
    List<String> findStatusNfeByEstadoAndIsContigenciaIsFalse(Long id);

    /**
     * 5- Retornar por rest os status dos serviços por estado filtrando por data
     */
    @Query(value = "select status_nfe.status_servico_4, estado.sigla from estado join status_nfe where status_nfe.data_status = ?1 and status_nfe.contingencia=false group by estado.sigla", nativeQuery = true)
    List<String> findStatusNfeByDataStatusEqualsOrderByEstadoId(Date date);


    /**
     *6- Retornar por rest qual estado teve mais indisponibilidade de serviço.
     */

}

