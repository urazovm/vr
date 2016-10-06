import {Answer} from "./answer";

export class Question {
    id: string;
    question: string;
    description: string;
    examinationId: string;
    answers: Array<Answer>;
}