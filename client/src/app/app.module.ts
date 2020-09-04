import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {StatusNfeModule} from './status-nfe/status-nfe.module';
import {NavModule} from './nav/nav.module';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    StatusNfeModule,
    NavModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
