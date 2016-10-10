import {Option} from "../models/option";

interface OptionUpdatedEvent {
    isNew: boolean,
    item: Option;
}

export default OptionUpdatedEvent;