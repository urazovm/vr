import {Component, Output, EventEmitter} from '@angular/core';

@Component({
    selector: 'header',
    templateUrl: 'header.html',
    styleUrls: ['header.scss']
})
export class HeaderComponent {
    @Output()
    changeLang = new EventEmitter<string>();

    changeLanguage(lang: string) {
        this.changeLang.emit(lang);
    }
}