import {Option} from "./option";

export class Question {
    id: string;
    text: string;
    description: string;
    examinationId: string;
    options: Array<Option> = [];
}