import {Component, Input, ChangeDetectionStrategy, Output, EventEmitter, ViewChild, ElementRef} from "@angular/core";
import {Option} from "../../models/option";
import ItemUpdatedEvent from "../option-update-event";
import {Question} from "../../models/question";
import QuestionUpdatedEvent from "../question-update-event";
import {DescriptionModalComponent} from "../common/description.component";
import {EnumValues} from "enum-values"
import {QuestionType} from "../../models/question-type";

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
    editMode: boolean = false;

    @Input()
    item: Question;

    @Output()
    itemRemove = new EventEmitter<number>();

    @Output()
    itemUpdated = new EventEmitter<QuestionUpdatedEvent>();

    @ViewChild('descriptionModal')
    descriptionModal: DescriptionModalComponent;

    currentOption: Option = null;

    isCollapsed: boolean = false;

    status:{isopen:boolean} = {isopen: false};

    types: Array<number>;

    constructor() {
        this.types = EnumValues.getValues(QuestionType);
    }

    getTypeLabelByValue(value: number) {
        switch (value) {
            case QuestionType.SINGLE:
                return 'Single';
            case QuestionType.MULTIVALUE:
                return 'Multivalue';
            case QuestionType.TRUE_FALSE:
                return 'true/false';
        }

        return '---'
    }

    removeClicked() {
        this.itemRemove.emit(this.index);
    }

    enterEditMode(element: HTMLInputElement) {
        this.editMode = true;
        if (this.editMode) {
            setTimeout(() => { element.focus(); }, 0);
        }
    }

    cancelEdit(element: HTMLInputElement) {
        this.editMode = false;
        element.value = this.item.text ? this.item.text : '';

        if (this.isNew) {
            this.itemRemove.emit();
        }
    }

    commitEdit(updatedItem: Question, text: string) {
        this.editMode = false;
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

    showDescription() {
        this.descriptionModal.open();
    }
}
