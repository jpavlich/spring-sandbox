import { AppRoutes } from './app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SpreadsheetComponent } from './spreadsheet/spreadsheet.component';
import { HotTableModule } from 'ng2-handsontable';

@NgModule({
  declarations: [
    AppComponent,
    SpreadsheetComponent
],
  imports: [
    BrowserModule,
    HotTableModule,
    AppRoutes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
