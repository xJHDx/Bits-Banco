import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class ClienteServices {

    constructor(private http: HttpClient) { }

    public getClientes(id:any):Observable<any>{
        return this.http.get<any>(`${environment.apiBaseUrl}/cliente?id=${id}`);
    }

    public postCrearCliente(json:any):Observable<any>{
        const headers = { 'content-type': 'application/json'}  
        const body = JSON.stringify(json);
        return this.http.post<any>(environment.apiBaseUrl+"/cliente",body, {'headers': headers })
    }

    public putActualizarCliente(json:any):Observable<any>{
        const headers = { 'content-type': 'application/json'}  
        const body = JSON.stringify(json);
        return this.http.put<any>(environment.apiBaseUrl+"/cliente",body, {'headers': headers })
    }

    public deleteCliente(id:Number):Observable<any>{
        return this.http.delete<any>(`${environment.apiBaseUrl}/cliente?id=${id}`)
    }

}