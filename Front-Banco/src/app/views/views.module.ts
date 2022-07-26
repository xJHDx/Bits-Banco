import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ViewsRoutingModule } from './views-routing.module';
import { ClienteServices } from '../services/clienteServices';
import { HttpClient } from '@angular/common/http';
import { ChucknorrisServices } from '../services/chucknorrisServices';
import { CuentaServices } from '../services/cuentaServices';
import { MovimientoServices } from '../services/movimientoServices';

@NgModule({
  declarations: [],
  imports: [CommonModule, ViewsRoutingModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
    ClienteServices,
    CuentaServices,
    MovimientoServices,
    ChucknorrisServices,
    HttpClient,
  ],
})
export class ViewsModule {}
