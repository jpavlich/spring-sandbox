import { LoginComponent } from './login/login.component';
import { SpreadsheetComponent } from './spreadsheet/spreadsheet.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'spreadsheet', component: SpreadsheetComponent },
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
];

export const AppRoutes = RouterModule.forRoot(routes);
