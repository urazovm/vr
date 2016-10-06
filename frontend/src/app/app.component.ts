import {Component, ViewEncapsulation} from '@angular/core';

@Component({
    selector: 'vash-rekrut',
    template: '<router-outlet></router-outlet>',
    styleUrls: ['app.scss'],
    encapsulation: ViewEncapsulation.None
})
export class AppComponent {
    name = 'vash-rekrut';
}
