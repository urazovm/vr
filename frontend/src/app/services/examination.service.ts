import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {AppSettings} from "../properties/app.settings";
import {Examination} from "../models/examination";
import {Observable} from "rxjs";

@Injectable()
export class ExaminationService {

    constructor(private _http: Http) {
    }

    getExaminations() {
        return this._http.get(`${AppSettings.API_ENDPOINT}/examination`)
            .map((res: Response) => res.json());
    }

    getExamination(id: string) {
        return this._http.get(`${AppSettings.API_ENDPOINT}/examination/${id}`)
            .map((res: Response) => res.json());
    }

    getQuestions(id: string) {
        return this._http.get(`${AppSettings.API_ENDPOINT}/questions/${id}`)
            .map((res: Response) => res.json());
    }

    getAnswersForQuestion(questionId: string) {
        return this._http.get(`${AppSettings.API_ENDPOINT}/answers/${questionId}`)
            .map((res: Response) => res.json());
    }

    saveExamination(examination: Examination) {
        let body = JSON.stringify(examination);
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers, body: body, method: "post"});

        this._http.post(`${AppSettings.API_ENDPOINT}/examination`, body, options)
            .map(res => res.json())
            .subscribe(
                (err) => console.log(err),
                () => console.log('Examination successfully saved'));
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || ' error');
    }
}
