import {Question} from "./question";
import {Answer} from "./answer";

export class ExaminationResult extends Question {
    answered: boolean;
    answeres: Array<Answer>;
}