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
    @Query(value = "select estado.sigla, " +
            "status_nfe.autorizacao_4, " +
            "status_nfe.retorno_autorizacao_4, " +
            "status_nfe.inutilizacao_4,  " +
            "status_nfe.consulta_protocolo_4, " +
            "status_nfe.status_servico_4, " +
            "status_nfe.tempo_medio, " +
            "status_nfe.consulta_cadastro_4, " +
            "status_nfe.recepcao_evento_4 " +
            "from estado join status_nfe where status_nfe.contingencia=false " +
            "group by estado.sigla, status_nfe.autorizacao_4, status_nfe.retorno_autorizacao_4, status_nfe.inutilizacao_4, status_nfe.consulta_protocolo_4, status_nfe.status_servico_4, status_nfe.tempo_medio, status_nfe.consulta_cadastro_4, status_nfe.recepcao_evento_4", nativeQuery = true)
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

