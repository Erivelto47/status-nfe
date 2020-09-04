import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.sass']
})
export class NavComponent implements OnInit {

  items: MenuItem[];

  constructor() {
  }

  ngOnInit(): void {
    this.items = [
      {
        label: 'Relatorios',
        icon: 'pi pi-fw pi-file',
        items: [
          {
            label: 'Status por Estado',
            icon: 'pi pi-fw pi-chart-line',
            routerLink: 'status'
          },
          {
            separator: true
          },
          {
            label: 'Export',
            icon: 'pi pi-fw pi-chart-bar'
          }
        ]
      }
    ];
  }
}
