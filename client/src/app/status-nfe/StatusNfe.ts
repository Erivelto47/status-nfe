import {StatusEnum} from './StatusEnum';

export interface StatusNfe {
  siglaEstado: string;
  autorizacao4: StatusEnum;
  retornoAutorizacao4: StatusEnum;
  inutilizacao4: StatusEnum;
  consultaProtocolo4: StatusEnum;
  statusServico4: StatusEnum;
  tempoMedio: StatusEnum;
  consultaCadastro4: StatusEnum;
  recepcaoEvento4: StatusEnum;
}

