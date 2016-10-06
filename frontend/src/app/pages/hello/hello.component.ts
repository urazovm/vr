import {Component} from '@angular/core';
import {HelloService, UserJson} from '../../services/hello.service';

@Component({
    selector: 'hello',
    templateUrl: 'hello.component.html',
    styleUrls: ['hello.scss'],
    providers: [HelloService]
})
export class HelloComponent {

    // vars
    public currentUser: UserJson;
    private _subscription;

    // constructor
    constructor(private _helloService: HelloService) {
        this.currentUser = new UserJson();
    }

    // on-init
    ngOnInit() {
        // save _subscription

        this._subscription = this._helloService.login("userLogin")
            .subscribe(
                (data) => {
                    this.currentUser = data;
                },
                (err) => console.log(err),
                () => console.log('user successfully loaded')
            );
    }

    // on-destroy
    ngOnDestroy() {
        // unsubscribe
        this._subscription.unsubscribe();
    }
}
