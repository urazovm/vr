import {Question} from "./question";

export class Examination {
    id: string;
    name: string;
    description: string;
    price: number;
    questions: Array<Question> = [];
}