import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
  },
  { path: 'meses', loadChildren: './pages/meses/meses.module#MesesPageModule' },
  { path: 'edit-mes', loadChildren: './pages/edit-mes/edit-mes.module#EditMesPageModule' },
  { path: 'edit-mes/:id', loadChildren: './pages/edit-mes/edit-mes.module#EditMesPageModule' }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
