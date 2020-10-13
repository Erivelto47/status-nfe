import {AfterViewInit, Component, OnInit} from '@angular/core';
import {StatusNfeService} from './status-nfe.service';
import {StatusNfe} from './StatusNfe';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-status-nfe',
  templateUrl: './status-nfe.component.html',
  styleUrls: ['./status-nfe.component.sass']
})
export class StatusNfeComponent implements OnInit {

  servicesStatus$: Observable<StatusNfe[]>;

  cols: any[];

  interval: any;

  constructor(private statusService: StatusNfeService) {
  }

  ngOnInit(): void {
    this.cols = [
      { field: 'siglaEstado', header: 'Estado' },
      { field: 'autorizacao4', header: 'Autorizacao' },
      { field: 'retornoAutorizacao4', header: 'Retorno Autorizacao' },
      { field: 'inutilizacao4', header: 'Inutilizacao' },
      { field: 'consultaProtocolo4', header: 'Consulta Protocolo' },
      { field: 'statusServico4', header: 'Status Servico' },
      { field: 'tempoMedio', header: 'Tempo Medio' },
      { field: 'consultaCadastro4', header: 'Consulta Cadastro' },
      { field: 'recepcaoEvento4', header: 'Recepcao Evento' },
    ];
    this.getServicesLastStatus();

    /**
     * Call the service method in interval of 5 minutes
     */
    this.interval = setInterval(() => {
      this.getServicesLastStatus();
    }, 60000);
  }

  getServicesLastStatus(): void {
    this.servicesStatus$ = this.statusService.findStatusByState();
  }

}
