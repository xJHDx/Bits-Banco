import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PublicidadComponent } from './publicidad/publicidad.component';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    PublicidadComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[HeaderComponent,FooterComponent]
})
export class ComponentsModule { }
