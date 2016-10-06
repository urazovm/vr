import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {ExaminationService} from "../../services/examination.service";
import {Examination} from "../../models/examination";
import {Question} from "../../models/question";
import {Answer} from "../../models/answer";

@Component({
    selector: 'examination-detail',
    templateUrl: 'examination-detail.component.html',
    styleUrls: ['examination-detail.scss'],
    providers: [ExaminationService]
})
export class ExaminationDetailComponent implements OnInit {
    // vars
    private examination: Examination;
    public questions: Array<Question>;
    public question: Question;
    public questionAnswers: Array<Answer>;
    private _subscription;
    private _subscriptionQuestion;
    public currentQuestion: number = 1;
    public maxSize: number = 0;
    public questionsPerPage: number = 1;


    public onQuestionChanged(event: any): void {
        if (event.page > 0) {
            this.question = this.questions[event.page - 1];

            if (this.question) {
                let questionId: string = this.question.id;
                this._subscriptionQuestion = this._examinationService.getAnswersForQuestion(questionId)
                    .subscribe((data) => {
                            this.questionAnswers = data;
                        },
                        (err) => console.log(err),
                        () => console.log(`Answers retrieved`)
                    );
            }
        }
    };


    // constructor
    constructor(private route: ActivatedRoute,
                private _examinationService: ExaminationService) {
        this.examination = new Examination();
        this.questions = [];
    }

    // on-init
    ngOnInit() {
        // save _subscription
        this.route.params.forEach((params: Params) => {
            let id = params['id'];
            this._examinationService.getQuestions(id)
                .subscribe((data) => {
                        this.questions = data;
                        this.onQuestionChanged({page: this.currentQuestion, itemsPerPage: this.questions.length})
                    },
                    (err) => console.log(err),
                    () => console.log(`Examination retrieved`)
                );
        });
    }

    // on-destroy
    ngOnDestroy() {
        // unsubscribe
        this._subscription.unsubscribe();
    }
}
