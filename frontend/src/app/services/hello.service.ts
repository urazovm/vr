import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs";
import {AppSettings} from "../properties/app.settings";

export class UserJson {
    id: string;
    login: string;
}

@Injectable()
export class HelloService {

    constructor(private _http: Http) {
    }

    login(login: string): Observable<UserJson> {
        let body = `login=${login}`;
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this._http.post(`${AppSettings.API_ENDPOINT}/login`, body, options)
            .map((res: Response) => res.json());
    }
}
