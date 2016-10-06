import {Component} from '@angular/core';
import {Account} from "../../models/account";

@Component({
    selector: 'profile',
    templateUrl: 'profile.component.html',
    styleUrls: ['profile.component.scss']
})
export class ProfileComponent {
    private _account: Account;
    private _subscription;
}
