import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { ReposteModel } from '../models/reporteModels';
import { MovimientoModel } from '../models/movimientoModels';


@Injectable({
    providedIn: 'root',
})
export class MovimientoServices {

    constructor(private http: HttpClient) { }

    public postReporte(json: ReposteModel):Observable<any>{
        const headers = { 'content-type': 'application/json'}  
        const body = JSON.stringify(json);
        return this.http.post<any>(environment.apiBaseUrl+"/movimiento/reposte",body, {'headers': headers })
    }

    public postCrearMovimineto(json:MovimientoModel):Observable<any>{
        const headers = { 'content-type': 'application/json'}  
        const body = JSON.stringify(json);
        return this.http.post<any>(environment.apiBaseUrl + "/movimiento/crear",body, {'headers': headers });
    }


}