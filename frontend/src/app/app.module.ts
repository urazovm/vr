import {NgModule, CUSTOM_ELEMENTS_SCHEMA, enableProdMode} from "@angular/core";
import {LocationStrategy, HashLocationStrategy} from "@angular/common";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {
    CarouselModule,
    DropdownModule,
    Ng2BootstrapModule,
    PaginationModule,
    TabsModule,
    CollapseModule
} from "ng2-bootstrap";
import {TranslateModule, TranslateLoader, TranslateStaticLoader} from "ng2-translate";
import {HttpModule, Http} from "@angular/http";
import {ModalModule} from "ng2-bs4-modal";
import {AppComponent} from "./app.component";
import {HelloComponent} from "./pages/hello/hello.component";
import {HomeComponent} from "./pages/home/home.component";
import {ExaminationDashboardComponent} from "./pages/examination/examination-dashboard.component";
import {routing} from "./app.routes";
import {platformBrowserDynamic} from "@angular/platform-browser-dynamic";
import {ExaminationDetailComponent} from "./pages/examination/examination-detail.component";
import {FooterComponent} from "./facets/footer/footer";
import {HeaderComponent} from "./facets/header/header";
import {MainCarousel} from "./facets/carousel/main-carousel";
import {ProfileComponent} from "./pages/profile/profile.component";
import {ExaminationEditComponent} from "./pages/examination/edit/examination-edit.component";
import {QuestionsTab} from "./pages/examination/edit/questions-tab";
import {OptionComponent} from "./components/option/option.component";
import {QuestionComponent} from "./components/question/question.component";
import {DescriptionModalComponent} from "./components/common/description.component";

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
        ExaminationEditComponent,
        QuestionsTab,
        QuestionComponent,
        OptionComponent,
        DescriptionModalComponent
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
        CollapseModule,
        TranslateModule.forRoot({
            provide: TranslateLoader,
            useFactory: (http: Http) => new TranslateStaticLoader(http, '/assets/i18n', '.json'),
            deps: [Http]
        }),
        routing],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    providers: [
        {provide: LocationStrategy, useClass: HashLocationStrategy}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}

enableProdMode();
platformBrowserDynamic().bootstrapModule(AppModule);
