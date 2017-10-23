import { HttpModule } from '@angular/http';
import { RestClientService } from './services/rest-client.service';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { AppRoutes } from './app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SpreadsheetComponent } from './spreadsheet/spreadsheet.component';
import { HotTableModule } from 'ng2-handsontable';

@NgModule({
  declarations: [
    AppComponent,
    SpreadsheetComponent,
    LoginComponent
],
  imports: [
    BrowserModule,
    HotTableModule,
    AppRoutes,
    FormsModule,
    HttpModule
  ],
  providers: [RestClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
