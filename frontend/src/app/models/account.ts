import {AccountExamination} from "./account-examination";
export class Account {
    id: string;
    legal: boolean;
    name?: string;
    surname?: number;
    phone?: string;
    state: number;
    secretKey: string;
    lastLoginTime: Date;
    accountExaminations: Array<AccountExamination> = [];
}