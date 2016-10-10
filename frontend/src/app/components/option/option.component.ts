import {
    Component, Input, ChangeDetectionStrategy, Output,
    EventEmitter
} from '@angular/core';
import {Option} from "../../models/option";
import OptionUpdatedEvent from "../option-update-event";

@Component({
    selector: 'option-item',
    templateUrl: 'option.component.html',
    styleUrls: ['option.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class OptionComponent {
    @Input()
    isNew = false;

    @Input()
    editMode = false;

    @Input()
    item: Option;

    @Input()
    index?: number;

    @Output()
    itemRemove = new EventEmitter<number>();

    @Output()
    itemUpdated = new EventEmitter<OptionUpdatedEvent>();

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
        element.value = this.item.text;

        if (this.isNew) {
            this.itemRemove.emit();
        }
    }

    commitEdit(updatedItem: Option, text: string) {
        this.editMode = false;
        updatedItem.text = text;
        this.itemUpdated.emit({
            item: updatedItem,
            isNew: this.isNew
        });
    }
}
