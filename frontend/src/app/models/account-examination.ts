import {Examination} from "./examination";
import {ExaminationResult} from "./examination-result";

export class AccountExamination extends Examination {
    id: string;
    attempt: boolean;
    completed: boolean;
    payed: boolean;
    startTime: Date;
    examinationResults: Array<ExaminationResult>
}