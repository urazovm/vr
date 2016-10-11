import {Component, Input, ViewChild} from "@angular/core";
import {ModalComponent} from "ng2-bs4-modal/components/modal";

@Component ({
        selector: 'description-item',
        templateUrl: 'description.component.html',
        styleUrls: ['description.component.scss'],
    })
export class DescriptionModalComponent {
    @Input()
    item: any;

    @ViewChild('descriptionModal')
    descriptionModal: ModalComponent;

    open() {
        this.descriptionModal.open();
    }
}