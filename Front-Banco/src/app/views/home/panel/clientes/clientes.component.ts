import { Component, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { ClienteServices } from 'src/app/services/clienteServices';
import { Router } from '@angular/router';
import { ClienteModel } from 'src/app/models/clienteModels';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit,OnChanges {

  cliente = new ClienteModel;
  displayModal = true;
  displayModalCrear = false;

  clientes: any;

  selectedCliente: ClienteModel = {};

  constructor(private clienteServices:ClienteServices, private router: Router) {}
  
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.clienteServices.getClientes().subscribe(r=>{
      this.clientes = r;
      console.log(r);
    })
  }

  buscarCliente(){
    console.log("buscar cliente");
    console.log(this.selectedCliente);
    
  }

  vistaDashboard(){
    this.router.navigate(['portalbancario/panel/dashboard']);
  }
  
  crearCliente(){
    console.log("Crear Cliente");
    console.log(this.selectedCliente);
  }

}
