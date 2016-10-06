import {Component, OnInit, ViewChild} from '@angular/core';
import {ExaminationService} from "../../services/examination.service";
import {Router} from '@angular/router';
import {Examination} from "../../models/examination";
import {ModalComponent} from "ng2-bs4-modal/components/modal"

@Component({
    selector: 'examination-dashboard',
    templateUrl: 'examination-dashboard.component.html',
    styleUrls: ['examination-dashboard.scss'],
    providers: [ExaminationService]
})
export class ExaminationDashboardComponent implements OnInit {
    // vars
    public examinations: Array<Examination>;
    public examination: any;
    private _subscription;

    @ViewChild('examinationModal')
    private examinationModal: ModalComponent;

    // constructor
    constructor(private router: Router, private _examinationService: ExaminationService) {
        this.examination = new Examination();
    }

    // on-init
    ngOnInit() {
        // save _subscription
        this._subscription = this._examinationService.getExaminations()
            .subscribe(
                (data) => {
                    this.examinations = data;
                },
                (err) => console.log(err),
                () => console.log('Examinations retrieved')
            );
    }

    // on-destroy
    ngOnDestroy() {
        // unsubscribe
        this._subscription.unsubscribe();
    }

    gotoDetail(examination: Examination): void {
        this.examination = examination;
        this.examinationModal.open();
    }

    runTest(): void {
        this.examinationModal.close();
    }
}
