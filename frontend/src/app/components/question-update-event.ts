import {Question} from "../models/question";

interface QuestionUpdatedEvent {
    isNew: boolean,
    item: Question;
}

export default QuestionUpdatedEvent;