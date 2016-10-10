import {Component, OnInit, ViewChild, ElementRef} from "@angular/core";
import {ExaminationService} from "../../../services/examination.service";
import {Router} from "@angular/router";
import {Examination} from "../../../models/examination";
import {QuestionsTab} from "./questions-tab";

@Component({
    selector: 'examination-edit',
    templateUrl: 'examination-edit.component.html',
    styleUrls: ['examination-edit.scss'],
    providers: [ExaminationService]
})
export class ExaminationEditComponent implements OnInit {
    // vars
    public examination: Examination;
    @ViewChild(QuestionsTab) public questionsPanel: QuestionsTab;

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
        if (!this.examination.questions || this.examination.questions.length == 0)
            return;

        this._examinationService.saveExamination(this.examination);
    }
}
