import {Question} from "./question";
import {Option} from "./option";

export class ExaminationResult extends Question {
    answered: boolean;
    options: Array<Option> = [];
}