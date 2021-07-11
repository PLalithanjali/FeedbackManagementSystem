import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { AddCourseComponent } from './course/add-course/add-course.component';
import { UpdateCourseComponent } from './course/update-course/update-course.component';
import { DeleteCourseComponent } from './course/delete-course/delete-course.component';
import { ListCourseComponent } from './course/list-course/list-course.component';
import { ViewCourseComponent } from './course/view-course/view-course.component';
import { UpdateFeedbackComponent } from './feedback/update-feedback/update-feedback.component';
import { ViewProgramFeedbackComponent } from './feedback/view-program-feedback/view-program-feedback.component';
import { ViewTrainerFeedbackComponent } from './feedback/view-trainer-feedback/view-trainer-feedback.component';
import { AddParticipantComponent } from './participant/add-participant/add-participant.component';
import { EnrollParticipantComponent } from './participant/enroll-participant/enroll-participant.component';
import { ListParticipantComponent } from './participant/course-list-participant/list-participant.component';
import { AddProgramComponent } from './program/add-program/add-program.component';
import { UpdateProgramComponent } from './program/update-program/update-program.component';
import { DeleteProgramComponent } from './program/delete-program/delete-program.component';
import { ListProgramComponent } from './program/list-program/list-program.component';
import { ViewProgramComponent } from './program/view-program/view-program.component';
import { ViewProgramBydateComponent } from './program/view-program-bydate/view-program-bydate.component';
import { HeaderComponent } from './header/header.component';
import { AddSkillComponent } from './skill/add-skill/add-skill.component';
import { UpdateSkillComponent } from './skill/update-skill/update-skill.component'; 
import { DeleteSkillComponent } from './skill/delete-skill/delete-skill.component';
import { ListSkillComponent } from './skill/list-skill/list-skill.component';
import { AddTrainerComponent } from './trainer/add-trainer/add-trainer.component';
import { UpdateTrainerComponent } from './trainer/update-trainer/update-trainer.component';
import { ListTrainerComponent } from './trainer/list-trainer/list-trainer.component';
import { FormsModule, FormGroup } from '@angular/forms';
import { LogoutComponent } from './login/logout/logout.component';
import { HomeComponent } from './login/home/home.component';
import { HomeCourseComponent } from './course/home-course/home-course.component';
import { HomeFeedbackComponent } from './feedback/home-feedback/home-feedback.component';
import { HomeProgramComponent } from './program/home-program/home-program.component';
import { HomeSkillComponent } from './skill/home-skill/home-skill.component';
import { HomeTrainerComponent } from './trainer/home-trainer/home-trainer.component';
import { HomeAdminComponent } from './login/home-admin/home-admin.component';

import { MatSidenavModule} from '@angular/material/sidenav';
import { MatCardModule} from '@angular/material/card';
import { MatToolbarModule} from '@angular/material/toolbar';
import { DeleteTrainerComponent } from './trainer/delete-trainer/delete-trainer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidebarComponent } from './header/sidebar/sidebar.component'
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatIconModule} from '@angular/material/icon';
import { ListDefaultersReportComponent } from './feedback/list-defaulters-report/list-defaulters-report.component';
import { HomeParticipantComponent } from './login/home-participant/home-participant.component';
import { HomeCoordinatorComponent } from './login/home-coordinator/home-coordinator.component';
import { AddSkillsTrainerComponent } from './trainer/add-skills-trainer/add-skills-trainer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddCourseComponent,
    UpdateCourseComponent,
    DeleteCourseComponent,
    ListCourseComponent,
    ViewCourseComponent,
    UpdateFeedbackComponent,
    ViewProgramFeedbackComponent,
    ViewTrainerFeedbackComponent,
    AddParticipantComponent,
    EnrollParticipantComponent,
    ListParticipantComponent,
    AddProgramComponent,
    UpdateProgramComponent,
    DeleteProgramComponent,
    ListProgramComponent,
    ViewProgramComponent,
    ViewProgramBydateComponent,
    HeaderComponent,
    AddSkillComponent,
    UpdateSkillComponent,
    DeleteSkillComponent,
    ListSkillComponent,
    AddTrainerComponent,
    UpdateTrainerComponent,
    ListTrainerComponent,
    LogoutComponent,
    HomeComponent,
    HomeCourseComponent,
    HomeFeedbackComponent,
    HomeProgramComponent,
    HomeSkillComponent,
    HomeTrainerComponent,
    HomeAdminComponent,
    DeleteTrainerComponent,
    SidebarComponent,
    ListDefaultersReportComponent,
    HomeParticipantComponent,
    HomeCoordinatorComponent,
    AddSkillsTrainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSidenavModule,
    MatCardModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatRadioModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
