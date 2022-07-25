import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelRoutingModule } from './panel-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import {AutoCompleteModule} from 'primeng/autocomplete';


@NgModule({
  declarations: [
    DashboardComponent
  ],
  imports: [
    CommonModule,
    PanelRoutingModule,
    AutoCompleteModule
  ]
})
export class PanelModule { }
