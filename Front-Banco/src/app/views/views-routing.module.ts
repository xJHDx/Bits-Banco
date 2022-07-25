import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'panel',
    loadChildren: () =>
      import('./home/panel/panel.module').then(
        (m) => m.PanelModule
      )
  }, 
  {
    path: '**',
    redirectTo: 'panel',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ViewsRoutingModule { }
