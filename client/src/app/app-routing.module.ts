import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StatusNfeComponent} from "./status-nfe/status-nfe.component";

const routes: Routes = [
  {path: 'status', component: StatusNfeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
