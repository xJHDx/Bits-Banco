import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ViewsRoutingModule } from './views-routing.module';
import { ClienteServices } from '../services/clienteServices';
import { HttpClient } from '@angular/common/http';


@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    ViewsRoutingModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers:[ClienteServices,HttpClient]
})
export class ViewsModule { }
