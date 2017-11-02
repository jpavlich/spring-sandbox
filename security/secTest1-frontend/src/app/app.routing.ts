import { LoginComponent } from './login/login.component';
import { SpreadsheetComponent } from './spreadsheet/spreadsheet.component';
import { Routes, RouterModule } from '@angular/router';
import { ReporteComponent } from './reporte/reporte.component';

const routes: Routes = [
  { path: 'spreadsheet', component: SpreadsheetComponent },
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'reporte', component: ReporteComponent}
];

export const AppRoutes = RouterModule.forRoot(routes);
