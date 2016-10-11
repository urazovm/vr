import {Component, ViewEncapsulation} from '@angular/core';
import {TranslateService} from 'ng2-translate'
import {Title} from "@angular/platform-browser";

@Component({
    selector: 'vash-rekrut',
    template: '<header (changeLang)="onLanguageChanged($event)"></header><router-outlet></router-outlet><footer-sticky></footer-sticky>',
    styleUrls: ['app.scss'],
    encapsulation: ViewEncapsulation.None
})
export class AppComponent {
    name = 'vash-rekrut';

    constructor(private translate: TranslateService, private titleService: Title) {
        var userLang = navigator.language.split('-')[0]; // use navigator lang if available
        userLang = /(ru|en)/gi.test(userLang) ? userLang : 'en';

        // this language will be used as a fallback when a translation isn't found in the current language
        translate.setDefaultLang('en');

        this.onLanguageChanged(userLang);
    }

    onLanguageChanged(event: string) {
        if (event && event != '') {
            this.translate.use(event);
            this.translate.get('app_title').subscribe((title: string) => {
                this.titleService.setTitle(title);
            });
        }
    }
}
