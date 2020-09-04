import {Component, OnInit} from '@angular/core';
import {StatusNfeService} from './status-nfe.service';
import {StatusNfe} from './StatusNfe';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-status-nfe',
  templateUrl: './status-nfe.component.html',
  styleUrls: ['./status-nfe.component.sass']
})
export class StatusNfeComponent implements OnInit {

  servicesStatus$: StatusNfe[];

  cols: any[];

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

    this.statusService.findStatusByState().subscribe(resulresult => this.servicesStatus$ = resulresult);
    console.log(this.servicesStatus$);
  }
}