import {Component, Input, ChangeDetectionStrategy} from "@angular/core";
import {ExaminationService} from "../../../services/examination.service";
import {Router} from "@angular/router";
import {Examination} from "../../../models/examination";
import {Question} from "../../../models/question";
import QuestionUpdatedEvent from "../../../components/question-update-event";

@Component({
    selector: 'questions-edit',
    templateUrl: 'questions-tab.html',
    styleUrls: ['questions-tab.scss'],
    providers: [ExaminationService],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class QuestionsTab {
    // vars
    @Input() examination: Examination;
    private currentQuestion: Question;

    // constructor
    constructor(private router: Router, private _examinationService: ExaminationService) {
    }

    addQuestion() {
        if (this.currentQuestion && this.currentQuestion.text) {
            this.examination.questions.push(this.currentQuestion);
            this.clear();
        }
    }

    clear() {
        this.currentQuestion = null;
    }

    createNewQuestion() {
        this.currentQuestion = new Question();
    }

    questionUpdated(event: QuestionUpdatedEvent) {
        if (event.item !== undefined) {
            if (event.isNew) {
                this.examination.questions.push(event.item);
            }

            this.clear();
        }
    }

    onRemoveQuestion(event: number) {
        if (event >= 0) {
            this.examination.questions.splice(event, 1);
        }

        this.currentQuestion = null;
    }
}
