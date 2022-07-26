import { Component, OnInit } from '@angular/core';
import { ChucknorrisServices } from 'src/app/services/chucknorrisServices';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  notas:string = "";

  constructor(private chucknorrisServices:ChucknorrisServices) { }

  ngOnInit(): void {
    this.chucknorrisServices.getChucknorris().subscribe(r=>{
      this.notas = r.value;
    })
  }

}
