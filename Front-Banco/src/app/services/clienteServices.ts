import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class ClienteServices {

    constructor(private http: HttpClient) { }

    public getClientes():Observable<any>{
        return this.http.get<any>(environment.apiBaseUrl + "/cliente?id=todos");
    }


}