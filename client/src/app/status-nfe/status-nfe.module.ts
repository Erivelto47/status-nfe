import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StatusNfeComponent} from './status-nfe.component';
import {ChartModule} from 'primeng/chart';
import {TableModule} from 'primeng/table';

@NgModule({
  declarations: [StatusNfeComponent],
  imports: [
    CommonModule,
    ChartModule,
    TableModule
  ]
})
export class StatusNfeModule {
}
