import {NgModule, CUSTOM_ELEMENTS_SCHEMA, enableProdMode} from '@angular/core';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CarouselModule, DropdownModule, Ng2BootstrapModule, PaginationModule, TabsModule} from "ng2-bootstrap";
import {HttpModule} from "@angular/http";
import {ModalModule} from "ng2-bs4-modal"

import {AppComponent} from './app.component';
import {HelloComponent} from './pages/hello/hello.component';
import {HomeComponent} from './pages/home/home.component';
import {ExaminationDashboardComponent} from "./pages/examination/examination-dashboard.component";
import {routing} from "./app.routes";
import {platformBrowserDynamic} from "@angular/platform-browser-dynamic";
import {ExaminationDetailComponent} from "./pages/examination/examination-detail.component";
import {FooterComponent} from "./facets/footer/footer";
import {HeaderComponent} from "./facets/header/header";
import {MainCarousel} from "./facets/carousel/main-carousel";
import {ProfileComponent} from "./pages/profile/profile.component";
import {ExaminationEditComponent} from "./pages/examination/edit/examination-edit.component";

@NgModule({
    declarations: [
        AppComponent,
        HelloComponent,
        HomeComponent,
        ExaminationDashboardComponent,
        ExaminationDetailComponent,
        FooterComponent,
        HeaderComponent,
        MainCarousel,
        ProfileComponent,
        ExaminationEditComponent
    ],
    imports: [
        Ng2BootstrapModule,
        BrowserModule,
        ModalModule,
        HttpModule,
        FormsModule,
        ReactiveFormsModule,
        CarouselModule,
        DropdownModule,
        PaginationModule,
        TabsModule,
        routing],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    providers: [
        {provide: LocationStrategy, useClass: HashLocationStrategy}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}

enableProdMode()
platformBrowserDynamic().bootstrapModule(AppModule);
