import {Option} from "./option";
import {QuestionType} from "./question-type";

export class Question {
    id: string;
    text: string;
    description: string;
    examinationId: string;
    type: QuestionType;
    options: Array<Option> = [];
}