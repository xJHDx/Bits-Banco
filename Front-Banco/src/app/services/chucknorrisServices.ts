import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class ChucknorrisServices {

    constructor(private http: HttpClient) { }

    public getChucknorris():Observable<any>{
        return this.http.get<any>("https://api.chucknorris.io/jokes/random");
    }


}