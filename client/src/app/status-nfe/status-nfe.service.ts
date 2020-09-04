import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {StatusNfe} from './StatusNfe';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatusNfeService {

  API_STATUS = environment.API + '/status/last';

  constructor(private httpClient: HttpClient) {
  }

  findStatusByState(): Observable<StatusNfe[]> {
    return this.httpClient.get<StatusNfe[]>(this.API_STATUS);
  }
}
