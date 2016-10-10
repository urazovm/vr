import {
    Component, Input, ChangeDetectionStrategy, Output,
    EventEmitter
} from '@angular/core';
import {Option} from "../../models/option";
import ItemUpdatedEvent from "../option-update-event";
import {Question} from "../../models/question";
import QuestionUpdatedEvent from "../question-update-event";

@Component({
    selector: 'question-item',
    templateUrl: 'question.component.html',
    styleUrls: ['question.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class QuestionComponent {
    @Input()
    isNew = false;

    @Input()
    index?: number;

    @Input()
    questionEditMode: boolean = false;

    @Input()
    item: Question;

    @Output()
    itemRemove = new EventEmitter<number>();

    @Output()
    itemUpdated = new EventEmitter<QuestionUpdatedEvent>();

    currentOption: Option = null;

    isCollapsed: boolean = false;

    removeClicked() {
        this.itemRemove.emit(this.index);
    }

    enterEditMode(element: HTMLInputElement) {
        this.questionEditMode = true;
        if (this.questionEditMode) {
            setTimeout(() => { element.focus(); }, 0);
        }
    }

    cancelEdit(element: HTMLInputElement) {
        this.questionEditMode = false;
        element.value = this.item.text ? this.item.text : '';

        if (this.isNew) {
            this.itemRemove.emit();
        }
    }

    commitEdit(updatedItem: Question, text: string) {
        this.questionEditMode = false;
        updatedItem.text = text;
        this.itemUpdated.emit({
            item: updatedItem,
            isNew: this.isNew
        });
    }

    createNewOption() {
        this.currentOption = new Option();
    }

    optionUpdated(event: ItemUpdatedEvent) {
        if (event.item !== undefined) {
            if (event.isNew) {
                this.item.options.push(event.item);
            }

            this.currentOption = null;
        }
    }

    onRemoveOption(event: number) {
        if (event >= 0) {
            this.item.options.splice(event, 1);
        }

        this.currentOption = null;
    }
}
