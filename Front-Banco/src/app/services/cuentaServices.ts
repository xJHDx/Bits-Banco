import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class CuentaServices {

    constructor(private http: HttpClient) { }

    public getCuentas(id:Number):Observable<any>{
        return this.http.get<any>(`${environment.apiBaseUrl}/cuenta?id=${id}`);
    }

    public postCrearCuenta(json:any):Observable<any>{
        const headers = { 'content-type': 'application/json'}  
        const body = JSON.stringify(json);
        return this.http.post<any>(environment.apiBaseUrl+"/cuenta",body, {'headers': headers })
    }

    public putActualizarCuenta(json:any):Observable<any>{
        const headers = { 'content-type': 'application/json'}  
        const body = JSON.stringify(json);
        return this.http.put<any>(environment.apiBaseUrl+"/cuenta",body, {'headers': headers })
    }

    public deleteCuenta(id:Number):Observable<any>{
        return this.http.delete<any>(`${environment.apiBaseUrl}/cuenta?id=${id}`)
    }

}