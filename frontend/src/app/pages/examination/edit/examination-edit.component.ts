import {Component, OnInit, ViewChild} from '@angular/core';
import {ExaminationService} from "../../../services/examination.service";
import {Router} from '@angular/router';
import {Examination} from "../../../models/examination";
import {ModalComponent} from "ng2-bs4-modal/components/modal"

@Component({
    selector: 'examination-edit',
    templateUrl: 'examination-edit.component.html',
    styleUrls: ['examination-edit.scss'],
    providers: [ExaminationService]
})
export class ExaminationEditComponent implements OnInit {
    // vars
    public examination: Examination;

    // constructor
    constructor(private router: Router, private _examinationService: ExaminationService) {
        this.examination = new Examination();
    }

    // on-init
    ngOnInit() {

    }

    // on-destroy
    ngOnDestroy() {
    }

    save() {
        this.examination.questions = [];
        this._examinationService.saveExamination(this.examination);
    }
}
