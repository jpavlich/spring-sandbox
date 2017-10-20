import { SpreadsheetComponent } from './spreadsheet/spreadsheet.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'spreadsheet', component: SpreadsheetComponent },
  { path: '', pathMatch: 'full', redirectTo: 'spreadsheet' }
];

export const AppRoutes = RouterModule.forRoot(routes);
