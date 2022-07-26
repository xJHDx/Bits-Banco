import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanelRoutingModule } from './panel-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import { ClientesComponent } from './clientes/clientes.component';
import {DialogModule} from 'primeng/dialog';
import {DropdownModule} from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    DashboardComponent,
    ClientesComponent
  ],
  imports: [
    CommonModule,
    PanelRoutingModule,
    AutoCompleteModule,
    CardModule,
    ButtonModule,
    DialogModule,
    DropdownModule,
    FormsModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PanelModule { }
