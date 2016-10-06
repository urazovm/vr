import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from "@angular/core";

import {HelloComponent} from './pages/hello/hello.component';
import {HomeComponent} from './pages/home/home.component';
import {ExaminationDetailComponent} from "./pages/examination/examination-detail.component";
import {ProfileComponent} from "./pages/profile/profile.component";
import {ExaminationEditComponent} from "./pages/examination/edit/examination-edit.component";

const appRoutes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'hello', component: HelloComponent},
    {path: 'examination/:id', component: ExaminationDetailComponent},
    {path: 'examination', component: ExaminationEditComponent},
    {path: 'questions/:id', component: ExaminationDetailComponent},
    {path: 'profile', component: ProfileComponent}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);